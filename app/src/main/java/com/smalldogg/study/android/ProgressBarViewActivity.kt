package com.smalldogg.study.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.progress_bar_view_activity.*

class ProgressBarViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.progress_bar_view_activity)

        button55.setOnClickListener {
            textView13.text = "현재 값 : ${progressBar6.progress}"
        }

        button56.setOnClickListener {
            progressBar6.progress = 160
        }

        button57.setOnClickListener {
            progressBar6.incrementProgressBy(10)
        }

        button58.setOnClickListener {
            progressBar6.incrementProgressBy(-10)
        }
    }
}