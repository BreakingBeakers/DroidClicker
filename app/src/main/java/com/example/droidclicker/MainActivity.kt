package com.example.droidclicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var tapIncAmount: Int = 1
    private var points: Int = 0
    private var clickerSet: ArrayList<ClickerTile> = ArrayList<ClickerTile>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var clickerRecyclerView: RecyclerView = findViewById(R.id.clicker_recyclerView)

        setupClickerList()

        var adapter : Clicker_RecyclerViewAdapter = Clicker_RecyclerViewAdapter(this, clickerSet)
        clickerRecyclerView.adapter = adapter
        clickerRecyclerView.layoutManager = LinearLayoutManager(this)

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

    fun setupClickerList() {
        var index: Int = 0
        clickerSet.add(ClickerTile())
        creatingClickerTile(index++)
        clickerSet.add(ClickerTile())
        clickerSet.add(ClickerTile())
        clickerSet.add(ClickerTile())
        clickerSet.add(ClickerTile())
    }

    fun creatingClickerTile(index: Int) {

    }

}