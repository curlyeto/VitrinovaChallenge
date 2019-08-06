package com.example.chanllegevitrinova.Adpater
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chanllegevitrinova.Activity.MainActivity
import com.example.chanllegevitrinova.Model.Collections.Collection
import com.example.chanllegevitrinova.R

class CollectionAdapter (var context:Context,var collectionList:ArrayList<Collection>)
    : RecyclerView.Adapter<CollectionAdapter.CollectionHolder>() {
    var lastPosition:Int=-1
    private lateinit var view:View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionHolder {

     view=LayoutInflater.from(context).inflate(R.layout.collection_list_item,parent,false)

      return  CollectionHolder(view)
    }

    override fun getItemCount(): Int {
      return  collectionList.size
    }

    override fun onBindViewHolder(holder: CollectionHolder, position: Int) {
        if (context is MainActivity)
       setAnimation(holder.relative_collection,position, R.anim.item_animation_from_right)
        else
            setAnimation(holder.relative_collection,position, R.anim.item_animation_from_bottom)
       holder.collection_image_title.text=collectionList.get(position).title
       holder.collection_definition.text=collectionList.get(position).definition
       holder.imageview_colletion.setColorFilter(ContextCompat.getColor(context, R.color.imageview_tint), android.graphics.PorterDuff.Mode.MULTIPLY)
       Glide.with(context).load(collectionList.get(position).cover?.url).into(holder.imageview_colletion)
    }
    fun setAnimation(viewToAnimate: View, position: Int,animation:Int) {
        if(position > lastPosition) {
            val animation = AnimationUtils.loadAnimation(context, animation)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }

    class CollectionHolder(view:View) :RecyclerView.ViewHolder(view) {
        val relative_collection:RelativeLayout=view.findViewById(R.id.relative_collection)
        val imageview_colletion:ImageView=view.findViewById(R.id.imageview_colletion)
        val collection_image_title:TextView=view.findViewById(R.id.collection_image_title)
        val collection_definition:TextView=view.findViewById(R.id.collection_definition)
    }
}