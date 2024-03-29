package com.smalldogg.study.android

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import androidx.core.app.NotificationCompat
import kotlin.concurrent.thread

class TestService : Service() {
    var isRunning = true

    override fun onBind(intent: Intent): IBinder {
        TODO()
    }

    //서비스가 가동될 때, 호출되는 메서드
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.d("test", "서비스 가동")

        //안드로이드 8.0 이상 부터
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val manager= getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channel = NotificationChannel("service", "serice", NotificationManager.IMPORTANCE_HIGH)

            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)
            manager.createNotificationChannel(channel)

            val builder = NotificationCompat.Builder(this, "service")
            builder.setSmallIcon(android.R.drawable.ic_menu_search)
            builder.setContentTitle("서비스 가동")
            builder.setContentText("서비스가 가동 중입니다.")
            val notification = builder.build()

            //알림 메시지가 Foreground 서비스를 위해 표시한다.
            startForeground(10, notification)
        }

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