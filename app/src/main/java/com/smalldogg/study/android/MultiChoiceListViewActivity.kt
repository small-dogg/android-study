package com.smalldogg.study.android

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.multi_choice_list_view_activity.*

class MultiChoiceListViewActivity : AppCompatActivity() {

    val data1 = arrayOf("데이터1", "데이터2", "데이터3", "데이터4", "데이터5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.multi_choice_list_view_activity)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, data1)

        multiChoiceListView.adapter = adapter1
        multiChoiceListView.choiceMode = ListView.CHOICE_MODE_MULTIPLE
        multiChoiceListView.setItemChecked(0, true)
        multiChoiceListView.setItemChecked(2, true)
        multiChoiceListView.setItemChecked(4, true)

        multiChoiceListView.setOnItemClickListener { adapterView, view, i, l ->
            textView32.text = "${data1[i]} 선택"
        }

        button76.setOnClickListener {
            textView33.text = ""

            //현재 체크 상태에 관련된 객체를 가져온다.

            val boolArray = multiChoiceListView.checkedItemPositions

//            textView33.text = "개수 : ${boolArray.size()}"

            for (i in 0 until boolArray.size()) {
//                textView33.append("${boolArray.keyAt(i)}, ")
                val key = boolArray.keyAt(i)
                if (boolArray[key]) {
                    textView33.append("${data1[key]}, ")
                }
            }
        }
    }

}