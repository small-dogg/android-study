package com.smalldogg.study.android

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.graphics.Color
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import androidx.core.app.NotificationCompat
import kotlin.concurrent.thread

class IPCTestService : Service() {

    var value = 0
    var isRunning = false
    var binder = LocalBinder()

    //외부에서 서비스에 접속하면 호출되는 메서드
    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            //채널 객체 생성
            val channel = NotificationChannel("service","service", NotificationManager.IMPORTANCE_HIGH)
            // 메시지 출력시 단말기 LED를 사용할 것인가.
            channel.enableLights(true)
            // LED 색상 설정
            channel.lightColor = Color.RED
            // 진동 사용여부
            channel.enableVibration(true)

            manager.createNotificationChannel(channel)

            val builder = NotificationCompat.Builder(this, "service")

            builder.setSmallIcon(android.R.drawable.ic_menu_camera)
            builder.setContentTitle("서비스 가동")
            builder.setContentText("서비스가 가동 중 입니다.")

            val notification = builder.build()
            startForeground(10,notification)
        }

        isRunning = true

        thread{
            while (isRunning) {
                SystemClock.sleep(500)
                Log.d("test", "value : ${value}")
                value++
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }

    //변수의 값을 반환하는 메서드
    fun getNumber() : Int{
        return value
    }

    //접속하는 Activity에서 서비스를 추출하기 위해 사용하는 객체
    inner class LocalBinder : Binder() {
        fun getService() : IPCTestService{
            //레이블
            return this@IPCTestService
        }
    }
}