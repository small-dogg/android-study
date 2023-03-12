package com.smalldogg.study.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_data_second.*

class DataSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_second)

        // 현재 액티비티를 실행하기 위해 사용한 인텐트로 부터 데이터를 추출한다.
        val data1 = intent.getIntExtra("data1",0)
        val data2 = intent.getDoubleExtra("data2",0.0)
        val data3 = intent.getBooleanExtra("data3",false)
        val data4 = intent.getStringExtra("data4")

        textView45.text = "data1 : ${data1}\n"
        textView45.append("data2 : ${data2}\n")
        textView45.append("data3 : ${data3}\n")
        textView45.append("data4 : ${data4}\n")

        button90.setOnClickListener {

            val result_intent = Intent()

            result_intent.putExtra("value1", 200)
            result_intent.putExtra("value2", 22.22)
            result_intent.putExtra("value3", false)
            result_intent.putExtra("value4", "문자열2")

            setResult(RESULT_OK, result_intent)

            finish()
        }
    }
}