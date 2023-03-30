package com.smalldogg.study.android

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import kotlin.concurrent.thread

class TestService : Service() {
    var isRunning = true

    override fun onBind(intent: Intent): IBinder {
        TODO()
    }

    //서비스가 가동될 때, 호출되는 메서드
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.d("test", "서비스 가동")

        thread {
            while (isRunning) {
                SystemClock.sleep(500)
                val now = System.currentTimeMillis()
                Log.d("test","Service : ${now}")
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    //서비스가 중지되고 소멸될 때 호출되는 메서드
    override fun onDestroy() {

        isRunning = false
        Log.d("test", "서비스 중지")
        super.onDestroy()
    }
}