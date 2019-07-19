package com.example.workflowupdate.View.activty

import android.graphics.Color
import android.graphics.Color.RED
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.workflowupdate.Interfaces.BaseAPI.Companion.BLOG_URL
import com.example.workflowupdate.R
import kotlinx.android.synthetic.main.cheesecake_activity.*

class CheesecakeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.cheesecake_activity)
        web_view_blog.settings.javaScriptEnabled = true
        web_view_blog.settings.loadWithOverviewMode = true
        web_view_blog.settings.useWideViewPort = true
        web_view_blog.loadUrl(BLOG_URL)
    }
}