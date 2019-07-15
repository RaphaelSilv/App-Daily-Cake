package com.example.workflowupdate.View.activty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workflowupdate.Interfaces.BaseAPI
import com.example.workflowupdate.Model.JSONPost
import com.example.workflowupdate.R
import com.example.workflowupdate.View.adapter.MainAdapter
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.Gson
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {

    var textViewResult: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_main.layoutManager = LinearLayoutManager(this)
        // recyclerView_main.adapter = MainAdapter()

        //var baseApi = BaseAPI.Factory.create()


                val retrofit = Retrofit.Builder()
                    .baseUrl(BaseAPI.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val baseApi= retrofit.create(BaseAPI::class.java)

               var call = baseApi.getJosnList

             call.enqueue(object : retrofit2.Callback<MutableList<JSONPost>> {

            override fun onResponse(call: Call<MutableList<JSONPost>>, response: Response<MutableList<JSONPost>>) {

                  val body: MutableList<JSONPost>?  = response.body()
                  val gson = GsonBuilder().create()
                  val json: MutableList<JSONPost>

                print(body)

                for (ob in body.orEmpty()){

                 // json.add(gson.fromJson(ob, object : TypeToken<MutableList<JSONPost>>() {}.type))
                }
                //recyclerView_main.adapter = MainAdapter(ob)

            }
                override fun onFailure(call: Call<MutableList<JSONPost>>, t: Throwable) {
                    println("Error: " + t)
                }


            })


        }


    }


