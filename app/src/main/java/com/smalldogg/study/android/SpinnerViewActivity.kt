package com.smalldogg.study.android

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.spinner_view_activity.*

class SpinnerViewActivity : AppCompatActivity() {

    val data1 = arrayOf("항목1", "항목2", "항목3", "항목4", "항목5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.spinner_view_activity)

        //어댑터를 생성한다. 접혔을 때의 모습을 구성할 Layout을 설정한다.
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data1)

        //펼쳐졌을 때의 모습을 구성하기 위한 Layout을 지정한다.
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter1

        button68.setOnClickListener {
            textView24.text = "선택한 항목 : ${data1[spinner.selectedItemPosition]}"
        }

        spinner.onItemSelectedListener = listener1
    }

    val listener1 = object : OnItemSelectedListener {
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            when (p0?.id) {
                R.id.spinner ->{
                    textView24.text = "${data1[p2]} 번째 항목이 선택되었습니다."
                }
            }
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {
        }

    }

}