package com.smalldogg.study.android

import android.app.ActivityManager
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class IPCActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_activity)

    }

    //서비스 실해 여부를 검사하는 메서드
    fun isServiceRunning(name: String): Boolean {
        val manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        //현재 실행중인 서비스들을 가져온다.
        val serviceList = manager.getRunningServices(Int.MAX_VALUE)

    }

}