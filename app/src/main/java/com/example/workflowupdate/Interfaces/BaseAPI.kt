package com.example.workflowupdate.Interfaces

import com.example.workflowupdate.Model.JSONPost
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
interface BaseAPI {

    @get:GET("challenge")
    val getJosnList: Call<MutableList<JSONPost>>


    companion object {

        val BASE_URL = "https://cheesecakelabs.com/"

        val AUX_IMAG = "https://scontent.ffln1-1.fna.fbcdn.net/v/t1.0-9/33120773_994483490709820_1905396463446261760_n.png?_nc_cat=100&_nc_oc=AQmd5WH3Z_OWeTiXYUmd3tzjTDY7xNjeNkcoggttZZzYjocTF6z54fsfHtWMYTrp0O7e7AO1XRzXixvud5P0dnxy&_nc_ht=scontent.ffln1-1.fna&oh=2a898db1dd6bdf4146da20a7951a9f46&oe=5DB79EBB"
    }
}
