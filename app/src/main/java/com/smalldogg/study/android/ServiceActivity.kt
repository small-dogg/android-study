package com.smalldogg.study.android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.service_activity.*

class ServiceActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.service_activity)

        val serviceIntent = Intent(this, TestService::class.java)

        button122.setOnClickListener {
            startService(serviceIntent)
        }
        button123.setOnClickListener {
            stopService(serviceIntent)
        }
    }

}