package com.jamal.bugstar.api

import com.jamal.bugstar.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
     companion object {
         private val retrofitInstance by lazy {
             Retrofit.Builder()
                 .baseUrl(BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create())
                 .build()
         }

         val apiRetrofit by lazy {
             retrofitInstance.create(StackEnxchangeAPI::class.java)
         }
     }
}