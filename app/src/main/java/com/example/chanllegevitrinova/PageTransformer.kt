package com.example.chanllegevitrinova

import android.view.View
import android.widget.ImageView
import androidx.viewpager.widget.ViewPager

open class PageTransformer : ViewPager.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        val pageWidth = page.getWidth()


        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            page.alpha=1.0F

        } else if (position <= 1) { // [-1,1]

            page.findViewById<ImageView>(R.id.imageview_featured_item).translationX=-position*(pageWidth/2)
        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            page.alpha=1.0F
        }

    }
}