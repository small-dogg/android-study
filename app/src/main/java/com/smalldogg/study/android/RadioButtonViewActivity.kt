package com.smalldogg.study.android

import android.os.Bundle
import android.widget.RadioGroup
import android.widget.RadioGroup.OnCheckedChangeListener
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.radio_button_view_activity.*

class RadioButtonViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.radio_button_view_activity)

        register.setOnClickListener {
            male.isChecked = true
            agree.isChecked = true
        }

        checkStatus.setOnClickListener {
//            when (sexGroup.checkedRadioButtonId) {
//                R.id.male -> textView9.text = "남성이 선택되었습니다."
//                R.id.female -> textView9.text = "여성이 선택되었습니다."
//            }

            when (smsAgreementGroup.checkedRadioButtonId) {
                R.id.agree -> textView10.text = "SMS 수신을 동의하였습니다."
                R.id.degree -> textView10.text = "SMS 수신을 미동의하였습니다."
            }
        }

        sexGroup.setOnCheckedChangeListener(radioButtonCheckedlistener)
    }

    val radioButtonCheckedlistener = object : OnCheckedChangeListener {
        override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
            when (group?.id) {
                R.id.sexGroup -> {
                    when (checkedId) {
                        R.id.male -> textView9.text = "남성이 선택되었습니다."
                        R.id.female -> textView9.text = "여성이 선택되었습니다."
                    }
                }
            }
        }
    }
}