package com.example.workflowupdate.View.activty

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.workflowupdate.Interfaces.BaseAPI
import com.example.workflowupdate.Interfaces.BaseAPI.Companion.CKL_ICON
import com.example.workflowupdate.Interfaces.BaseAPI.Companion.IMAG_CKL_BLOG
import com.example.workflowupdate.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.about_us_activity.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.news_item.view.*

class AboutUsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        recycler_view_main.layoutManager = LinearLayoutManager(this)
        recycler_view_main.adapter = AboutUsApdapter()
    }

    private class AboutUsApdapter : RecyclerView.Adapter<AboutUsViewHolder>() {

        override fun getItemCount(): Int {
            return 1
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutUsViewHolder {


            val inflater = LayoutInflater.from(parent.context)
            val customView = inflater.inflate(R.layout.about_us_activity, parent, false)

            return AboutUsViewHolder(customView)

        }

        override fun onBindViewHolder(holder: AboutUsViewHolder, position: Int) {

            Picasso.with(holder?.customView?.context).load(CKL_ICON).into(holder.iconImageCkl)

            Picasso.with(holder.customView.context).load(BaseAPI.CKL_EMBRACE_PRIDE).into(holder.imagePrideCkl)

            Picasso.with(holder.customView.context).load(BaseAPI.IMAG_CKL_BLOG).into(holder.imageCkl)


            holder.salutText.text = "Insights about the app design and development ecosystem."
            holder.clickText.text = "Visit our blog"
        }


    }

    private class AboutUsViewHolder(val customView: View) : RecyclerView.ViewHolder(customView) {

        var imageCkl: ImageView
        var imagePrideCkl: ImageView
        var iconImageCkl: ImageView
        var salutText: TextView
        var clickText: TextView

        init {
            imageCkl = customView.findViewById(R.id.image_about_us)
            imagePrideCkl = customView.findViewById(R.id.image_pride__about_us)
            salutText = customView.findViewById(R.id.text_about_us)
            clickText = customView.findViewById(R.id.text_click_about_us)
            iconImageCkl = customView.findViewById(R.id.image_icon_about_us)

            customView.setOnClickListener {
                val intent = Intent(customView.context, CheesecakeActivity::class.java)
                customView.context.startActivity(intent)

            }

        }
    }
}