package com.jamal.bugstar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
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
    private val questionAdapter = QuestionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView(binding)

        val mainViewModelFactory = MainViewModelFactory(Repository())
        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        mainViewModel.getQuestions()
        mainViewModel.responseQuestions.observe(this, { response ->
            getAllQuestions(response)
            Log.d(TAG, "List size: ${questionsList.size}")
            questionAdapter.setQuestionsData(questionsList)
        })

    }

    private fun fakeData() {
        questionsList.add(Questions(true, 1000, 2, 10, 12222122, "", "How can I add values to a array?"))
        questionsList.add(Questions(true, 10000, 29, 100, 1223878722, "", "How to use a intent in android?"))
    }

    private fun initRecyclerView(binding: ActivityMainBinding) {
        binding.recyclerviewQuestions.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = questionAdapter
        }
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