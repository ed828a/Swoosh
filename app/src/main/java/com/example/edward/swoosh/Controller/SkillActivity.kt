package com.example.edward.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.edward.swoosh.Model.Player
import com.example.edward.swoosh.R
import com.example.edward.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var player = Player()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        player = intent.getParcelableExtra(EXTRA_PLAYER)
        //        Toast.makeText(this, "You are in $league.", Toast.LENGTH_SHORT).show()

        buttonBeginner.setOnClickListener {
            buttonBaller.isChecked = false
            player.skill = "Beginner"
        }

        buttonBaller.setOnClickListener{
            buttonBeginner.isChecked = false
            player.skill = "Baller"
        }

        buttonFinish.setOnClickListener {
            if (!buttonBeginner.isChecked && !buttonBaller.isChecked){
                player.skill = ""
            }

            if (!player.skill.isEmpty()){
                val intent = Intent(this, SearchActivity::class.java)
                intent.putExtra(EXTRA_PLAYER, player)

                startActivity(intent)
            } else {
                Toast.makeText(this, "Please select a skill.", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onStart() {
        when(player.skill){
            "Beginner" -> buttonBeginner.isChecked = true
            "Baller" -> buttonBaller.isChecked = true
        }

        super.onStart()
    }
}
