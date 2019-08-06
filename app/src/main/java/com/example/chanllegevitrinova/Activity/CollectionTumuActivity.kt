package com.example.chanllegevitrinova.Activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chanllegevitrinova.Adpater.CollectionAdapter
import com.example.chanllegevitrinova.Model.Collections.Collection
import com.example.chanllegevitrinova.Products
import com.example.chanllegevitrinova.R
import kotlinx.android.synthetic.main.activity_collection_tumu.*

class CollectionTumuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collection_tumu)
        setSupportActionBar(toolbarcollection)
        this.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        val collectionList= intent.getParcelableArrayListExtra<Parcelable>("collection") as ArrayList<Collection>
        setupRecyclerview(recyclercollectiontumu)
        recyclercollectiontumu.adapter=CollectionAdapter(this@CollectionTumuActivity,collectionList)
    }
    @SuppressLint("WrongConstant")
    private fun setupRecyclerview(recyclerView: RecyclerView){
        val animation: LayoutAnimationController = AnimationUtils.loadLayoutAnimation(applicationContext, R.anim.item_animation_bottom_call)
        recyclerView.layoutManager = LinearLayoutManager(this@CollectionTumuActivity,LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutAnimation=animation
        recyclerView.scheduleLayoutAnimation()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
