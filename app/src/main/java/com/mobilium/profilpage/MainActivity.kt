package com.mobilium.profilpage

import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.mobilium.profilpage.Adapter.ProductRecyclerViewAdapter
import com.mobilium.profilpage.Adapter.SpecifiesRecyclerViewAdapter
import com.mobilium.profilpage.Model.ProductItem
import com.mobilium.profilpage.Model.SpecifyItem
import kotlinx.android.synthetic.main.activity_main.*
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.support.v4.graphics.drawable.DrawableCompat
import android.support.v4.content.res.ResourcesCompat
import iammert.com.expandablelib.ExpandableLayout
import iammert.com.expandablelib.Section
import kotlinx.android.synthetic.main.layout_child.view.*
import kotlinx.android.synthetic.main.layout_parent.view.*
import kotlinx.android.synthetic.main.hediye_child.view.*
import kotlinx.android.synthetic.main.kargo_child.view.*


class MainActivity : AppCompatActivity() {
    private var productArray: ArrayList<ProductItem> = ArrayList<ProductItem>()
    private var specifyArray: ArrayList<SpecifyItem> = ArrayList<SpecifyItem>()
    private var productAdapter: ProductRecyclerViewAdapter? = null
    private var specifyAdapter: SpecifiesRecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()
        initExpandableLayouts()
        initProductRecycleView()
        initSpecifyRecycleView()

    }

    private fun initToolbar() {
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        //CUSTOME ACTIONBAR
        // Specify that tabs should be displayed in the action bar.
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowTitleEnabled(false)
        val mInflater = LayoutInflater.from(this)
        val mCustomView = mInflater.inflate(R.layout.toolbar_layout, null)
        val params = ActionBar.LayoutParams(//Center the textview in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER)

        actionBar.setCustomView(mCustomView, params)
        actionBar.setDisplayShowCustomEnabled(true)

        actionBar.setStackedBackgroundDrawable(ColorDrawable(Color.WHITE))

        actionBar.setBackgroundDrawable(ColorDrawable(Color.WHITE))

        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(false)

        var drawable = ResourcesCompat.getDrawable(resources, R.mipmap.back, null)
        drawable = DrawableCompat.wrap(drawable!!)
        toolbar.navigationIcon = drawable
    }

    private fun initExpandableLayouts() {
        teslimat.setRenderer(object : ExpandableLayout.Renderer<String, String> {
            override fun renderParent(view: View, model: String, isExpanded: Boolean, parentPosition: Int) {
                view.imageView12.setImageResource(if (isExpanded) R.mipmap.righticon else R.mipmap.upicon)
            }

            override fun renderChild(view: View, model: String, parentPosition: Int, childPosition: Int) {
                view.checkBox.performClick()
            }
        })

        val teslimatsection = Section<String, String>()
        val teslimatparent = ""
        val teslimatchild = ""

        teslimatsection.parent = teslimatparent
        teslimatsection.children.add(teslimatchild)
        teslimatsection.expanded = true
        teslimat.addSection(teslimatsection)


        yeniadres.setRenderer(object : ExpandableLayout.Renderer<String, String> {
            override fun renderParent(view: View, model: String, isExpanded: Boolean, parentPosition: Int) {
            }

            override fun renderChild(view: View, model: String, parentPosition: Int, childPosition: Int) {
            }
        })

        val yeniadressection = Section<String, String>()
        val yeniadresparent = ""
        val yeniadreschild = ""

        yeniadressection.parent = yeniadresparent
        yeniadressection.children.add(yeniadreschild)
        yeniadressection.expanded = true
        yeniadres.addSection(yeniadressection)

        kargo.setRenderer(object : ExpandableLayout.Renderer<String, String> {
            override fun renderParent(view: View, model: String, isExpanded: Boolean, parentPosition: Int) {
            }

            override fun renderChild(view: View, model: String, parentPosition: Int, childPosition: Int) {

                view.kargocheck.performClick()
            }
        })

        val kargosection = Section<String, String>()
        val kargoparent = ""
        val kargochild = ""

        kargosection.parent = kargoparent
        kargosection.children.add(kargochild)
        kargosection.expanded = true
        kargo.addSection(kargosection)

        hediye.setRenderer(object : ExpandableLayout.Renderer<String, String> {
            override fun renderParent(view: View, model: String, isExpanded: Boolean, parentPosition: Int) {
            }

            override fun renderChild(view: View, model: String, parentPosition: Int, childPosition: Int) {
                view.hediyecheck.performClick()
            }
        })

        val hediyesection = Section<String, String>()
        val hediyeparent = ""
        val hediyechild = ""

        hediyesection.parent = hediyeparent
        hediyesection.children.add(hediyechild)
        hediyesection.expanded = true
        hediye.addSection(hediyesection)
    }

    private fun initProductRecycleView() {

        val item1 = ProductItem("V Yaka Uzun Elbise", "18YOX-POLASBISE", "1X129,00 TL", R.mipmap.image, R.mipmap.redround, R.mipmap.smallsize)
        val item2 = ProductItem("V Yaka Gömlek", "18YOX-POLASBISE", "1X65,00 TL", R.mipmap.image2, R.mipmap.greyround, R.mipmap.xsize)
        productArray.clear()
        productArray.add(item1)
        productArray.add(item2)

        product!!.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        productAdapter = ProductRecyclerViewAdapter(productArray, this)
        val gridLayoutManager = GridLayoutManager(this, 1)
        product!!.layoutManager = gridLayoutManager
        product!!.adapter = productAdapter

    }

    private fun initSpecifyRecycleView() {

        val item1 = SpecifyItem("Alışverişini 500 TL’ ye tamamla 50 TL kazan", R.mipmap.hediye)
        val item2 = SpecifyItem("90 gün değişim ve iade", R.mipmap.iade)
        val item3 = SpecifyItem("7/24 güvenli alışveriş", R.mipmap.guvenli)
        val item4 = SpecifyItem("Taksit seçenekleri", R.mipmap.taksit)
        val item5 = SpecifyItem("100 TL ve üzeri alışverişlerde ücretsiz kargo", R.mipmap.kargo)
        specifyArray.clear()
        specifyArray.add(item1)
        specifyArray.add(item2)
        specifyArray.add(item3)
        specifyArray.add(item4)
        specifyArray.add(item5)

        specify!!.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        specifyAdapter = SpecifiesRecyclerViewAdapter(specifyArray, this)
        val gridLayoutManager = GridLayoutManager(this, 1)
        specify!!.layoutManager = gridLayoutManager
        specify!!.adapter = specifyAdapter

    }
}
