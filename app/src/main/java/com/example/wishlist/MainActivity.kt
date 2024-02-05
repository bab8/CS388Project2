package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var wishlistList: List<Wishlist>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Lookup the RecyclerView in activity layout
        val wishlistRV = findViewById<RecyclerView>(R.id.wishlistRV)
        wishlistList = WishlistFetcher.getWishlist()
        // Create adapter passing in the list of emails
        val adapter = WishlistAdapter(wishlistList)
        // Attach the adapter to the RecyclerView to populate items
        wishlistRV.adapter = adapter
        // Set layout manager to position the items
        wishlistRV.layoutManager = LinearLayoutManager(this)


        findViewById<Button>(R.id.submit).setOnClickListener {
            val item = findViewById<EditText>(R.id.InputName)
            val store = findViewById<EditText>(R.id.InputUrl)
            val price = findViewById<EditText>(R.id.InputPrice)
            val value = price.text.toString()
            val newWish = Wishlist(item.text.toString(), store.text.toString(), value.toDouble())
            // Add new emails to existing list of emails
            (wishlistList as MutableList<Wishlist>).add(newWish)
            // Notify the adapter there's new emails so the RecyclerView layout is updated
            adapter.notifyDataSetChanged()
        }
    }
}