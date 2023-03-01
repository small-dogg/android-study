package com.smalldogg.study.android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.start_activity.*

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity)

        button80.setOnClickListener {
            val second_intent = Intent(this,SecondActivity::class.java)
            startActivity(second_intent)
        }
    }

}