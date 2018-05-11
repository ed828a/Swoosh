package com.example.edward.swoosh.Controller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.edward.swoosh.Model.Player
import com.example.edward.swoosh.R
import com.example.edward.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)


        if (!player.isEmpty()){
            textViewMessage.text = "Looking for a ${player.league} ${player.skill} league near you ..."
        } else {
            progressBar.visibility = View.INVISIBLE
        }
    }
}
