package com.smalldogg.study.android

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.thread_activity.*
import kotlin.concurrent.thread

class ThreadActivity : AppCompatActivity() {

    var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.thread_activity)

        button117.setOnClickListener {
            val now = System.currentTimeMillis()
            textView61.text = "버튼 클릭 : ${now}"
        }

//        while (true) {
//            SystemClock.sleep(1000)
//            val now2 = System.currentTimeMillis()
//            Log.d("test", "while 문 : ${now2}")
//        }

        isRunning = true

//        val thread1 = object : Thread() {
//            override fun run() {
//                super.run()
//                while (isRunning) {
//                    SystemClock.sleep(100)
//                    val now2 = System.currentTimeMillis()
//                    Log.d("test", "Thread : ${now2}")
//                    textView60.text = "Thread : ${now2}"
//                }
//
//            }
//        }
//        thread1.start()

        thread{
            while (isRunning) {
                SystemClock.sleep(100)
                val now2 = System.currentTimeMillis()
                Log.d("test","Thread : $now2")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }

}