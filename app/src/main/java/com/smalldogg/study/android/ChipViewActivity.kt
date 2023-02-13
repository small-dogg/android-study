package com.smalldogg.study.android

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.button_view_activity.*
import kotlinx.android.synthetic.main.chip_view_activity.*

class ChipViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chip_view_activity)

        chip1.setOnClickListener {
            textView12.text = "첫 번째 Chip을 클릭하였습니다.\n"
            if (chip2.isChecked) {
                textView12.append("두 번째 Chip이 선택되었습니다.\n")
            } else {
                textView12.append("두 번째 Chip이 선택되어있지 않습니다.\n")
            }
        }


    }
}