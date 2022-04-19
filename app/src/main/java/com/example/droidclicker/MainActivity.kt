package com.example.droidclicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var tapIncAmount: Int = 1
    private var points: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var progressBar: ProgressBar = findViewById(R.id.progressBar)
        var button:Button = findViewById(R.id.tapButton)
        var upgradeButton:Button = findViewById(R.id.upgradeButton)
        var pointText: TextView = findViewById(R.id.pointText)

        button.setOnClickListener{
            if(progressBar.progress < 10) {
                progressBar.progress += tapIncAmount
            } else {
                addPoints(pointText)
                progressBar.progress = 0
            }
        }

        upgradeButton.setOnClickListener{
            if(points >= 100) {
                tapIncAmount += 1
                points -= 100
                pointText.text = points.toString()
            }
        }
    }

    private fun addPoints(pointText: TextView) {
        points += 5
        pointText.text = points.toString()
    }



}