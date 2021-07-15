package com.jamal.bugstar.api

import com.jamal.bugstar.utils.ANSWERS_ENDPOINT
import com.jamal.bugstar.utils.QUESTIONS_ENDPOINT
import com.jamal.bugstar.models.ItemsAnswers
import com.jamal.bugstar.models.ItemsQuestions
import retrofit2.Response
import retrofit2.http.GET

interface StackEnxchangeAPI {

    @GET(QUESTIONS_ENDPOINT)
    suspend fun listQuestions(): Response<ItemsQuestions>

    @GET(ANSWERS_ENDPOINT)
    suspend fun listAnswers(): Response<ItemsAnswers>
}