package com.smalldogg.study.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

            if (chip.isChecked) {
                textView12.append("세 번쨰 Chip이 선택되었습니다.\n")
            } else {
                textView12.append("세 번쨰 Chip이 선택되어있지 않습니다.\n")
            }

            if (chip3.isChecked) {
                textView12.append("네 번째 Chip이 선택되었습니다.\n")
            } else {
                textView12.append("네 번쨰 Chip이 선택되어있지 않습니다.\n")
            }

            when (chipGroup1.checkedChipId) {
                R.id.chip4 -> textView12.append("그룹내의 첫 번쨰 Chip이 선택되어있습니다.\n")
                R.id.chip5 -> textView12.append("그룹내의 두 번쨰 Chip이 선택되어있습니다.\n")
                R.id.chip6 -> textView12.append("그룹내의 세 번쨰 Chip이 선택되어있습니다.\n")
            }
        }

//        chip.setOnClickListener {
//            textView12.text="세번째 Chip을 클릭했습니다.\n"
//        }
        chip.setOnCloseIconClickListener {
            textView12.text = "닫기 버튼을 눌렀습니다."
        }

        chip3.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                textView12.text = "네번째 Chip이 체크되었습니다."
            } else {
                textView12.text = "네번째 Chip이 체크 해제되었습니다."
            }
        }
    }

}