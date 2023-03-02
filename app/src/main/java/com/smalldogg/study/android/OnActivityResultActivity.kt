package com.smalldogg.study.android

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.on_activity_result_activity.*

class OnActivityResultActivity : AppCompatActivity() {

    val SECOND_ACTIVITY = 100
    val THIRD_ACTIVITY = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.on_activity_result_activity)

        button82.setOnClickListener {
            val second_intent = Intent(this, SecondActivity_2::class.java)
//            startActivity(second_intent)

            startActivityForResult(second_intent, SECOND_ACTIVITY)
        }

        button85.setOnClickListener {
            val third_intent = Intent(this, ThirdActivity::class.java)
            startActivityForResult(third_intent, THIRD_ACTIVITY)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        textView39.text= "다른 Activity에서 돌아왔습니다."
        when (requestCode) {
            SECOND_ACTIVITY -> textView39.text = "SecondActivity에서 돌아왔어요"
            THIRD_ACTIVITY -> {
                when (resultCode) {
                    Activity.RESULT_OK -> textView39.text = "ThirdActivity에서 돌아왔어요:OK"
                    Activity.RESULT_CANCELED -> textView39.text = "ThirdActivity에서 돌아왔어요:CANCEL"
                    Activity.RESULT_FIRST_USER -> textView39.text = "ThirdActivity에서 돌아왔어요:U1"
                    Activity.RESULT_FIRST_USER+1 -> textView39.text = "ThirdActivity에서 돌아왔어요:U2"
                }

            }

        }
    }

}