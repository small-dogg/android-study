package com.smalldogg.study.android

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.handler_activity.*

class HandlerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.handler_activity)

        button118.setOnClickListener {
            val now = System.currentTimeMillis()
            textView62.text = "버튼 클릭 : ${now}"
        }

//        while (true) {
//            SystemClock.sleep(100)
//            val now2 = System.currentTimeMillis()
//            textView63.text = "while문 : ${now2}"
//        }

        val handler = Handler(Looper.myLooper()!!)

        //처리 한번에 대한 작업을 구현해준다.
        val thread1 = object : Thread() {
            override fun run() {
                super.run()
                val now2 = System.currentTimeMillis()
                textView63.text = "handler : ${now2}"

//                handler.post(this)
                handler.postDelayed(this, 100)
            }
        }

//        handler.post(thread1)
        handler.postDelayed(thread1, 100)
    }


}