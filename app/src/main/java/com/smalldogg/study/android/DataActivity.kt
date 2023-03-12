package com.smalldogg.study.android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.data_activity.*

class DataActivity : AppCompatActivity() {

    val SECOND_ACTIVITY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.data_activity)

        button89.setOnClickListener {
            val second_intent = Intent(this,DataSecondActivity::class.java)

            second_intent.putExtra("data1", 100)
            second_intent.putExtra("data2", 11.11)
            second_intent.putExtra("data3", true)
            second_intent.putExtra("data4", "문자열")


            startActivityForResult(second_intent, SECOND_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SECOND_ACTIVITY) {
            if (resultCode == RESULT_OK) {
                val value1 = data?.getIntExtra("value1", 0)
                val value2 = data?.getDoubleExtra("value2", 0.0)
                val value3 = data?.getBooleanExtra("value1", false)
                val value4 = data?.getStringExtra("value1")

                textView44.text = "value1 : ${value1}\n"
                textView44.append("value2 : ${value2}\n")
                textView44.append("value3 : ${value3}\n")
                textView44.append("value4 : ${value4}\n")
            }
        }
    }
}