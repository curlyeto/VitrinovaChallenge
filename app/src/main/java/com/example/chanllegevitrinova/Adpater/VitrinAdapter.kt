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
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chanllegevitrinova.Activity.MainActivity
import com.example.chanllegevitrinova.Model.Editor.Editor
import com.example.chanllegevitrinova.R
import de.hdodenhof.circleimageview.CircleImageView

class VitrinAdapter(var context:Context,var vitrinList:ArrayList<Editor>) :RecyclerView.Adapter<VitrinAdapter.VitrinHolder>() {
    var lastPosition:Int=-1
    private lateinit var view:View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VitrinHolder {
        if (context is MainActivity) {
            view= LayoutInflater.from(context).inflate(R.layout.vitrin_list_item, parent, false)
        }else{
            view= LayoutInflater.from(context).inflate(R.layout.vitrin_tumu_list_item, parent, false)
        }
        return VitrinHolder(view)
    }

    override fun getItemCount(): Int {
        return vitrinList.size
    }

    override fun onBindViewHolder(holder: VitrinHolder, position: Int) {
        if (context is MainActivity)
            setAnimation(holder.relative_vitrin,position,R.anim.item_animation_from_right)
        else
            setAnimation(holder.relative_vitrin,position,R.anim.item_animation_from_bottom)
        holder.vitrin_name.text=vitrinList.get(position).name
        holder.vitrin_definition.text=vitrinList.get(position).definition
        holder.vitrin_productcount.text=vitrinList.get(position).productCount.toString()
        Glide.with(context).load(vitrinList.get(position).cover?.url).into(holder.vitrin_image)
        Glide.with(context).load(vitrinList.get(position).logo?.url).into(holder.vitrin_logo)

        val string=vitrinList.get(position).cover?.url
        if (string==null){
            holder.vitrin_image.setImageResource(R.drawable.vebadge)
        }
        if (vitrinList.get(position).logo?.url==null){
            holder.logo_textview.text=vitrinList.get(position).name?.substring(0,1)
            Glide.with(context).load(R.mipmap.no_logo).into(holder.vitrin_logo)
        }
    }
    fun setAnimation(viewToAnimate: View, position: Int,animation:Int) {
        if(position > lastPosition) {
            val animation = AnimationUtils.loadAnimation(context,animation)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }

    class VitrinHolder(view:View) : RecyclerView.ViewHolder(view) {
        val relative_vitrin:RelativeLayout=view.findViewById(R.id.relative_vitrin)
        val logo_textview:TextView=view.findViewById(R.id.logo_textview)
        val vitrin_image:ImageView=view.findViewById(R.id.vitrin_image)
        val vitrin_logo:CircleImageView=view.findViewById(R.id.vitrin_logo)
        val vitrin_name:TextView=view.findViewById(R.id.vitrin_name)
        val vitrin_definition:TextView=view.findViewById(R.id.vitrin_definition)
        val vitrin_productcount:TextView=view.findViewById(R.id.vitrin_productcount)


    }
}