package com.smalldogg.study.android

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckedTextView
import kotlinx.android.synthetic.main.button_view_activity.*
import kotlinx.android.synthetic.main.checked_text_view_activity.*

class CheckedTextViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checked_text_view_activity)

        button51.setOnClickListener {
            textView11.text = ""
            if (checkedTextView.isChecked) {
                textView11.append("첫번째 체크 박스가 체크되어 있습니다.\n")
            } else {
                textView11.append("첫번째 체크 박스가 체크되어 있지 않습니다.\n")
            }

            if (checkedTextView2.isChecked) {
                textView11.append("두번째 체크 박스가 체크되어 있습니다.\n")
            } else {
                textView11.append("두번째 체크 박스가 체크되어 있지 않습니다.\n")
            }

            if (checkedTextView3.isChecked) {
                textView11.append("세번째 체크 박스가 체크되어 있습니다.\n")
            } else {
                textView11.append("세번째 체크 박스가 체크되어 있지 않습니다.\n")
            }

            if (checkedTextView4.isChecked) {
                textView11.append("첫번째 라디오 버튼이 선택되어 있습니다\n")
            } else if (checkedTextView5.isChecked) {
                textView11.append("두번째 라디오 버튼이 선택되어 있습니다\n")
            } else if (checkedTextView6.isChecked) {
                textView11.append("세번쨰 라디오 버튼이 선택되어 있습니다\n")
            }
        }

        button54.setOnClickListener {
            checkedTextView.isChecked = false
            checkedTextView2.isChecked = true
            checkedTextView3.isChecked = false
            checkedTextView4.isChecked = false
            checkedTextView5.isChecked = false
            checkedTextView6.isChecked = true
        }

        checkedTextView.setOnClickListener(listener1)
        checkedTextView2.setOnClickListener(listener1)
        checkedTextView3.setOnClickListener(listener1)

        checkedTextView4.setOnClickListener(listener2)
        checkedTextView5.setOnClickListener(listener2)
        checkedTextView6.setOnClickListener(listener2)
    }

    val listener1 = object : View.OnClickListener {
        override fun onClick(v: View?) {
            //형변환
            val obj = v as CheckedTextView

            obj.isChecked = !obj.isChecked
        }
    }

    val listener2 = object : View.OnClickListener {
        override fun onClick(v: View?) {
            checkedTextView4.isChecked = false
            checkedTextView5.isChecked = false
            checkedTextView6.isChecked = false

            val obj = v as CheckedTextView
            obj.isChecked = true
        }
    }

}