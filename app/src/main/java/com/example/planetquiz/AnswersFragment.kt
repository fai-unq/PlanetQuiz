package com.example.planetquiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class AnswersFragment : Fragment() {

    private var questionNumber = 0

    private val questions = arrayOf(
        "What is the largest planet?",
        "Which planet has the most moons?",
        "Which planet spins on its side?"
    )

    private val correctAnswers = arrayOf(
        "JUPITER",
        "SATURN",
        "URANUS"
    )

    private val explanations = arrayOf(
        "Jupiter is the largest planet and is 2.5 times the mass of all the other planets put together.",
        "Saturn has the most moons and has 82 moons.",
        "Uranus spins on its side with its axis at nearly a right angle to the Sun."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        questionNumber =
            arguments?.getInt("questionNumber") ?: 0
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.fragment_answers,
            container,
            false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        val questionText =
            view.findViewById<TextView>(R.id.questionText)

        questionText.text = questions[questionNumber]

        val buttons = arrayOf(
            view.findViewById<Button>(R.id.mercury),
            view.findViewById<Button>(R.id.venus),
            view.findViewById<Button>(R.id.earth),
            view.findViewById<Button>(R.id.mars),
            view.findViewById<Button>(R.id.jupiter),
            view.findViewById<Button>(R.id.saturn),
            view.findViewById<Button>(R.id.uranus),
            view.findViewById<Button>(R.id.neptune)
        )

        for (button in buttons) {
            button.setOnClickListener {
                checkAnswer(
                    button.text.toString(),
                    view
                )
            }
        }
    }

    private fun checkAnswer(
        selectedAnswer: String,
        view: View
    ) {
        val resultText =
            view.findViewById<TextView>(R.id.resultText)

        val explanationText =
            view.findViewById<TextView>(R.id.explanationText)

        if (selectedAnswer == correctAnswers[questionNumber]) {

            resultText.text = "CORRECT!"

            explanationText.text =
                explanations[questionNumber]

        } else {

            resultText.text = "INCORRECT!"

            explanationText.text =
                "The correct answer is ${correctAnswers[questionNumber]}."
        }

        resultText.visibility = View.VISIBLE
        explanationText.visibility = View.VISIBLE
    }
}