package com.example.chanllegevitrinova.Adpater
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chanllegevitrinova.Model.Editor.Editor
import com.example.chanllegevitrinova.R
import de.hdodenhof.circleimageview.CircleImageView

class EditorTumuAdapter(var context:Context,var editorTumuList:ArrayList<Editor>)
    : RecyclerView.Adapter<EditorTumuAdapter.EditorTumuHolder>() {
    var lastPosition:Int=-1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditorTumuHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.editor_list_tumu_item,parent,false)
        return EditorTumuHolder(view)
    }

    override fun getItemCount(): Int {
        return editorTumuList.size
    }

    override fun onBindViewHolder(holder: EditorTumuHolder, position: Int) {
        holder.editor_name.text=editorTumuList.get(position).name
        holder.editor_definiton.text=editorTumuList.get(position).definition
        Glide.with(context).load(editorTumuList.get(position).logo?.medium?.url).into(holder.imageview_logo)
        Glide.with(context).load(editorTumuList.get(position).cover?.url).into(holder.editor_imageview)
        holder.editor_productcount.text=editorTumuList.get(position).productCount.toString()

    }
    fun setAnimation(viewToAnimate: View, position: Int) {
        if(position > lastPosition) {
            val animation = AnimationUtils.loadAnimation(context, R.anim.item_animation_from_bottom)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }

    class EditorTumuHolder(view:View) :RecyclerView.ViewHolder(view) {
        val imageview_logo: CircleImageView =view.findViewById(R.id.imageview_logo)
        val editor_name: TextView =view.findViewById(R.id.editor_name)
        val editor_definiton: TextView =view.findViewById(R.id.editor_definiton)
        val editor_imageview: ImageView =view.findViewById(R.id.editor_imageview)
        val editor_productcount: TextView =view.findViewById(R.id.editor_productcount)
    }
}