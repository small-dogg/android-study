package com.smalldogg.study.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_object_second.*

class ObjectSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_second)

        val obj1 = intent.getParcelableExtra<TestClass>("obj1")

        button93.setOnClickListener {
            finish()
        }
    }
}