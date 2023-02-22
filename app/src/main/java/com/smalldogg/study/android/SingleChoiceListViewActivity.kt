package com.smalldogg.study.android

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.single_choice_list_view_activity.*

class SingleChoiceListViewActivity : AppCompatActivity() {

    val data1 = arrayOf("데이터1","데이터2","데이터3","데이터4","데이터5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.single_choice_list_view_activity)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, data1)

        singleChoiceListView.adapter = adapter1
        singleChoiceListView.choiceMode = ListView.CHOICE_MODE_SINGLE
        singleChoiceListView.setItemChecked(2, true)

        singleChoiceListView.setOnItemClickListener { adapterView, view, i, l -> textView31.text = "${data1[i]} 선택" }
    }

}