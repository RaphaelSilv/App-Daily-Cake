package com.example.workflowupdate.Interfaces

import com.example.workflowupdate.Model.JSONPost
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface BaseAPI {

    @get:GET("challenge") //Retrofit var
    val getJosnList: Call<MutableList<JSONPost>>


    companion object {

        val BLOG_URL = "https://cheesecakelabs.com/blog/"

        val CAKE_IMG = "https://cdn-images-1.medium.com/max/1091/1*BGS3ac9L-Cb0RCueCU7Xhg.png"

        val BASE_URL = "https://cheesecakelabs.com/"

        val CKL_ICON = "https://cheesecakelabs.com/wp-content/themes/cheesecake_labs/images/favicon/favicon-152.png"

        val IMAG_CKL_BLOG = "https://cheesecakelabs.com/wp-content/themes/cheesecake_labs/images/illustrations/lines-bg.png" //1250 X 1092 pixels

        val CKL_EMBRACE_PRIDE = "https://media.licdn.com/dms/image/C4E1BAQEeoZLQHC3d8A/company-background_10000/0?e=2159024400&v=beta&t=1PjHdFNIEjEy7Awa7w95L_4tC3eQrXgpFxTxhn1CNT4"
    }
}
