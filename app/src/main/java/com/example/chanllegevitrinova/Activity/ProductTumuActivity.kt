package com.example.chanllegevitrinova.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chanllegevitrinova.Adpater.ProductsAdapter
import com.example.chanllegevitrinova.Products
import com.example.chanllegevitrinova.R
import kotlinx.android.synthetic.main.activity_product_tumu.*


class ProductTumuActivity : AppCompatActivity() {
    private var userModel: ArrayList<Products>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_tumu)
        setSupportActionBar(toolbarproduct)
        this.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)


        val productList= intent.getParcelableArrayListExtra<Parcelable>("product") as ArrayList<Products>
        setupRecyclerview(recyclerproductumu)
        recyclerproductumu.setAdapter(ProductsAdapter(this@ProductTumuActivity,productList))

    }
    private fun setupRecyclerview(recyclerView: RecyclerView){
        recyclerView.layoutManager = GridLayoutManager(this@ProductTumuActivity,2)
        val animation: LayoutAnimationController = AnimationUtils.loadLayoutAnimation(applicationContext, R.anim.item_animation_bottom_call)
        recyclerView.layoutAnimation=animation
        recyclerView.scheduleLayoutAnimation()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==android.R.id.home){
            finish()
            overridePendingTransition(R.anim.item_animation_from_right,R.anim.activity_animation_left)
        }
        return super.onOptionsItemSelected(item)
    }
}
