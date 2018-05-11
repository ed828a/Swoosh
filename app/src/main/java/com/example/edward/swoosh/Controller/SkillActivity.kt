package com.example.edward.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.edward.swoosh.R
import com.example.edward.swoosh.Utilities.EXTRA_LEAGUE
import com.example.edward.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        league = intent.getStringExtra(EXTRA_LEAGUE)
//        Toast.makeText(this, "You are in $league.", Toast.LENGTH_SHORT).show()

        buttonBeginner.setOnClickListener {
            buttonBaller.isChecked = false
            skill = "Beginner"
        }

        buttonBaller.setOnClickListener{
            buttonBeginner.isChecked = false
            skill = "Baller"
        }

        buttonFinish.setOnClickListener {
            if (!buttonBeginner.isChecked && !buttonBaller.isChecked){
                skill = ""
            }

            if (!skill.isEmpty()){
                val intent = Intent(this, SearchActivity::class.java)
                intent.putExtra(EXTRA_LEAGUE, league)
                intent.putExtra(EXTRA_SKILL, skill)

                startActivity(intent)
            } else {
                Toast.makeText(this, "Please select a skill.", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onStart() {
        when(skill){
            "Beginner" -> buttonBeginner.isChecked = true
            "Baller" -> buttonBaller.isChecked = true
        }

        super.onStart()
    }
}
