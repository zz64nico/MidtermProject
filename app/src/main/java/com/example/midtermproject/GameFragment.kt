package com.example.midtermproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class GameFragment : Fragment() {

    private var randomNumber = (1..100).random()
    private var attempts = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val decrementButton: ImageButton = view.findViewById(R.id.decrementButton)
        val guessEditText: EditText = view.findViewById(R.id.guessEditText)
        val incrementButton: ImageButton = view.findViewById(R.id.incrementButton)
        val okButton: Button = view.findViewById(R.id.okButton)
        val attemptsTextView: TextView = view.findViewById(R.id.attemptsTextView)

        decrementButton.setOnClickListener {
            val currentGuess = guessEditText.text.toString().toIntOrNull() ?: 0
            if (currentGuess > 1) {
                guessEditText.setText((currentGuess - 1).toString())
            }
        }

        incrementButton.setOnClickListener {
            val currentGuess = guessEditText.text.toString().toIntOrNull() ?: 0
            if (currentGuess < 100) {
                guessEditText.setText((currentGuess + 1).toString())
            }
        }

        okButton.setOnClickListener {
            val userGuess = guessEditText.text.toString().toIntOrNull()
            if (userGuess != null) {
                attempts++
                attemptsTextView.text = "Number of attempts: $attempts"
                if (userGuess == randomNumber) {
                    Toast.makeText(context, "Congratulations! You guessed correctly.", Toast.LENGTH_LONG).show()
                    // TODO: Store the score and name in the database and navigate back to the main screen
                } else if (userGuess < randomNumber) {
                    Toast.makeText(context, "Guess higher!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Guess lower!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Please enter a valid guess.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
