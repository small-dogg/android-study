package com.smalldogg.study.android

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.list_view_activity.*

class ListViewActivity : AppCompatActivity() {

    val data1 = arrayOf(
        "문자열1", "문자열2", "문자열3", "문자열4", "문자열5", "문자열6", "문자열7", "문자열8", "문자열9", "문자열10",
        "문자열11", "문자열12", "문자열13", "문자열14", "문자열15", "문자열16", "문자열17", "문자열18", "문자열19", "문자열20",
        "문자열21", "문자열22", "문자열23", "문자열24", "문자열25"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view_activity)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)
        list1.adapter = adapter1

        list1.setOnItemClickListener(listener1)
    }

    val listener1 = object : OnItemClickListener {
        //p0 : 이벤트가 발생한 항목을 가지고 있는 AdapterView
        //p1 : 이벤트가 발생한 항목 View
        //p2 : 이벤트가 발생한 항목의 index
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            when (parent?.id) {
                R.id.list1 -> textView22.text = "${data1[position]} 번째의 항목을 클릭했습니다."
            }
        }

    }

}