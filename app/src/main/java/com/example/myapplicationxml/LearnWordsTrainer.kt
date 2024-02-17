package com.example.myapplicationxml

import android.content.Context
import androidx.core.content.ContextCompat

data class Word(
    val original: String,
    val translate: String,
    var learned: Boolean = false,
    val gifId: Int
)

data class Question(
    val variants: List<Word>,
    val correctAnswer: Word,
    val gifId: Int
)

class LearnWordsTrainer {

    private val dictionary = listOf(
        Word(original = "Fish", translate = "Рыба", gifId = R.drawable.fish_spin),
        Word(original = "Skelly", translate = "Скелет", gifId = R.drawable.skelly),
    )
    private var currentQuestion: Question? = null

    fun getNextQuestion(): Question? {

        val notLearnedList = dictionary.filter { !it.learned }

        if (notLearnedList.isEmpty()) return null

        val questionWords =
            if (notLearnedList.size < NUMBER_OF_ANSWERS) {
                val learnedList = dictionary.filter { !it.learned }.shuffled()
                notLearnedList.shuffled()
                    .take(NUMBER_OF_ANSWERS) + learnedList
                    .take(NUMBER_OF_ANSWERS - notLearnedList.size)
            } else {
                notLearnedList.shuffled()
                    .take(NUMBER_OF_ANSWERS)
            }.shuffled()

        val correctAnswer: Word = questionWords.random()
        val gifId: Word =

        currentQuestion = Question(
            variants = questionWords,
            correctAnswer = correctAnswer,
            gifId =
        )
        return currentQuestion
    }

    fun checkAnswer(userAnswerIndex: Int?): Boolean {

        return currentQuestion?.let {
            val correctAnswerId = it.variants.indexOf(it.correctAnswer)
            if (correctAnswerId == userAnswerIndex) {
                it.correctAnswer.learned = true
                true // спросить нахуя
            } else {
                false // спросить нахуя
            }
        } ?: false
    }
}

const val NUMBER_OF_ANSWERS: Int = 4