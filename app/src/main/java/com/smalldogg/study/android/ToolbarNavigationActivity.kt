package com.smalldogg.study.android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.action_bar_navigation_activity.*
import kotlinx.android.synthetic.main.activity_second5.*
import kotlinx.android.synthetic.main.toolbar_navigation_activity.*

class ToolbarNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.toolbar_navigation_activity)

        setSupportActionBar(toolbar4)

        button135.setOnClickListener {
            val intent = Intent(this, SecondActivity5::class.java)
            startActivity(intent)
        }
    }

}