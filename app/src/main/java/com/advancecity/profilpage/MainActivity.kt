package com.advancecity.profilpage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.advancecity.profilpage.Adapters.RecyclerViewGridAdapter
import com.advancecity.profilpage.Adapters.RecyclerViewHorizontalListAdapter
import com.advancecity.profilpage.Interface.ProfilePageAPI
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import android.widget.Toast
import com.advancecity.profilpage.Models.*
import com.squareup.picasso.Picasso
import io.reactivex.Single
import io.reactivex.functions.Function3


class MainActivity : AppCompatActivity() {

    private val BASE_URL = "http://34.214.102.117/api/values/"
    private var followersAdapter: RecyclerViewHorizontalListAdapter? = null
    private var moviesAdapter: RecyclerViewGridAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val userObservable = retrofit
                .create(ProfilePageAPI::class.java)
                .getUser()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())

        val followersObservable = retrofit
                .create(ProfilePageAPI::class.java)
                .getFollowers()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())

        val moviesObservable = retrofit
                .create(ProfilePageAPI::class.java)
                .getMovies()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())

        userObservable
                .flatMap { response ->
                    initUser(response)
                    return@flatMap followersObservable }
                .flatMap { response ->
                    initFollowersRecycleView(response)
                    return@flatMap moviesObservable }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                        { response ->

                            initMoviesRecycleView(response)
                        },
                        { err -> Log.v("TAG", err.localizedMessage)
                        },
                        { Log.v("TAG", "Chains Completed") }
                )

    }

    private fun initUser(response: ResponseUser) {
        Picasso.with(this).load(response.result!!.profilePictureUrl).into(userPicture);
        userName.setText(response.result!!.username)


    }


    private fun initMoviesRecycleView(response:ResponseMoviesCollection) {
        movies!!.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        moviesAdapter = RecyclerViewGridAdapter(response.result!!.items!!, this)
        val gridLayoutManager = GridLayoutManager(this, 3)
        movies!!.layoutManager = gridLayoutManager
        movies!!.adapter = moviesAdapter

        fun popular(p: Movies): Int? = p.likeCount
        fun recent(p: Movies): String? = p.createDate

        textView3.setOnClickListener{
            response.result!!.items!!.sortedByDescending { popular(it) }
            movies!!.adapter.notifyDataSetChanged()
        }
        textView4.setOnClickListener{
            response.result!!.items!!.sortedByDescending { recent(it) }
            movies!!.adapter.notifyDataSetChanged()
        }


    }

    private fun initFollowersRecycleView(response:ResponseFollowersCollection) {
        followers!!.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL))
        followersAdapter = RecyclerViewHorizontalListAdapter(response.result!!.items!!, this)
        val horizontalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        followers!!.layoutManager = horizontalLayoutManager
        followers!!.adapter = followersAdapter
    }
}
