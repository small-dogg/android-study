package com.smalldogg.study.android

import android.os.Bundle
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.switch_view_activity.*

class SwitchViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.switch_view_activity)

        button50.setOnClickListener {
            if (switch1.isChecked) {
                textView7.text = "ON 상태입니다."
            } else {
                textView7.text = "OFF 상태입니다."
            }
        }

        button52.setOnClickListener {
            switch1.isChecked = true
        }

        button53.setOnClickListener {
            switch1.isChecked = false
        }

        switch1.setOnCheckedChangeListener(listener1)

        switch2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                textView8.text = "두번째 스위치가 ON 상태가 되었습니다."
            } else {
                textView8.text = "두번째 스위치가 OFF 상태가 되었습니다."
            }
        }
    }

    val listener1 = object : OnCheckedChangeListener {
        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            when (buttonView?.id) {
                R.id.switch1 -> {
                    if (isChecked) {
                        textView8.text = "첫번째 스위치가 ON 상태가 되었습니다."
                    } else {
                        textView8.text = "첫번째 스위치가 OFF 상태가 되었습니다."
                    }
                }
            }
        }
    }
}