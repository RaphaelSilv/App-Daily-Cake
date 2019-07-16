package com.example.workflowupdate.Model


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.workflowupdate.Interfaces.BaseAPI.Companion.AUX_IMAG
import retrofit2.http.Body
import com.google.gson.annotations.SerializedName

 data class JSONPost (

     @field:SerializedName("title") var title: String,
     @field:SerializedName("website") var website: String,
     @field:SerializedName("authors") var authors: String,
     @field:SerializedName("date") var date: String,
     @field:SerializedName("content") var content: String,
     @field:SerializedName("tags")  var tags : MutableList<Tags>,
     var image: String = AUX_IMAG

)









