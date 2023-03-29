package com.smalldogg.study.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SystemMessageActivity : AppCompatActivity() {

    val permissionList = arrayOf(
        android.Manifest.permission.RECEIVE_BOOT_COMPLETED,
        android.Manifest.permission.READ_PHONE_STATE,
        android.Manifest.permission.RECEIVE_SMS
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.system_message_activity)

        requestPermissions(permissionList, 0)
    }

}