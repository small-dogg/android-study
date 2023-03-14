package com.smalldogg.study.android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.app1_activity.*

class App1Activity : AppCompatActivity() {
    val TEST_ACTIVITY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app1_activity)

        button92.setOnClickListener {
            val test_intent = Intent("com.smalldogg.study.android.test_activity")

            test_intent.putExtra("data1", 100)
            test_intent.putExtra("data2", "문자열1")

//            startActivity(test_intent)
            startActivityForResult(test_intent, TEST_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == TEST_ACTIVITY) {
            if (resultCode == RESULT_OK) {
                val value1 = data?.getIntExtra("value1", 200)
                val value2 = data?.getStringExtra("value2")
                textView47.text = "value1 : ${value1}\n"
                textView47.append("value2 : ${value2}")

            }
        }
    }

}