package com.smalldogg.study.android

import android.app.ActivityManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.ipc_activity.*

class IPCActivity : AppCompatActivity() {

    //접속한 서비스 객체
    var ipcService:IPCTestService? = null

    //서비스 접속을 관리하는 객체
    val connection = object : ServiceConnection {
        //서비스에 접속이 성공했을 때
        // 두번째 매개변수가 서비스의 onBind 메서드가 반환하는 객체를 받는다
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            //서비스를 추출한다.
            val binder = p1 as IPCTestService.LocalBinder
            ipcService = binder.getService()

        }

        //서비스에 접속이 해제도이ㅓㅆ을 때
        override fun onServiceDisconnected(p0: ComponentName?) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ipc_activity)

        //서비스가 가동 중이 아니라면 서비스를 가동한다.
        val chk = isServiceRunning("com.smalldogg.study.android.IPCTestService")
        val serviceIntent = Intent(this,IPCTestService::class.java)
        if (!chk) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(serviceIntent)
            } else {
                startService(serviceIntent)
            }
        }

        //서비스에 접속한다.
        bindService(serviceIntent, connection, Context.BIND_AUTO_CREATE)

        button124.setOnClickListener {
            var value = ipcService?.getNumber()
            textView68.text = "value : $value"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(connection)
    }

    //서비스 실해 여부를 검사하는 메서드
    fun isServiceRunning(name: String): Boolean {
        val manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        //현재 실행중인 서비스들을 가져온다.
        val serviceList = manager.getRunningServices(Int.MAX_VALUE)

        for (serviceInfo in serviceList) {
            //서비스의 이름이 원하는 이름인가..
            if (serviceInfo.service.className == name) {
                return true
            }
        }
        return false
    }

}