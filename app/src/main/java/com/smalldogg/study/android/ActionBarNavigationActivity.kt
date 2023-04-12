package com.smalldogg.study.android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.action_bar_navigation_activity.*

// 이전 화면으로 이동할 수 있도록 좌측 상단에 메뉴 작성
class ActionBarNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.action_bar_navigation_activity)

        button133.setOnClickListener {
            val intent = Intent(this, SecondActivity4::class.java)
            startActivity(intent)
        }
    }

}