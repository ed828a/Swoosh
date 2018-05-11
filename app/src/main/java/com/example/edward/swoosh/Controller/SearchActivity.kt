package com.example.edward.swoosh.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.edward.swoosh.R
import com.example.edward.swoosh.Utilities.EXTRA_LEAGUE
import com.example.edward.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    var league: String = ""
    var skill: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        league = intent.getStringExtra(EXTRA_LEAGUE)
        skill = intent.getStringExtra(EXTRA_SKILL)

        if (!league.isEmpty() && !skill.isEmpty()){
            textViewMessage.text = "Looking for a $league $skill league near you ..."
        } else {
            progressBar.visibility = View.INVISIBLE
        }
    }
}
