package com.example.chanllegevitrinova.Adpater
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chanllegevitrinova.Activity.MainActivity
import com.example.chanllegevitrinova.Model.Editor.Editor
import com.example.chanllegevitrinova.R

class EditorRecyclerAdapter(var context:Context,var editorList:ArrayList<Editor>)
    : RecyclerView.Adapter<EditorRecyclerAdapter.EditorHolder>() {
    lateinit var view: View
    var lastPosition:Int=-1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditorHolder {
             view= LayoutInflater.from(context).inflate(R.layout.editor_lit_item, parent, false)
        return EditorHolder(view)
    }

    override fun getItemCount(): Int {
        return editorList.size
    }

    override fun onBindViewHolder(holder: EditorHolder, position: Int) {
        setAnimation(holder.relative_editor,position)
        holder.editor_name.text=editorList.get(position).name
        holder.editor_definiton.text=editorList.get(position).definition
        Glide.with(context).load(editorList.get(position).logo?.medium?.url).into(holder.imageview_logo)
        Glide.with(context).load(editorList.get(position).popularProducts?.get(0)?.images?.get(0)?.thumbnail?.url).into(holder.editorimage)
        Glide.with(context).load(editorList.get(position).popularProducts?.get(1)?.images?.get(0)?.thumbnail?.url).into(holder.editorimage1)
        Glide.with(context).load(editorList.get(position).popularProducts?.get(2)?.images?.get(0)?.thumbnail?.url).into(holder.editorimage2)




    }
    fun setAnimation(viewToAnimate: View, position: Int) {
        if(position > lastPosition) {
            val animation = AnimationUtils.loadAnimation(context, R.anim.item_animation_from_right)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }

    class EditorHolder(view:View) : RecyclerView.ViewHolder(view){
        val imageview_logo: ImageView =view.findViewById(R.id.imageview_logo)
        val editor_name: TextView =view.findViewById(R.id.editor_name)
        val editor_definiton: TextView =view.findViewById(R.id.editor_definiton)
        val editorimage: ImageView =view.findViewById(R.id.editorimage)
        val editorimage1: ImageView =view.findViewById(R.id.editorimage1)
        val editorimage2: ImageView =view.findViewById(R.id.editorimage2)
        val relative_editor:RelativeLayout=view.findViewById(R.id.relative_editor)

    }
}