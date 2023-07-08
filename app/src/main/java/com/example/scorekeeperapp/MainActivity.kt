package com.example.scorekeeperapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var teamAScore = 0
    private var teamAWickets = 0
    private var teamBScore = 0
    private var teamBWickets = 0
    private var ballsThrown = 0
    private var overs = 0

    private lateinit var teamAScoreTextView: TextView
    private lateinit var teamBScoreTextView: TextView
    private lateinit var oversTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        teamAScoreTextView = findViewById(R.id.teamAScore)
        teamBScoreTextView = findViewById(R.id.teamBScore)
        oversTextView = findViewById(R.id.oversTextView)

        val teamASixButton: Button = findViewById(R.id.teamASixButton)
        teamASixButton.setOnClickListener { updateScore("A", 6) }

        val teamAFourButton: Button = findViewById(R.id.teamAFourButton)
        teamAFourButton.setOnClickListener { updateScore("A", 4) }

        val teamARunButton: Button = findViewById(R.id.teamARunButton)
        teamARunButton.setOnClickListener { updateScore("A", 1) }

        val teamAWicketButton: Button = findViewById(R.id.teamAWicketButton)
        teamAWicketButton.setOnClickListener { updateWicket("A") }

        val teamBSixButton: Button = findViewById(R.id.teamBSixButton)
        teamBSixButton.setOnClickListener { updateScore("B", 6) }

        val teamBFourButton: Button = findViewById(R.id.teamBFourButton)
        teamBFourButton.setOnClickListener { updateScore("B", 4) }

        val teamBRunButton: Button = findViewById(R.id.teamBRunButton)
        teamBRunButton.setOnClickListener { updateScore("B", 1) }

        val teamBWicketButton: Button = findViewById(R.id.teamBWicketButton)
        teamBWicketButton.setOnClickListener { updateWicket("B") }
    }

    private fun updateScore(team: String, runs: Int) {
        if (team == "A") {
            teamAScore += runs
            teamAScoreTextView.text = "Team A: $teamAScore/$teamAWickets"
        } else if (team == "B") {
            teamBScore += runs
            teamBScoreTextView.text = "Team B: $teamBScore/$teamBWickets"
        }

        ballsThrown++
        if (ballsThrown == 6) {
            ballsThrown = 0
            overs++
            oversTextView.text = "Overs: $overs"
        }
    }

    private fun updateWicket(team: String) {
        if (team == "A") {
            teamAWickets++
            teamAScoreTextView.text = "Team A: $teamAScore/$teamAWickets"
        } else if (team == "B") {
            teamBWickets++
            teamBScoreTextView.text = "Team B: $teamBScore/$teamBWickets"
        }

        ballsThrown++
        if (ballsThrown == 6) {
            ballsThrown = 0
            overs++
            oversTextView.text = "Overs: $overs"
        }
    }
}
