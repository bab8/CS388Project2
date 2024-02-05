package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val wishlist: List<Wishlist>): RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //Class members
        val itemTextView: TextView
        val urlTextView: TextView
        val priceTextView: TextView


        init {
            itemTextView = itemView.findViewById(R.id.item)
            urlTextView = itemView.findViewById(R.id.url)
            priceTextView = itemView.findViewById(R.id.price)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wishlist_layout, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val wishlist = wishlist.get(position)
        // Set item views based on views and data model
        holder.itemTextView.text = wishlist.item
        holder.urlTextView.text = wishlist.url
        holder.priceTextView.text = wishlist.price.toString()
    }

    override fun getItemCount(): Int {
        return wishlist.size
    }
}