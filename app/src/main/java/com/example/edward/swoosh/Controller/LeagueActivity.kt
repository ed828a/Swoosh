package com.example.edward.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.edward.swoosh.Model.Player
import com.example.edward.swoosh.R
import com.example.edward.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    val player = Player()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        buttonNext.setOnClickListener {
            if (!buttonMens.isChecked && !buttonWomens.isChecked && !buttonCoed.isChecked){
                player.league = ""
            }

            if (player.league.isEmpty()){
                Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()

            } else {
                val intent = Intent(this, SkillActivity::class.java)
                intent.putExtra(EXTRA_PLAYER, player)
                startActivity(intent)
            }
        }

        buttonMens.setOnClickListener {
            buttonWomens.isChecked = false
            buttonCoed.isChecked = false
            player.league = "Mens"
        }

        buttonWomens.setOnClickListener {
            buttonMens.isChecked = false
            buttonCoed.isChecked = false
            player.league = "Womens"
        }

        buttonCoed.setOnClickListener {
            buttonMens.isChecked = false
            buttonWomens.isChecked = false
            player.league = "Co-ed"
        }
    }

    override fun onStart() {
        when(player.league){
            "Mens" -> buttonMens.isChecked = true
            "Womens" -> { buttonWomens.isChecked = true }
            "Co-ed" -> { buttonCoed.isChecked = true }
        }
        super.onStart()
    }
}
