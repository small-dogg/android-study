package com.smalldogg.study.android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_animation_activity.*

class ActivityAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_activity)

        button131.setOnClickListener {
            val intent = Intent(this, SecondActivity3::class.java)
            startActivity(intent)
//            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
//            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            overridePendingTransition(R.anim.slide_act_xml1,R.anim.slide_act_xml2)
        }
    }

}