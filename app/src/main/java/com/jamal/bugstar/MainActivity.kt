package com.jamal.bugstar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.jamal.bugstar.databinding.ActivityMainBinding
import com.jamal.bugstar.models.ItemsQuestions
import com.jamal.bugstar.models.Questions
import com.jamal.bugstar.repositories.Repository
import com.jamal.bugstar.viewmodels.MainViewModel
import com.jamal.bugstar.viewmodels.MainViewModelFactory
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private val TAG = "MainActivityLog"
    private var questionsList= ArrayList<Questions>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainViewModelFactory = MainViewModelFactory(Repository())
        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        mainViewModel.getQuestions()
        mainViewModel.responseQuestions.observe(this, { response ->
            getAllQuestions(response)
            //Log.d(TAG, "List size: ${questionsList.size}")
        })
    }

    private fun getAllQuestions(response: Response<ItemsQuestions>) {
        if (response.isSuccessful) {
            this.questionsList = response.body()!!.itemsQuestions
            Log.d(TAG, "${response.body()!!.itemsQuestions}")
            Log.d(TAG, response.raw().toString())
        } else {
            Log.d(TAG, response.message())
        }
    }
}