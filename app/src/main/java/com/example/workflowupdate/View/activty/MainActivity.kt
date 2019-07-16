package com.example.workflowupdate.View.activty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.Response.Listener
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.workflowupdate.Interfaces.BaseAPI.Companion.BASE_URL
import com.example.workflowupdate.Model.JSONPost
import com.example.workflowupdate.R
import com.example.workflowupdate.View.adapter.MainAdapter


class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    var mainAdapter: MainAdapter? = null
    lateinit var jsonPosts: MutableList<JSONPost>
    lateinit var requestQeue : RequestQueue


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view_main)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        jsonPosts = ArrayList()
        requestQeue = Volley.newRequestQueue(this)
        parseJSON()
    }


    fun parseJSON() {

        var url = ""
         JsonArrayRequest(Request.Method.GET, url, null,
             Response.Listener<JSONPost>{
                 fun onResponse (){

                 }


         })







    }

}



