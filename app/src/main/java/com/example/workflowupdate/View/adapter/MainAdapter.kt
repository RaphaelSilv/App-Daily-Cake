package com.example.workflowupdate.View.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.workflowupdate.Interfaces.BaseAPI.Companion.CKL_ICON
import com.example.workflowupdate.Model.JSONPost
import com.example.workflowupdate.Model.Tags
import com.example.workflowupdate.R
import com.example.workflowupdate.View.activty.AboutUsActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_item.view.*

class MainAdapter(val bodyList: MutableList<JSONPost>) :
    RecyclerView.Adapter<MainAdapter.ExampleViewHolder>() {

    var bodyDisplay: MutableList<JSONPost> = ArrayList(bodyList)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val celllForRow = layoutInflater.inflate(R.layout.news_item, parent, false)
        return ExampleViewHolder(celllForRow)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {

        val currentJsonPost = bodyList.get(position)
        val currentJsonPostTags: MutableList<Tags> = currentJsonPost.tags

        val tags = currentJsonPost.tags
        val date = "Date: " + currentJsonPost.date
        val title = currentJsonPost.title
        val author = "By: " + currentJsonPost.authors
        val content = currentJsonPost.content
        val website = currentJsonPost.website
        val imagePostUrl = currentJsonPost.imageUrl

        val imagePost = holder?.view?.image_view
        Picasso.with(holder?.view?.context).load(imagePostUrl.replace("http", "https")).into(imagePost)


        val cheeseIcon = holder.view.image_icon
        Picasso.with(holder.view.context).load(CKL_ICON).into(cheeseIcon)


        lateinit var labels: String
        for (tags in currentJsonPostTags) {
            labels = "Labels: " + tags.label.toString()
        }

        holder.textViewdate.text = date
        holder.textViewtitle.text = title
        holder.textViewAuthor.text = author
        holder.textViewContent.text = content
        holder.textViewWebsite.text = website
        holder.textViewLabels.text = labels


    }

    override fun getItemCount(): Int {
        return bodyList.count()
    }

    inner class ExampleViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        var imageView: ImageView
        var imageAux: ImageView
        var textViewdate: TextView
        var textViewtitle: TextView
        var textViewAuthor: TextView
        var textViewWebsite: TextView
        var textViewContent: TextView
        var textViewLabels: TextView


        init {
            imageView = view.findViewById(R.id.image_view)
            imageAux = view.findViewById(R.id.image_icon)
            textViewdate = view.findViewById(R.id.text_view_date)
            textViewtitle = view.findViewById(R.id.text_view_title)
            textViewAuthor = view.findViewById(R.id.text_view_author)
            textViewWebsite = view.findViewById(R.id.text_view_website)
            textViewContent = view.findViewById(R.id.text_view_content)
            textViewLabels = view.findViewById(R.id.text_view_labels)

            view.setOnClickListener {

                val intent = Intent(view.context, AboutUsActivity::class.java)
                view.context.startActivity(intent)

            }


        }


    }


}
