package com.example.edward.swoosh

import android.os.Bundle
import android.widget.Toast

class SkillActivity : BaseActivity() {

    var league = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        league = intent.getStringExtra(KEY_LEAGUE)
        Toast.makeText(this, "You are in $league.", Toast.LENGTH_SHORT).show()
    }
}
