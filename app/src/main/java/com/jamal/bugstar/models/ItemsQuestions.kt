package com.jamal.bugstar.models

import com.google.gson.annotations.SerializedName

data class ItemsQuestions(
    @SerializedName("items")
    val itemsQuestions: ArrayList<Questions>
)
