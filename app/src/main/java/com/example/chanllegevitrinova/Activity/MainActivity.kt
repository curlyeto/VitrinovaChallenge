package com.example.chanllegevitrinova.Activity

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.chanllegevitrinova.*
import com.example.chanllegevitrinova.Adpater.*
import com.example.chanllegevitrinova.Model.AllVitrin
import com.example.chanllegevitrinova.Model.Categories.Categori
import com.example.chanllegevitrinova.Model.Collections.Collection
import com.example.chanllegevitrinova.Model.Editor.Editor
import com.example.chanllegevitrinova.R.*
import com.example.chanllegevitrinova.viewmodel.RetrofitService
import com.example.chanllegevitrinova.viewmodel.VitrinViewModel
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.CubeGrid
import com.github.ybq.android.spinkit.style.DoubleBounce
import com.github.ybq.android.spinkit.style.ThreeBounce
import com.quinny898.library.persistentsearch.SearchBox
import com.quinny898.library.persistentsearch.SearchResult
import kotlinx.android.synthetic.main.activity_main.*
import me.relex.circleindicator.CircleIndicator
import kotlin.collections.ArrayList
import kotlin.collections.List as List1

class MainActivity : AppCompatActivity(),View.OnClickListener{
    lateinit var vitrinModel: VitrinViewModel
    lateinit var viewPager:ViewPager
    private lateinit var featuredAdapter: FeaturedAdapter
    lateinit var searchbox: SearchBox
    private lateinit var backgroundImageview: ImageView
    var shopList: List1<Editor>? = null
    //sliderIndicator
    var currentpage:Int=0
    var indicatorsize:Int = 0
    lateinit var listprocduct:ArrayList<Products>
    lateinit var listcolletion:ArrayList<Collection>
    lateinit var listeditor:ArrayList<Editor>
    lateinit var listvitrin:ArrayList<Editor>
    val snapHelper=LinearSnapHelper()
    var pos:Int = 0
    lateinit var linearLayoutManager: LinearLayoutManager

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        searchbox=findViewById(R.id.searchbox)
        val progressBar:ProgressBar=findViewById(R.id.spin_kit)
        val cubeGrid:CubeGrid= CubeGrid()
        progressBar.indeterminateDrawable=cubeGrid

        searchbox.enableVoiceRecognition(this)
        searchbox.setLogoText("  Search products")

        backgroundImageview=findViewById(id.image_background)

        viewPager=findViewById(id.viewpager)
        var circleIndicator:CircleIndicator=findViewById(id.Slider)

        vitrinModel= ViewModelProviders.of(this@MainActivity).get(VitrinViewModel::class.java)

        vitrinModel.getVitrin()?.observe(this, Observer<List1<AllVitrin>>{
            vitrinList ->

            linear_main.visibility = View.VISIBLE
            progressBar.visibility=View.GONE

            listprocduct=vitrinList[1].products as ArrayList<Products>
            listcolletion=vitrinList[3].collection as ArrayList<Collection>
            listeditor=vitrinList[4].editor as ArrayList<Editor>
            listvitrin=vitrinList[5].editor as ArrayList<Editor>

            //Slider
            featuredAdapter = FeaturedAdapter(this, vitrinList[0].featured as ArrayList<Featured>)
            viewPager.adapter=featuredAdapter
            viewPager.setPageTransformer(false, PageTransformer())
            featuredtitle.text= (vitrinList[0].featured as ArrayList<Featured>)[0].featuredtitle
            featuredsub_title.text= (vitrinList[0].featured as ArrayList<Featured>)[0].featuredsubtitle
            circleIndicator.setViewPager(viewPager)
            indicatorsize=vitrinList.get(0).featured!!.size
            SliderIndicator()

            //Products
            products_title.text= vitrinList[1].title?.toUpperCase()
            setupRecyclerview(recyclerproducts)
            recyclerproducts.adapter=ProductsAdapter(this@MainActivity,vitrinList[1].products as ArrayList<Products>)

            //Categories
            categories_title.text=vitrinList.get(2).title?.toUpperCase()
            setupRecyclerview(recyclerviewcategories)
            recyclerviewcategories.adapter=CategoriesAdapter(this@MainActivity,vitrinList[2].categori as ArrayList<Categori>)

            //Collections
            collection_title.text=vitrinList.get(3).title?.toUpperCase()
            setupRecyclerview(reclerviewcolection)
            reclerviewcolection.adapter=CollectionAdapter(this@MainActivity,vitrinList[3].collection as ArrayList<Collection>)

            //Editor
            editor_title.text=vitrinList.get(4).title?.toUpperCase()
            //setup recycler
            val animation:LayoutAnimationController=AnimationUtils.loadLayoutAnimation(applicationContext, anim.item_animation_right_call)
            linearLayoutManager= LinearLayoutManager(this@MainActivity,RecyclerView.HORIZONTAL,false)
            recyclereditor.layoutManager = linearLayoutManager as RecyclerView.LayoutManager?
            recyclereditor.setPadding(110,0,110,0)
            recyclereditor.layoutAnimation=animation
            recyclereditor.scheduleLayoutAnimation()
            recyclereditor.adapter=EditorRecyclerAdapter(this@MainActivity,vitrinList[4].editor as ArrayList<Editor>)
            shopList=vitrinList[4].editor
            backgroundImageview.setColorFilter(ContextCompat.getColor(applicationContext, R.color.imageview_tint), android.graphics.PorterDuff.Mode.MULTIPLY)
            Glide.with(applicationContext).load(shopList?.get(0)?.cover?.url).into(backgroundImageview)
            snapHelper.attachToRecyclerView(recyclereditor)


            //Vitrin
            vitrin_title.text=vitrinList.get(5).title?.toUpperCase()
            setupRecyclerview(recyclervitrin)
            recyclervitrin.adapter=VitrinAdapter(this@MainActivity,vitrinList[5].editor as ArrayList<Editor>)
        })

        recyclereditor.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState==RecyclerView.SCROLL_STATE_IDLE){
                    val view1=snapHelper.findSnapView(linearLayoutManager)
                    pos=linearLayoutManager.getPosition(view1!!)
                    Log.d("SnappedItem",""+pos)
                }
                backgroundImageview.setColorFilter(ContextCompat.getColor(applicationContext, R.color.imageview_tint), android.graphics.PorterDuff.Mode.MULTIPLY)
                Glide.with(applicationContext).load(shopList?.get(pos)?.cover?.url).into(backgroundImageview)
            }
        })
        products_tumu.setOnClickListener(this)
        colletion_tumu.setOnClickListener(this)
        editor_tumu.setOnClickListener(this)
        vitrin_tumu.setOnClickListener(this)

        searchbox.setSearchListener(object: SearchBox.SearchListener{
            override fun onSearchClosed() {
                Log.d("TAG","onSearchClosed")
            }

            override fun onSearch(p0: String?) {
                Log.d("TAG",p0+"Searched")

            }

            override fun onResultClick(p0: SearchResult?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onSearchCleared() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onSearchTermChanged(p0: String?) {
                Log.d("TAG","onSearchTermChanged")
            }

            override fun onSearchOpened() {
                Log.d("TAG","Searched")
            }
        })
        swiperefresh.setOnRefreshListener (object : SwipeRefreshLayout.OnRefreshListener{
            override fun onRefresh() {
                vitrinModel.refreshData()
                linear_main.visibility=View.INVISIBLE
                swiperefresh.isRefreshing=false
            }
        })
    }
    override fun onClick(p0: View?) {
        val viewid=p0!!.id
        when(viewid){
            R.id.products_tumu -> {
                val intent:Intent= Intent(applicationContext, ProductTumuActivity::class.java)
                intent.putParcelableArrayListExtra("product",listprocduct)
                startActivity(intent)
                overridePendingTransition(R.anim.item_animation_from_right,R.anim.activity_animation_left)
            }
            R.id.colletion_tumu -> {
                val intent:Intent= Intent(applicationContext, CollectionTumuActivity::class.java)
                intent.putParcelableArrayListExtra("collection",listcolletion)
                startActivity(intent)
                overridePendingTransition(R.anim.item_animation_from_right,R.anim.activity_animation_left)
            }
            R.id.editor_tumu -> {
                val intent:Intent= Intent(applicationContext, EditorTumuActivity::class.java)
                intent.putParcelableArrayListExtra("editor",listeditor)
                startActivity(intent)
                overridePendingTransition(R.anim.item_animation_from_right,R.anim.activity_animation_left)
            }
            R.id.vitrin_tumu -> {
                val intent:Intent= Intent(applicationContext, VitrinTumuActivity::class.java)
                intent.putParcelableArrayListExtra("vitrin",listvitrin)
                startActivity(intent)
                overridePendingTransition(R.anim.item_animation_from_right,R.anim.activity_animation_left)
            }
        }
    }

    private fun setupRecyclerview(recyclerView: RecyclerView){
        val animation:LayoutAnimationController=AnimationUtils.loadLayoutAnimation(applicationContext, anim.item_animation_right_call)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.layoutAnimation=animation
        recyclerView.scheduleLayoutAnimation()
    }

override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    if (requestCode == 1234 && resultCode == Activity.RESULT_OK) {

        val matches = data!!.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
        if (!matches!!.isEmpty()) {
            val Query = matches[0]
            searchbox.setLogoText(Query)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}

    private fun SliderIndicator(){

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected (position: Int) {
                currentpage=position
            }
            override fun onPageScrollStateChanged(state: Int) {
                if (state==ViewPager.SCROLL_STATE_IDLE){
                    var pagercount:Int=indicatorsize
                    if (currentpage==pagercount-state){
                        viewPager.setCurrentItem(0,false)
                    }
                }
            }

        })
    }
}


