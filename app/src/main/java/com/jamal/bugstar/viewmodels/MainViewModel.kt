package com.jamal.bugstar.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jamal.bugstar.models.ItemsAnswers
import com.jamal.bugstar.models.ItemsQuestions
import com.jamal.bugstar.repositories.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val responseQuestions: MutableLiveData<Response<ItemsQuestions>> = MutableLiveData()
    val responseAnswers: MutableLiveData<Response<ItemsAnswers>> = MutableLiveData()

    fun getQuestions() {
        viewModelScope.launch {
            val response = repository.getQuestions()
            responseQuestions.value = response
        }
    }

    fun getAnswers() {
        viewModelScope.launch {
            responseAnswers.value = repository.getAnswers()
        }
    }
}