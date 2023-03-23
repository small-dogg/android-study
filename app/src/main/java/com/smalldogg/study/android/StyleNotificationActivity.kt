package com.smalldogg.study.android

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.style_notification_activity.*

class StyleNotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.style_notification_activity)

        button113.setOnClickListener {
            val builder1 = getNotificationBuilder("style","style Notification")
            builder1.setContentTitle("Big Picture")
            builder1.setContentText("Big Picture Notification")
            builder1.setSmallIcon(android.R.drawable.ic_menu_camera)

            //BigPicture Notification 객체를 생성한다.
            val big = NotificationCompat.BigPictureStyle(builder1)
            //보여줄 이미지를 설정한다.
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.img_android)
            big.bigPicture(bitmap)
            big.setBigContentTitle("Big Content Title")
            big.setSummaryText("Summary Text")


            val notification = builder1.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10, notification)
        }

        button114.setOnClickListener {
            val builder1 = getNotificationBuilder("style","style Notification")
            builder1.setContentTitle("Big Text")
            builder1.setContentText("Big Text Notification")
            builder1.setSmallIcon(android.R.drawable.ic_menu_camera)

            //Big Text Notification을 생성한다.
            val big = NotificationCompat.BigTextStyle(builder1)
            big.setSummaryText("Summary Text")
            big.setBigContentTitle("Big Content Title")
            big.bigText("동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세")


            val notification = builder1.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(20, notification)
        }

        button115.setOnClickListener {
            val builder1 = getNotificationBuilder("style","style Notification")
            builder1.setContentTitle("Big Picture")
            builder1.setContentText("Big Picture Notification")
            builder1.setSmallIcon(android.R.drawable.ic_menu_camera)

            //InBox Style Notification을 생성한다.
            val inbox = NotificationCompat.InboxStyle(builder1)
            inbox.setSummaryText("Summary Text")

            inbox.addLine("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
            inbox.addLine("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")
            inbox.addLine("cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc")
            inbox.addLine("cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc")


            val notification = builder1.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(30, notification)
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