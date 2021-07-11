package com.jamal.bugstar.models

import com.google.gson.annotations.SerializedName

data class ItemsAnswers(
    @SerializedName("items")
    val itemsAnswers: ArrayList<Answers>
)
