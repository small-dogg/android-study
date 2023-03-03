package com.smalldogg.study.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        button84.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }

        button86.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }

        button87.setOnClickListener {
            setResult(RESULT_FIRST_USER)
            finish()
        }

        button88.setOnClickListener {
            setResult(RESULT_FIRST_USER + 1)
            finish()
        }
    }
}