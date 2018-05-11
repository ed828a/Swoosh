package com.example.edward.swoosh

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        buttonNext.setOnClickListener {
            if (!buttonMens.isChecked && !buttonWomens.isChecked && !buttonCoed.isChecked){
                selectedLeague = ""
            }

            if (selectedLeague.isEmpty()){
                Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()

            } else {
                val intent = Intent(this, SkillActivity::class.java)
                intent.putExtra(KEY_LEAGUE, selectedLeague)
                startActivity(intent)
            }
        }

        buttonMens.setOnClickListener {
            buttonWomens.isChecked = false
            buttonCoed.isChecked = false
            selectedLeague = "Mens"
        }

        buttonWomens.setOnClickListener {
            buttonMens.isChecked = false
            buttonCoed.isChecked = false
            selectedLeague = "Womens"
        }

        buttonCoed.setOnClickListener {
            buttonMens.isChecked = false
            buttonWomens.isChecked = false
            selectedLeague = "Co-ed"
        }
    }

    override fun onStart() {
        when(selectedLeague){
            "Mens" -> buttonMens.isChecked = true
            "Womens" -> { buttonWomens.isChecked = true }
            "Co-ed" -> { buttonCoed.isChecked = true }
        }
        super.onStart()
    }
}
