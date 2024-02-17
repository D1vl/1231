package com.example.myapplicationxml

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.core.view.isVisible
import com.example.myapplicationxml.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

//    private lateinit var binding: ActivityMainBinding

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding
            ?: throw IllegalAccessException("Binding for ActivityMainBinding must be not Null")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("test123", "message on create")
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(
            binding.root
        )

        // ПЕРЕХОД НА ДРУГОЙ ЭКРАН
//        binding.btSkip.setOnClickListener {
//            val intent = Intent(this, SecondScreenActivity::class.java)
//            startActivity(intent)
//        }
//
//        binding.btNext.setOnClickListener {
//            val intent = Intent(this, SecondScreenActivity::class.java)
//            startActivity(intent)
//        }

        val trainer = LearnWordsTrainer()
        showNextQuestion(trainer)


//        binding.layoutAnswer1.setOnClickListener {
//
//            markAnswerCorrect(
//                tvNumber = binding.tvNumber1,
//                layoutAnswer = binding.layoutAnswer1,
//                tvValue = binding.tvValue1,
//                layoutResult = binding.layoutResult,
//            )
//            showResult(true)
//        }
//
//
//        binding.layoutAnswer2.setOnClickListener {
//
//            markAnswerWrong(
//                tvNumber = binding.tvNumber2,
//                layoutResult = binding.layoutResult,
//                layoutAnswer = binding.layoutAnswer2,
//                tvValue = binding.tvValue2,
//            )
//            showResult(false)
//        }
//
//        binding.layoutAnswer3.setOnClickListener {
//
//            markAnswerWrong(
//                tvNumber = binding.tvNumber3,
//                layoutResult = binding.layoutResult,
//                layoutAnswer = binding.layoutAnswer3,
//                tvValue = binding.tvValue3,
//            )
//            showResult(false)
//        }
//
//        binding.layoutAnswer4.setOnClickListener {
//
//            markAnswerWrong(
//                tvNumber = binding.tvNumber4,
//                layoutResult = binding.layoutResult,
//                layoutAnswer = binding.layoutAnswer4,
//                tvValue = binding.tvValue4,
//            )
//            showResult(false)
//        }

    }

    private fun showNextQuestion(trainer: LearnWordsTrainer) {
        val firstQuestion: Question? = trainer.getNextQuestion()
        with(binding) {
            if (firstQuestion == null) {
                tvQuestionWord.isVisible = false
                layoutAnswer.isVisible = false
                btSkip.text = "Complete"
            } else {
                btSkip.isVisible = true
                tvQuestionWord.isVisible = true
                tvQuestionWord.text = firstQuestion.correctAnswer.original


                fishSpinGif.drawable = ContextCompat.getDrawable(this@MainActivity, R.drawable.)
                tvValue1.text = firstQuestion.variants[0].translate
                tvValue2.text = firstQuestion.variants[1].translate
                tvValue3.text = firstQuestion.variants[2].translate
                tvValue4.text = firstQuestion.variants[3].translate



                layoutAnswer1.setOnClickListener {
                    if (trainer.checkAnswer(0)) {
                        markAnswerCorrect(
                            tvNumber = tvNumber1,
                            layoutAnswer = layoutAnswer1,
                            layoutResult = layoutResult,
                            tvValue = tvValue1
                        )
                        showResult(true)
                    } else {
                        markAnswerWrong(
                            tvNumber = tvNumber1,
                            layoutResult = layoutResult,
                            layoutAnswer = layoutAnswer1,
                            tvValue = tvValue1,
                        )
                        showResult(false)
                    }
                }
                layoutAnswer2.setOnClickListener {
                    if (trainer.checkAnswer(1)) {
                        markAnswerCorrect(
                            tvNumber = tvNumber2,
                            layoutAnswer = layoutAnswer2,
                            layoutResult = layoutResult,
                            tvValue = tvValue2
                        )
                        showResult(true)
                    } else {
                        markAnswerWrong(
                            tvNumber = tvNumber2,
                            layoutResult = layoutResult,
                            layoutAnswer = layoutAnswer2,
                            tvValue = tvValue2,
                        )
                        showResult(false)
                    }
                }
                layoutAnswer3.setOnClickListener {
                    if (trainer.checkAnswer(2)) {
                        markAnswerCorrect(
                            tvNumber = tvNumber3,
                            layoutAnswer = layoutAnswer3,
                            layoutResult = layoutResult,
                            tvValue = tvValue3
                        )
                        showResult(true)
                    } else {
                        markAnswerWrong(
                            tvNumber = tvNumber3,
                            layoutResult = layoutResult,
                            layoutAnswer = layoutAnswer3,
                            tvValue = tvValue3,
                        )
                        showResult(false)
                    }
                }
                layoutAnswer4.setOnClickListener {
                    if (trainer.checkAnswer(3)) {
                        markAnswerCorrect(
                            tvNumber = tvNumber4,
                            layoutAnswer = layoutAnswer4,
                            layoutResult = layoutResult,
                            tvValue = tvValue4
                        )
                        showResult(true)
                    } else {
                        markAnswerWrong(
                            tvNumber = tvNumber4,
                            layoutResult = layoutResult,
                            layoutAnswer = layoutAnswer4,
                            tvValue = tvValue4,
                        )
                        showResult(false)
                    }
                }
            }
        }
    }

    private fun markAnswerCorrect(
        tvNumber: TextView,
        layoutAnswer: LinearLayout,
        tvValue: TextView,
        layoutResult: ConstraintLayout,
    ) {

        layoutAnswer.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_containers_correct
        )

        layoutResult.setBackgroundColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.green
            )
        )

        tvNumber.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_containers_correct
        )
        tvValue.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.white
            )
        )
        tvNumber.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.white
            )
        )

        tvNumber.apply {
            background = ContextCompat.getDrawable(
                this@MainActivity,
                R.drawable.shape_rounded_containers
            )

            setTextColor(
                ContextCompat.getColor(
                    this@MainActivity,
                    R.color.white
                )
            )
        }
        binding.btSkip.isVisible = false
    }

// виды состояний активити

    override fun onStart() {
        super.onStart()
        Log.d("test123", "message on start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("test123", "message on resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("test123", "message on Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("test123", "message on stop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("test123", "message on restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("test123", "message on destroy")
    }

    private fun markAnswerWrong(
        tvNumber: TextView,
        layoutResult: ConstraintLayout,
        layoutAnswer: LinearLayout,
        tvValue: TextView,
    ) {
        tvNumber.apply {
            background = ContextCompat.getDrawable(
                this@MainActivity,
                R.drawable.shape_rounded_containers_wrong
            )
            setTextColor(
                ContextCompat.getColor(
                    this@MainActivity,
                    R.color.white
                )
            )
        }
        layoutResult.setBackgroundColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.red
            )
        )
        layoutAnswer.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_containers_wrong
        )
        tvValue.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.white
            )
        )

        binding.btSkip.isVisible = false
    }

    private fun showResult(isCorrect: Boolean) {
        val btColor: Int
        val messageText: String
        if (isCorrect) {

            messageText = "Хорошая работа, молодец"

            btColor = ContextCompat.getColor(this, R.color.green)
            binding.fishSpinGif.isVisible = false
            binding.JoelCorrect.isVisible = true
            binding.mistake.isVisible = false
            binding.fishSpinGif.drawable = ContextCompat.getDrawable(this, R.drawable.)

        } else {
            btColor = ContextCompat.getColor(this, R.color.red)
            messageText = "Ты не прав"

            binding.fishSpinGif.isVisible = false
            binding.mistake.isVisible = true
            binding.JoelCorrect.isVisible = false
        }
        with(binding) {
            btSkip.isVisible = false
            layoutResult.isVisible = true
            binding.tvResult.text = messageText
            btNext.setTextColor(btColor)


        }
    }

    private fun markAnswerNeutral(

        tvValueList: List<TextView>,
        layoutAnswerList: List<LinearLayout>,
        tvNumberList: List<TextView>,
    ) {
        tvNumberList.forEach { tvNumber ->
            tvNumber.apply {
                background = ContextCompat.getDrawable(
                    this@MainActivity,
                    R.drawable.shape_rounded_containers_grey
                )
                setTextColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.white
                    )
                )
            }
            layoutAnswerList.forEach { layoutAnswer ->
                layoutAnswer.background = ContextCompat.getDrawable(
                    this@MainActivity,
                    R.drawable.shape_rounded_containers_grey
                )
            }
            tvValueList.forEach { tvValue ->
                tvValue.setTextColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.white
                    )
                )
            }

        }
    }
}