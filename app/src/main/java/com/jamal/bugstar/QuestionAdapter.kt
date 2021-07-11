package com.jamal.bugstar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jamal.bugstar.databinding.QuestionsRowBinding
import com.jamal.bugstar.models.Questions

class QuestionAdapter(): RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    private var questionList = ArrayList<Questions>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            QuestionsRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.titleQuestion.text = questionList[position].title
        holder.binding.totalAnswers.text = questionList[position].view_count.toString()
    }

    override fun getItemCount(): Int {
        return questionList.size
    }

    fun setQuestionsData(questionsList: ArrayList<Questions>) {
        this.questionList = questionsList
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: QuestionsRowBinding): RecyclerView.ViewHolder(binding.root) {
    }
}

