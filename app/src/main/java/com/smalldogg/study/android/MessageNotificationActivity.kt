package com.smalldogg.study.android

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.Person
import androidx.core.graphics.drawable.IconCompat
import kotlinx.android.synthetic.main.message_notification_activity.*

class MessageNotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.message_notification_activity)

        button116.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                val builder1 = getNotificationBuilder("message", "message style")
                builder1.setContentTitle("Message Style")
                builder1.setContentText("Message Style Notification")
                builder1.setSmallIcon(android.R.drawable.ic_input_delete)

                val personBuilder1 = Person.Builder()
                val icon1 = IconCompat.createWithResource(this, android.R.drawable.ic_media_next)
                personBuilder1.setIcon(icon1)
                personBuilder1.setName("홍길동")
                val person1 = personBuilder1.build()

                val personBuilder2 = Person.Builder()
                val icon2 = IconCompat.createWithResource(this, R.mipmap.ic_launcher)
                personBuilder2.setIcon(icon2)
                personBuilder2.setName("최길동")
                val person2 = personBuilder2.build()

                val messageStyle = NotificationCompat.MessagingStyle(person1)
                messageStyle.addMessage("첫 번째 메시지", System.currentTimeMillis(), person1)
                messageStyle.addMessage("두 번째 메시지", System.currentTimeMillis(), person2)
                messageStyle.addMessage("세 번째 메시지", System.currentTimeMillis(), person1)
                messageStyle.addMessage("네 번째 메시지", System.currentTimeMillis(), person2)

                builder1.setStyle(messageStyle)


                val notification = builder1.build()
                val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                manager.notify(10, notification)

            }
        }
    }

    // 안드로이드 8.0 이상과 미만 버전에 대응하기 위해 채널을 설정하는 메서드
    fun getNotificationBuilder(id: String, name: String) : NotificationCompat.Builder {

        //os 버전별로 분기
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // 안드로이드 9.0 이상인 경우,
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