package com.example.edward.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import com.example.edward.swoosh.R
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        buttonGetStart.setOnClickListener{
            val intent = Intent(this, LeagueActivity::class.java)
            startActivity(intent)
        }
    }
}
