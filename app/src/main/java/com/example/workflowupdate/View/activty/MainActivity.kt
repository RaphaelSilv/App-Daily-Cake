package com.example.workflowupdate.View.activty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.workflowupdate.Model.JSONPost
import com.example.workflowupdate.R
import com.example.workflowupdate.View.adapter.MainAdapter
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import java.io.IOException


class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    var mainAdapter: MainAdapter? = null
    //lateinit var requestQeue: RequestQueue


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view_main)
       // recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // jsonPosts = ArrayList()
        //  requestQeue = Volley.newRequestQueue(this)
        parseJSON()
    }


    fun parseJSON() {

        val request = okhttp3.Request.Builder().url("https://cheesecakelabs.com/challenge/").build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call, response: okhttp3.Response) {
                val body = response.body()?.string()
                // print(body.toString())
                val gson = GsonBuilder().create()
                var bodyList: MutableList<JSONPost> =
                    gson.fromJson(body, object : TypeToken<MutableList<JSONPost>>() {}.type)
                print(bodyList)


                runOnUiThread {
                    recyclerView.adapter = MainAdapter(bodyList)

                }
            }

            override fun onFailure(call: Call, e: IOException) {

                print("Error : " + e.printStackTrace())
            }


        })


    }

}





