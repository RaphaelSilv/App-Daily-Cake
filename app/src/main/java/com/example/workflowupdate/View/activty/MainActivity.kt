package com.example.workflowupdate.View.activty

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.EditText
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.workflowupdate.Interfaces.BaseAPI.Companion.BASE_URL
import com.example.workflowupdate.Model.JSONPost
import com.example.workflowupdate.R
import com.example.workflowupdate.View.adapter.MainAdapter
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import java.io.IOException
import java.lang.StringBuilder


class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    var bodyList: MutableList<JSONPost> = ArrayList()
    var bodyDisplay: MutableList<JSONPost> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view_main)
        // recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)




        parseJSON()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.main, menu)
        val searchIcon = menu.findItem(R.id.menu_search)


        if (!(searchIcon == null)) {
            val searchView = searchIcon.actionView as SearchView
            // val labelSearch = searchView.findViewById<EditText>(android.widget.SearchView.R.id.search_src_text)
           // R.menu.main. = "Search here"
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {

                    if (p0!!.isNotEmpty()) {


                        bodyDisplay.clear()

                        val search = p0.toLowerCase().trim()

                        bodyList.forEach {


                            var title: String = it.title.toLowerCase().trim()
                            var website: String = it.website.toLowerCase().trim()
                            var author: String = it.authors.toLowerCase().trim()
                            var date = it.date.toLowerCase().trim()
                            var content = it.content.toLowerCase().trim()

                            lateinit var labels: String
                            lateinit var id: String

                            for (tags in it.tags) {
                                labels = tags.label.toLowerCase().trim()
                                id = tags.id.toString().toLowerCase().trim()
                            }
                            var finalString : StringBuilder? = null

                            finalString?.append(title)
                            finalString?.append(website)
                            finalString?.append(author)
                            finalString?.append(date)
                            finalString?.append(content)
                            finalString?.append(labels)
                            finalString?.append(id)

                            val superString = finalString.toString()
                            print("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
                            print(superString)



                                if (superString.contains(search)) {
                                    bodyDisplay.add(it)

                            }

                        }


                        recyclerView.adapter?.notifyDataSetChanged()

                    } else {
                        bodyDisplay.clear()
                        bodyDisplay.addAll(bodyList)
                        recyclerView.adapter?.notifyDataSetChanged()
                    }

                    return false

                }

                override fun onQueryTextChange(p0: String?): Boolean {

                    return true
                }


            })

        }


        return super.onCreateOptionsMenu(menu)
    }


    fun parseJSON() {

        val request = okhttp3.Request.Builder().url(BASE_URL + "challenge").build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call, response: okhttp3.Response) {
                val body = response.body()?.string()
                // print(body.toString())
                val gson = GsonBuilder().create()
                bodyList = gson.fromJson(body, object : TypeToken<MutableList<JSONPost>>() {}.type)
                bodyDisplay.addAll(bodyList)

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





