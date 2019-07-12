package com.example.workflowupdate.Model


import retrofit2.http.Body
import com.google.gson.annotations.SerializedName

data class JSONPost(

    @field:SerializedName("title") var title: String,
    @field:SerializedName("website") var website: String,
    @field:SerializedName("authors") var authors: String,
    @field:SerializedName("date") var date: String,
    @field:SerializedName("content") var content: String,
    @field:SerializedName("tags")  var tags : MutableList<Tags>,
    @field:SerializedName("image_url") var image: String




)

class Tags
{
    @field:SerializedName("id") var id: Int = 0
    @field:SerializedName("label")  var label: String = ""


}