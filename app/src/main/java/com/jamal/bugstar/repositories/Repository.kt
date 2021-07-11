package com.jamal.bugstar.repositories

import com.jamal.bugstar.api.RetrofitInstance
import com.jamal.bugstar.models.ItemsAnswers
import com.jamal.bugstar.models.ItemsQuestions
import retrofit2.Response

class Repository {

    suspend fun getQuestions(): Response<ItemsQuestions> {
        return RetrofitInstance.apiRetrofit.listQuestions()
    }

    suspend fun getAnswers(): Response<ItemsAnswers> {
        return RetrofitInstance.apiRetrofit.listAnswers()
    }
}