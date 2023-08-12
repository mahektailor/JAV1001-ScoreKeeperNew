package com.example.scorekeeperapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    // Variables to track scores, wickets, balls, and overs
    private var teamAScore = 0
    private var teamAWickets = 0
    private var teamBScore = 0
    private var teamBWickets = 0
    private var ballsThrown = 0
    private var overs = 0

    // TextViews to display scores and overs
    private lateinit var teamAScoreTextView: TextView
    private lateinit var teamBScoreTextView: TextView
    private lateinit var oversTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the custom Toolbar
        val toolbar: Toolbar = findViewById(R.id.topAppBar)
        setSupportActionBar(toolbar)

        // Initialize TextViews
        teamAScoreTextView = findViewById(R.id.teamAScore)
        teamBScoreTextView = findViewById(R.id.teamBScore)
        oversTextView = findViewById(R.id.oversTextView)

        // Set click listeners for Team A buttons
        findViewById<Button>(R.id.teamASixButton).setOnClickListener { updateScore("A", 6) }
        findViewById<Button>(R.id.teamAFourButton).setOnClickListener { updateScore("A", 4) }
        findViewById<Button>(R.id.teamARunButton).setOnClickListener { updateScore("A", 1) }
        findViewById<Button>(R.id.teamAWicketButton).setOnClickListener { updateWicket("A") }

        // Set click listeners for Team B buttons
        findViewById<Button>(R.id.teamBSixButton).setOnClickListener { updateScore("B", 6) }
        findViewById<Button>(R.id.teamBFourButton).setOnClickListener { updateScore("B", 4) }
        findViewById<Button>(R.id.teamBRunButton).setOnClickListener { updateScore("B", 1) }
        findViewById<Button>(R.id.teamBWicketButton).setOnClickListener { updateWicket("B") }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.top_app_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                // Handle About item click
                true
            }
            R.id.action_settings -> {
                // Launch the SettingsActivity
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
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
