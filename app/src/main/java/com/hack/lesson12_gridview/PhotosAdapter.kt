package com.hack.lesson12_gridview

import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.photo_item.view.*
import kotlin.math.roundToInt

class PhotosAdapter(private val photos: ArrayList<String>, private val numColumns : Int, private val onClick: (String) -> Unit) : RecyclerView.Adapter<PhotosAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val photoIV: ImageView = view.photoIV
        val containerCL: ConstraintLayout = view.containerCL
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.photo_item, parent, false)
        val holder = MyViewHolder(itemView)

        val widthScreen = Resources.getSystem().displayMetrics.widthPixels
        val imageWidth = (widthScreen / numColumns).toFloat().roundToInt()
        val photoParams = holder.containerCL.layoutParams as GridLayoutManager.LayoutParams
        photoParams.height = imageWidth
        photoParams.width = imageWidth
        holder.containerCL.layoutParams = photoParams

        return holder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val url = photos[position]
        Picasso.get().load(url)
            .fit()
            .centerCrop()
            .into(holder.photoIV)
        holder.containerCL.setOnClickListener {
            onClick(url)
        }
    }


    override fun getItemCount(): Int {
        return photos.size
    }

}