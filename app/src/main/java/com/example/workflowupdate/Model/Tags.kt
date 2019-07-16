package com.example.workflowupdate.Model

import com.google.gson.annotations.SerializedName


data class Tags(

    @field:SerializedName("id") var id: Int,
    @field:SerializedName("label")  var label: String


)