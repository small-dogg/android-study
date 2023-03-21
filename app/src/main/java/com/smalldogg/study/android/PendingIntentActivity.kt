package com.smalldogg.study.android

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.pending_intent_activity.*

class PendingIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pending_intent_activity)

        button111.setOnClickListener {
            val builder1 = getNotification("pending", "pending intent")
            builder1.setContentText("notification 1")
            builder1.setContentText("알림 메시지 1입니다")
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)

            //메시지를 터치하면 실행할 Activity를 관리할 Intent 생성
            val intent1 = Intent(this,NotificationActivity1::class.java)

            val pending1 = PendingIntent.getActivity(this, 10, intent1, PendingIntent.FLAG_UPDATE_CURRENT)
            builder1.setContentIntent(pending1)

            val notification = builder1.build()
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10, notification)
        }

        button112.setOnClickListener {
            val builder1 = getNotification("pending", "pending intent")
            builder1.setContentText("notification 2")
            builder1.setContentText("알림 메시지 2입니다")
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)

            //메시지를 터치하면 자동으로 메시지를 제거한다.
            builder1.setAutoCancel(true)

            //메시지를 터치하면 실행할 Activity를 관리할 Intent 생성
            val intent1 = Intent(this,NotificationActivity2::class.java)
            intent1.putExtra("data1", 100)
            intent1.putExtra("data2", "200")


            val pending1 = PendingIntent.getActivity(this, 10, intent1, PendingIntent.FLAG_UPDATE_CURRENT)
            builder1.setContentIntent(pending1)

            //Action 설정
            val intent2 = Intent(this, NotificationActivity3::class.java)
            val pending2 = PendingIntent.getActivity(this, 100, intent2, PendingIntent.FLAG_UPDATE_CURRENT)
            val builder2 = NotificationCompat.Action.Builder(android.R.drawable.ic_menu_compass, "Action 1", pending2)
            val action2 = builder2.build()
            builder1.addAction(action2)

            val intent3 = Intent(this, NotificationActivity4::class.java)
            val pending3 = PendingIntent.getActivity(this, 100, intent3, PendingIntent.FLAG_UPDATE_CURRENT)
            val builder3 = NotificationCompat.Action.Builder(android.R.drawable.ic_menu_agenda, "Action 2", pending3)
            val action3 = builder3.build()
            builder1.addAction(action3)

            val notification = builder1.build()
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(20, notification)
        }
    }

    fun getNotification(id: String, name: String): NotificationCompat.Builder {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)
            manager.createNotificationChannel(channel)
            return NotificationCompat.Builder(this, id)

        }else{
            return NotificationCompat.Builder(this)
        }
    }
}