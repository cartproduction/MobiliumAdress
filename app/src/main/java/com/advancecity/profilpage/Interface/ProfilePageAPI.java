package com.advancecity.profilpage.Interface;

import com.advancecity.profilpage.Models.ResponseFollowersCollection;
import com.advancecity.profilpage.Models.ResponseMoviesCollection;
import com.advancecity.profilpage.Models.ResponseUser;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProfilePageAPI {
    @GET("followers/")
    Observable<ResponseFollowersCollection> getFollowers();
    @GET("movies/")
    Observable<ResponseMoviesCollection> getMovies();
    @GET("member/")
    Observable<ResponseUser> getUser();
}