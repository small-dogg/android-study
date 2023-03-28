package com.smalldogg.study.android

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.run_on_ui_thread_activity.*
import kotlin.concurrent.thread

//RunOnUiThread, Thread, Handler

class RunOnUiThreadActivity : AppCompatActivity() {

    var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.run_on_ui_thread_activity)

        button120.setOnClickListener {
            val now = System.currentTimeMillis()
            textView66.text = "버튼 클릭 : ${now}"
        }

        isRunning = true
        thread {
            while (isRunning) {
                SystemClock.sleep(500)
                val now2 = System.currentTimeMillis()
                Log.d("test", "Thread : ${now2}")

//                runOnUiThread(object : Thread(){
//                    override fun run() {
//                        super.run()
//                        textView67.text = "RunOnUiThread : ${now2}"
//                    }
//                })

                runOnUiThread{
                    textView67.text = "runOnUiThread : ${now2}"
                }


                SystemClock.sleep(500)

//                runOnUiThread(object: Thread(){
//                    override fun run() {
//                        super.run()
//                       textView67.text = "또다른 작업"
//                    }
//                })

                runOnUiThread{
                    textView67.text = "또다른 작업 : ${now2}"
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }

}