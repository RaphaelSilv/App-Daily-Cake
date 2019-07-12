package com.example.workflowupdate.Interfaces

import com.example.workflowupdate.Model.JSONPost
import retrofit2.Call
import retrofit2.http.GET

interface JSONPlaceHolderAPI {

    @get : GET("challenge")// relative url
    val getPost: Call<MutableList<JSONPost>>


}