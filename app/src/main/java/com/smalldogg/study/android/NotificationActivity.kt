package com.smalldogg.study.android

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.notification_activity.*

class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notification_activity)

        button98.setOnClickListener {
            val builder1 = getNotificationBuilder("channel1", "첫 번째 채널")

            //작은 아이콘(메시지 수신시 상단에 보여줄 작은 아이콘)
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            //큰 아이콘(메시지 본문에 표시할 메시지. Bitmap 객체)
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            // 숫자 설정
            builder1.setNumber(100)
            //타이틀 설정
            builder1.setContentTitle("Content Title 1")
            //내용 설정
            builder1.setContentText("Content Text 1")

            //메시지 객체 생성
            val notification = builder1.build()
            //알림 메시지를 관리하는 객체를 추출한다.
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            //알림 메시지를 출력한다.
            manager.notify(10, notification)
        }

        button108.setOnClickListener {
            val builder1 = getNotificationBuilder("channel1", "첫 번째 채널")

            //작은 아이콘(메시지 수신시 상단에 보여줄 작은 아이콘)
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            //큰 아이콘(메시지 본문에 표시할 메시지. Bitmap 객체)
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            // 숫자 설정
            builder1.setNumber(100)
            //타이틀 설정
            builder1.setContentTitle("Content Title 2")
            //내용 설정
            builder1.setContentText("Content Text 2")

            //메시지 객체 생성
            val notification = builder1.build()
            //알림 메시지를 관리하는 객체를 추출한다.
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            //알림 메시지를 출력한다.
            manager.notify(11, notification)
        }

        button109.setOnClickListener {
            val builder1 = getNotificationBuilder("channel2", "두 번째 채널")

            //작은 아이콘(메시지 수신시 상단에 보여줄 작은 아이콘)
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            //큰 아이콘(메시지 본문에 표시할 메시지. Bitmap 객체)
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            // 숫자 설정
            builder1.setNumber(100)
            //타이틀 설정
            builder1.setContentTitle("Content Title 3")
            //내용 설정
            builder1.setContentText("Content Text 3")

            //메시지 객체 생성
            val notification = builder1.build()
            //알림 메시지를 관리하는 객체를 추출한다.
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            //알림 메시지를 출력한다.
            manager.notify(30, notification)
        }

        button110.setOnClickListener {

            val builder1 = getNotificationBuilder("channel2", "두 번째 채널")

            //작은 아이콘(메시지 수신시 상단에 보여줄 작은 아이콘)
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            //큰 아이콘(메시지 본문에 표시할 메시지. Bitmap 객체)
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            // 숫자 설정
            builder1.setNumber(100)
            //타이틀 설정
            builder1.setContentTitle("Content Title 4")
            //내용 설정
            builder1.setContentText("Content Text 4")

            //메시지 객체 생성
            val notification = builder1.build()
            //알림 메시지를 관리하는 객체를 추출한다.
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            //알림 메시지를 출력한다.
            manager.notify(40, notification)
        }
    }

    // 안드로이드 8.0 이상과 미만 버전에 대응하기 위해 채널을 설정하는 메서드
    fun getNotificationBuilder(id: String, name: String) : NotificationCompat.Builder {

        //os 버전별로 분기

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // 안드로이드 8.0 이상인 경우,
            // 알림 메시지를 관리하는 객체를 추출한다.
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            //채널 객체 생성
            val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            // 메시지 출력시 단말기 LED를 사용할 것인가.
            channel.enableLights(true)
            // LED 색상 설정
            channel.lightColor = Color.RED
            // 진동 사용여부
            channel.enableVibration(true)

            //알림 메시지를 관리하는 객체에 채널을 등록한다.
            manager.createNotificationChannel(channel)

            return NotificationCompat.Builder(this, id)

        }else {
            return NotificationCompat.Builder(this)

        }
    }

}