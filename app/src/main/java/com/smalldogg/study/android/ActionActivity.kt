package com.smalldogg.study.android

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.action_activity.*

class ActionActivity : AppCompatActivity() {

    val permission_list = arrayOf(
        android.Manifest.permission.CALL_PHONE
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.action_activity)

        requestPermissions(permission_list, 0)

        button94.setOnClickListener {
            val uri = Uri.parse("geo:37.243243, 131.861601")
            val intent = Intent(Intent.ACTION_VIEW, uri)

            startActivity(intent)
        }

        button95.setOnClickListener {
            val uri = Uri.parse("https://developer.andorid.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        button96.setOnClickListener {
            val uri = Uri.parse("tel:+821044746679")
            val intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }

        button97.setOnClickListener {
            val uri = Uri.parse("tel:01044746679")
            val intent = Intent(Intent.ACTION_CALL, uri)
            startActivity(intent)
        }
    }

}