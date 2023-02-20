package com.smalldogg.study.android

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.custom_list_view1_activity.*

class CustomListView1Activity : AppCompatActivity() {

    val data1 = arrayOf("문자열1", "문자열2", "문자열3", "문자열4", "문자열5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_list_view1_activity)

        val adapter1 = ArrayAdapter(this, R.layout.row, R.id.rowTextView, data1)
        list2.adapter = adapter1

        list2.setOnItemClickListener { adapterView, view, i, l ->
            textView22.text = "${data1[i]}를 터치하였습니다."
        }
    }
}