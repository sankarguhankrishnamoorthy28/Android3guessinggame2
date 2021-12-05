package com.example.androidtask3guessinggame2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var secretKey = findViewById<EditText>(R.id.secretKey)
        var guessedUserInput = findViewById<TextInputLayout>(R.id.guess)
        val clickMeButton = findViewById<TextView>(R.id.clickEvent)
        val viewResult = findViewById<TextView>(R.id.resultMessage)
        var count = 0

        clickMeButton.setOnClickListener {
            val newScreenIntend = Intent(this, EndGameActivity::class.java)

            count++


            if(secretKey.text.toString().toInt() == guessedUserInput.editText?.text.toString().toInt()!! && count<=12)
            {
                newScreenIntend.putExtra("result", "True")
                newScreenIntend.putExtra("number", secretKey.text.toString())
                startActivity(newScreenIntend)
                count = 0
            }
            else if(secretKey.text.toString().toInt() != guessedUserInput.editText?.text.toString().toInt()!! && count==12)
            {
                newScreenIntend.putExtra("result", "False")
                newScreenIntend.putExtra("number", secretKey.text.toString())
                startActivity(newScreenIntend)
                count = 0
            }
            else
            {
                val maskedValue =
                    if(secretKey.text.toString().toInt() > guessedUserInput.editText?.text.toString().toInt()!!) "No :) My number is bigger"
                    else "No :) My number is smaller"
                viewResult.text = "$maskedValue  \n You have attempted $count times"

            }
        }
    }
}