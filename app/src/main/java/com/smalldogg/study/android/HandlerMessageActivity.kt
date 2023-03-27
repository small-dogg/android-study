package com.smalldogg.study.android

import android.os.*
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.handler_message_activity.*
import kotlin.concurrent.thread

class HandlerMessageActivity : AppCompatActivity() {

    var isRunning = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.handler_message_activity)

        button119.setOnClickListener {
            val now = System.currentTimeMillis()
            textView64.text = "버튼 클릭 : ${now}"
        }

        val handler1 = object : Handler(Looper.myLooper()!!) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)

                when(msg.what){
                    0 -> {
                        textView65.text = "Hanlder 0"
                    }
                    1 -> {
                        textView65.text = "Hanlder 1"
                    }
                    2 -> {
                        textView65.text = "Hanlder 2 : ${msg.arg1}, ${msg.arg2}, ${msg.obj}"
                    }
                }
            }
        }

        isRunning = true

        thread {
            while (isRunning) {
                val now2 = System.currentTimeMillis()
                Log.d("test","오래 걸리는 작업 : ${now2}")

                SystemClock.sleep(500)

                handler1.sendEmptyMessage(0)

                SystemClock.sleep(500)
                handler1.sendEmptyMessage(1)

                SystemClock.sleep(500)
                val msg = Message()
                msg.what = 2
                msg.arg1 = 100
                msg.arg2 = 200
                msg.obj = "객체"
                handler1.sendMessage(msg)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }

}