package com.smalldogg.study.android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.object_activity.*

class ObjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_activity)

        button91.setOnClickListener {
            val second_intent = Intent(this, ObjectSecondActivity::class.java)

            val t1 = TestClass()
            t1.data1 = 100
            t1.data2 = "문자열1"

            second_intent.putExtra("obj",t1)

            startActivity(second_intent)
        }
    }

}