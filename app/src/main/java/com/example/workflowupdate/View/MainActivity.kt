package com.example.workflowupdate.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.workflowupdate.Interfaces.JSONPlaceHolderAPI
import com.example.workflowupdate.Model.JSONPost
import com.example.workflowupdate.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var textViewResult : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textViewResult  = findViewById(R.id.text_view_result) as TextView

        val retrofit = Retrofit.Builder()
            .baseUrl("https://cheesecakelabs.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jsonPlaceHolderAPI = retrofit.create(JSONPlaceHolderAPI::class.java)

        var call: Call<MutableList<JSONPost>> = jsonPlaceHolderAPI.getPost

        call.enqueue(object : Callback<MutableList<JSONPost>> {


            override fun onResponse(call: Call<MutableList<JSONPost>>, response: Response<MutableList<JSONPost>>) {

                //404 checker
                if (!response.isSuccessful) {
                    textViewResult.setText("Code: " + response.code())
                    return;
                }

                val body = response.body()
                // redundant null checker
                if (body != null) {
                    for (post in body) {
                        var content: String = "" + "\n\n"
                        content += "Title: " + post.title + "\n"
                        content += "Website : " + post.website + "\n"
                        content += "Authors: " + post.authors + "\n"
                        content += "Date: " + post.date + "\n\n"
                        content += "Content: " + post.content + "\n\n"


                        //content += "Id: " + post.tags+ "\n"
                        //content += "Label: " + post.tags+ "\n"
                        for (post in post.tags) {
                            content += "Tags: {" + "\n\n"
                            content += "Id: " + post.id+ "\n"
                            content += "Label: " + post.label+ "\n\n"

                        }
                        content += "}" + "\n"
                        content += "Image: " + post.image + "\n\n"
                        textViewResult.append(content)


                    }
                }

            }

            override fun onFailure(call: Call<MutableList<JSONPost>>, t: Throwable) {

                textViewResult.setText(t.message)

            }


        })

    }
}
