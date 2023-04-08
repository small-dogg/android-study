package com.smalldogg.study.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second_activity.*

class SecondActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_activity)

        button132.setOnClickListener {
            finishActivity()
        }

    }

    //Backbutton을 누르면 호출되는 메서드
    override fun onBackPressed() {
        finishActivity()
    }

    fun finishActivity(){
        finish()
//        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
//        overridePendingTransition(android.R.anim.fade_out,android.R.anim.fade_in)
        overridePendingTransition(R.anim.slide_act_xml3,R.anim.slide_act_xml4)
    }
}