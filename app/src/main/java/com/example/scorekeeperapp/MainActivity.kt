package com.example.scorekeeperapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.widget.Toast

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

        val toolbar: Toolbar = findViewById(R.id.topAppBar)
        setSupportActionBar(toolbar)

        teamAScoreTextView = findViewById(R.id.teamAScore)
        teamBScoreTextView = findViewById(R.id.teamBScore)
        oversTextView = findViewById(R.id.oversTextView)

        findViewById<Button>(R.id.teamASixButton)?.setOnClickListener { updateScore("A", 6) }
        findViewById<Button>(R.id.teamAFourButton)?.setOnClickListener { updateScore("A", 4) }
        findViewById<Button>(R.id.teamARunButton)?.setOnClickListener { updateScore("A", 1) }
        findViewById<Button>(R.id.teamAWicketButton)?.setOnClickListener { updateWicket("A") }

        findViewById<Button>(R.id.teamBSixButton)?.setOnClickListener { updateScore("B", 6) }
        findViewById<Button>(R.id.teamBFourButton)?.setOnClickListener { updateScore("B", 4) }
        findViewById<Button>(R.id.teamBRunButton)?.setOnClickListener { updateScore("B", 1) }
        findViewById<Button>(R.id.teamBWicketButton)?.setOnClickListener { updateWicket("B") }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.top_app_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                try {
                    val intent = Intent(this, AboutActivity::class.java)
                    startActivity(intent)
                } catch (e: Exception) {
                    e.printStackTrace()
                    showToast(" Mahek A00279780 Mobile Application Development ")
                }
                true
            }
            R.id.action_settings -> {
                try {
                    val intent = Intent(this, SettingsActivity::class.java)
                    startActivity(intent)
                } catch (e: Exception) {
                    e.printStackTrace()
                    showToast("Error opening SettingsActivity")
                }
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

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
