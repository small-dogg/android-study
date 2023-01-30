package com.smalldogg.study.android

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.text_view_activity.*

class TextViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.text_view_activity)

        val text1 = findViewById<TextView>(R.id.text1)
        text1.text = "반갑습니다."

        findViewById<TextView>(R.id.textview_text2).text="헬로우!!"


        textview_text2.text="오우 이게 되네?"
        textview_text2.setBackgroundColor(Color.RED)

        text1.append("추가입니다")
    }

}