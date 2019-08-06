package com.example.chanllegevitrinova.Adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Context
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.chanllegevitrinova.Featured
import com.example.chanllegevitrinova.R


class FeaturedAdapter(var context :Context,var featuredList:ArrayList<Featured>?) : PagerAdapter() {

    lateinit var layoutInflater:LayoutInflater

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object`
    }

    override fun getCount(): Int {
    return featuredList!!.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater= context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view:View=layoutInflater.inflate(R.layout.featured_list_item,null)

        val imageView:ImageView=view.findViewById(R.id.imageview_featured_item)
        imageView.setColorFilter(ContextCompat.getColor(context, R.color.imageview_tint2), android.graphics.PorterDuff.Mode.MULTIPLY)
        Glide.with(context).load(featuredList!!.get(position).feturedcover.featuredmedium?.featuredMediumurl).into(imageView)

        val viewPager:ViewPager=container as ViewPager
        viewPager.addView(view,0)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp:ViewPager=container as ViewPager
        val view:View=`object` as View
        vp.removeView(view)
    }
}