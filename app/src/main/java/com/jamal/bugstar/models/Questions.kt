package com.jamal.bugstar.models

data class Questions(
    val is_answered: Boolean,
    val view_count: Int,
    val answer_count: Int,
    val score: Int,
    val question_id: Int,
    val link: String,
    val title: String
)
