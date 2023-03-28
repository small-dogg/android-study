package com.smalldogg.study.android

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.broad_cast_receiver_activity.*

//Broad Cast Receiver는 안드로이드 OS에서 특정한 상황에 발생하는 메시지를 받아들여 동작하는 실행 단위이다.
// Broad Cast Receiver를 통해 외부에서 접근하기 때문에 반드시 이름이 존재해야한다.
class BroadCastReceiverActivity : AppCompatActivity() {

    val br = TestReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.broad_cast_receiver_activity)



        button121.setOnClickListener {
            //8.0 이상 부터는 코드를 통해 BroadCastReceiver를 등록하고 해제해야 한다.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val filter = IntentFilter("com.smalldogg.study.android.testbr")
                registerReceiver(br, filter)
            } else {
//            val brIntent = Intent(this, TestReceiver::class.java)
                val brIntent = Intent("com.smalldogg.study.android.testbr")
                sendBroadcast(brIntent)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            unregisterReceiver(br)
        }
    }

}