package com.example.recyclerview

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R.layout.eachrow
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter ( var newsArrayList: ArrayList<News>, var context : Activity) :
      RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mylistener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setItemClickListener(listener: onItemClickListener) {

    mylistener = listener
}

          //to create a new view instance
          // when layout manager fails to find a suitable view for each item
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(eachrow, parent, false)
              return MyViewHolder(itemView, mylistener)
    }
          // populate tems with data
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
         var currentItem = newsArrayList[position]
              holder.hTitle.text = currentItem.newsHeading
              holder.hImg.setImageResource(currentItem.newimg )
    }
    // how many list items are present in your array
    override fun getItemCount(): Int {
        return newsArrayList.size

    }
     //it holds the view so the view is not created everytime, so memory can be saved
    class MyViewHolder (itemView : View, Listener : onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val hTitle = itemView.findViewById<TextView>(R.id.headingtitle)
         val hImg = itemView.findViewById<ShapeableImageView>(R.id.headingimg)

         init {
             itemView.setOnClickListener{
                 Listener.onItemClick(adapterPosition)

             }
         }

    }
}