package com.smalldogg.study.android

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.action_bar_custom_activity.view.*
import kotlinx.android.synthetic.main.custom_actionbar.view.*

class ActionBarCustomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.action_bar_custom_activity)

        //버전에 따라 커스텀 액션바가 노출이 안될 수 있어서 아래의 설정을 추가해야 함.
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        //layout을 통해 View를 생성한다.
        val topBar = layoutInflater.inflate(R.layout.custom_actionbar, null)
        supportActionBar?.customView = topBar

        topBar.run {
            textView78.text = "커스텀 액션바"
            textView78.setTextColor(Color.WHITE)

            button134.setOnClickListener {
                textView77.text = "액션바의 버튼을 눌렀습니다."
            }
        }
    }

}