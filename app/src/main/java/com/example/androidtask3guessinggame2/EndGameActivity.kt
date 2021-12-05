package com.example.androidtask3guessinggame2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EndGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game)

        val getMessage = intent.getStringExtra("result")
        val getNumber = intent.getStringExtra("number")
        if(getMessage=="False")
        {
            findViewById<TextView>(R.id.result).setTextColor(Color.RED)
            findViewById<TextView>(R.id.result).text = "$getNumber"
            findViewById<TextView>(R.id.message).text = "You Lost After 12 attempts. \n          The number is"
        }
        else if(getMessage=="True")
        {
            findViewById<TextView>(R.id.result).setTextColor(Color.GREEN)
            findViewById<TextView>(R.id.result).text = "$getNumber"
            findViewById<TextView>(R.id.message).text = "You Won! The Number is"
        }
    }
}