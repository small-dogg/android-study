package com.smalldogg.study.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_notification2.*

class NotificationActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification2)

        //Activity를 실행했을 때 사용한 intent를 통해 데이터를 추출한다

        val data1 = intent.getIntExtra("data1",0)
        val data2 = intent.getStringExtra("data2")

        textView57.text = "${data1}"
        textView57.append(data2)
    }
}