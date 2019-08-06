package com.example.chanllegevitrinova.Adpater

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chanllegevitrinova.Activity.MainActivity
import com.example.chanllegevitrinova.Products
import com.example.chanllegevitrinova.R
import kotlin.collections.ArrayList

class ProductsAdapter (var context:Context,var productList:ArrayList<Products>) :RecyclerView.Adapter<ProductsAdapter.ProductsHolder> (){
    var lastPosition:Int=-1
    private lateinit var view:View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsHolder {

        if(context is MainActivity){
            view=LayoutInflater.from(context).inflate(R.layout.product_list_item,parent,false)
        }else {
            view=LayoutInflater.from(context).inflate(R.layout.product_tumu_list_item,parent,false)
        }



        return ProductsHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }


    @SuppressLint("StringFormatMatches")
    override fun onBindViewHolder(holder: ProductsHolder,position: Int) {

        if(context is MainActivity){
            setAnimation(holder.relative_product,position,R.anim.item_animation_from_right)
        }else{
            setAnimation(holder.relative_product,position,R.anim.item_animation_from_bottom)
        }
        holder.productstitle.text=productList.get(position).title
        holder.productsname.text= productList.get(position).shop?.name
        holder.products_old_price.text=context.getString(R.string.old_price,productList.get(position).oldPrice)
        holder.produtsprice.text=context.getString(R.string.price,productList.get(position).price)

        holder.products_old_price.paintFlags =holder.products_old_price.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

        if (productList.get(position).oldPrice.toString()=="null"){
            holder.products_old_price.visibility=View.INVISIBLE
        }

        holder.imageview_products.setColorFilter(ContextCompat.getColor(context, R.color.imageview_tint2), android.graphics.PorterDuff.Mode.MULTIPLY)
        Glide.with(context).load(productList.get(position).images?.get(0)?.productsThumbnail?.url).into(holder.imageview_products)


    }
    fun setAnimation(viewToAnimate: View, position: Int, animation: Int) {

            val animation = AnimationUtils.loadAnimation(context,animation)
            viewToAnimate.startAnimation(animation)
            lastPosition = position

    }

    class ProductsHolder (view :View) :RecyclerView.ViewHolder(view){
        var imageview_products:ImageView=view.findViewById(R.id.imageview_products)
        var productstitle:TextView=view.findViewById(R.id.productstitle)
        var productsname:TextView=view.findViewById(R.id.productsname)
        var produtsprice:TextView=view.findViewById(R.id.produtsprice)
        var products_old_price:TextView=view.findViewById(R.id.products_old_price)
        var relative_product:RelativeLayout=view.findViewById(R.id.relative_product)


    }




}

