package com.example.mad_fundamentals_DrinkingEligibility
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mad_fundamentals.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val ageInput = findViewById<EditText>(R.id.ageInput)
        val genderInput = findViewById<EditText>(R.id.genderInput)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val checkButton = findViewById<Button>(R.id.checkButton)

        checkButton.setOnClickListener {
            val name = nameInput.text.toString()
            val age = ageInput.text.toString().toIntOrNull()
            val gender = genderInput.text.toString()

            if (name.isBlank() || age == null || gender.isBlank()) {
                "Please fill out all fields correctly.".also { it.also { it.also { resultTextView.text = it } } }
            } else {
                val eligibility = if (age >= 18) "eligible" else "not eligible"
                "Hello $name ($gender), you are $eligibility to drink.".also { resultTextView.text = it }
            }
        }
    }
}

