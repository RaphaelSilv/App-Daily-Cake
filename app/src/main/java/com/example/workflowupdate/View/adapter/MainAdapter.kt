package com.example.workflowupdate.View.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.workflowupdate.Interfaces.BaseAPI.Companion.AUX_IMAG
import com.example.workflowupdate.Model.JSONPost
import com.example.workflowupdate.R
import com.squareup.picasso.Picasso

import java.util.ArrayList

class MainAdapter(private val context: Context, private val jsonPosts: ArrayList<JSONPost>) :
    RecyclerView.Adapter<MainAdapter.ExampleViewHolderr>() {



    inner class ExampleViewHolderr(view: View) : RecyclerView.ViewHolder(view) {

        var imageView: ImageView
        var imageAux : ImageView
        var textViewTags : TextView
        var textViewdate: TextView
        var textViewtitle: TextView
        var textViewAuthor: TextView // author
        var textViewWebsite: TextView // title
        var textViewContent: TextView  // content
        var textViewLabels: TextView  // labels
       // tags


        init {
            imageView = view.findViewById(R.id.image_view)
            imageAux = view.findViewById(R.id.image_aditional)
            textViewTags = view.findViewById(R.id.image_aditional)
            textViewdate = view.findViewById(R.id.text_view_date)
            textViewtitle = view.findViewById(R.id.text_view_title)
            textViewAuthor = view.findViewById(R.id.text_view_author)
            textViewWebsite = view.findViewById(R.id.text_view_website)
            textViewContent = view.findViewById(R.id.text_view_content)
            textViewLabels = view.findViewById(R.id.text_view_labels)


        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolderr {

        val v = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false)
        return ExampleViewHolderr(v)
    }

    override fun onBindViewHolder(holder: ExampleViewHolderr, position: Int) {
        val currentJsonPost = jsonPosts[position]

        val imageUrl = currentJsonPost.image
        val imageAuxiliar = AUX_IMAG

        val tags = currentJsonPost.tags
        val date = currentJsonPost.date
        val title = currentJsonPost.title
        val author = currentJsonPost.authors
        val content = currentJsonPost.content
        val website = currentJsonPost.website
       // val labels = tags.label


        Picasso.with(context).load(imageUrl).fit().centerInside().into(holder.imageView)
        Picasso.with(context).load(imageUrl).fit().centerInside().into(holder.imageAux)

       // holder.textViewTags.text = tags
        holder.textViewdate.text = date
        holder.textViewtitle.text = title
        holder.textViewAuthor.text = author
        holder.textViewContent.text = content
        holder.textViewWebsite.text = website

    }

    override fun getItemCount(): Int {
        return jsonPosts.size
    }


}
