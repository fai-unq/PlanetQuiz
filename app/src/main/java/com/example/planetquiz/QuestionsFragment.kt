package com.example.planetquiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class QuestionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.fragment_questions,
            container,
            false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.question1).setOnClickListener {
            openAnswer(0)
        }

        view.findViewById<View>(R.id.question2).setOnClickListener {
            openAnswer(1)
        }

        view.findViewById<View>(R.id.question3).setOnClickListener {
            openAnswer(2)
        }
    }

    private fun openAnswer(questionNumber: Int) {

        val fragment = AnswersFragment()

        val bundle = Bundle()
        bundle.putInt("questionNumber", questionNumber)

        fragment.arguments = bundle

        requireActivity()
            .supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}