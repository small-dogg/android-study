package com.smalldogg.study.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import kotlinx.android.synthetic.main.checkbox_view_activity.*

class CheckboxViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checkbox_view_activity)

        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                textView.text = "체크됐다~"
            } else {
                textView.text = "안됐다~~"
            }
        }

        button44.setOnClickListener {
            checkBox.isChecked = false
            checkBox2.isChecked = false
            checkBox3.isChecked = false
        }

        button48.setOnClickListener {
            checkBox.isChecked = true
            checkBox2.isChecked = true
            checkBox3.isChecked = true
        }

        button49.setOnClickListener {
            checkBox.toggle()
            checkBox2.toggle()
            checkBox3.toggle()
        }

        checkBox3.setOnCheckedChangeListener(listener1)
        checkBox2.setOnCheckedChangeListener(listener1)

    }

    val listener1 = object : OnCheckedChangeListener{
        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            when (buttonView?.id) {
                R.id.checkBox2 -> {
                    if (isChecked) {
                        textView5.text = "두번째 체크박스가 체크되었습니다."
                    } else {
                        textView5.text = "두번째 체크박스가 체크해제되었습니다."
                    }
                }
                R.id.checkBox3 -> {
                    if (isChecked) {
                        textView6.text = "세번째 체크박스가 체크되었습니다."
                    } else {
                        textView6.text = "세번째 체크박스가 체크해제되었습니다."
                    }
                }
            }
        }
    }



}