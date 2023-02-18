package com.smalldogg.study.android

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.toggle_button_view_activity.*

class ToggleButtonViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.toggle_button_view_activity)

        button40.setOnClickListener {
            if (toggleButton.isChecked) {
                toggleTextView.text = "ON 상태입니다."
            } else {
                toggleTextView.text = "OFF 상태입니다."
            }
        }

        button41.setOnClickListener {
            toggleButton.isChecked = true
        }

        button42.setOnClickListener {
            toggleButton.isChecked = false
        }

        button43.setOnClickListener {
            toggleButton.toggle()
        }

        toggleButton.setOnClickListener(listener)

        toggleButton2.setOnClickListener {
            if (toggleButton2.isChecked) {
                toggleTextView2.text = "ON 상태로 설정되었습니다."
            } else {
                toggleTextView2.text = "OFF 상태로 설정되었습니다."
            }
        }
    }

    val listener = object : View.OnClickListener {
        override fun onClick(v: View?) {
            if (toggleButton.isChecked) {
                toggleTextView.text = "ON 상태로 설정되었습니다."
            } else {
                toggleTextView.text = "OFF 상태로 설정되었습니다."
            }
        }
    }

}