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
import com.example.chanllegevitrinova.Model.Categories.Categori
import com.example.chanllegevitrinova.R

class CategoriesAdapter (var context:Context,var categoriList:ArrayList<Categori>) :RecyclerView.Adapter<CategoriesAdapter.CategoriHolder> (){
    var lastPosition:Int=-1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriHolder {
        val view:View=LayoutInflater.from(context).inflate(R.layout.categories_list_item,parent,false)

        return CategoriHolder(view)
    }

    override fun getItemCount(): Int {
        return categoriList.size
    }

    override fun onBindViewHolder(holder: CategoriHolder, position: Int) {
        if (context is MainActivity)
        setAnimation(holder.relative_categories,position)
        holder.categoriname.text=categoriList.get(position).name?.toUpperCase()
        holder.categories_image.setColorFilter(ContextCompat.getColor(context, R.color.imageview_tint2), android.graphics.PorterDuff.Mode.MULTIPLY)
        Glide.with(context).load(categoriList.get(position).logo?.thumbnail?.url).into(holder.categories_image)
    }
    fun setAnimation(viewToAnimate: View, position: Int) {
        if(position > lastPosition) {
            val animation = AnimationUtils.loadAnimation(context, R.anim.item_animation_from_right)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }

    class CategoriHolder(view: View) :RecyclerView.ViewHolder(view) {
        val relative_categories:RelativeLayout=view.findViewById(R.id.relative_categories)
        val categoriname:TextView=view.findViewById(R.id.categoriname)
        val categories_image:ImageView=view.findViewById(R.id.categories_image)
    }
}