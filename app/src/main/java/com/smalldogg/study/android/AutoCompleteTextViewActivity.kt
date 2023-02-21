package com.smalldogg.study.android

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.auto_complete_text_view_activity.*

class AutoCompleteTextViewActivity : AppCompatActivity() {

    val data1 = arrayOf("abcd", "abca", "abcb", "abcc", "bbaa", "bbab", "bcab", "bdab")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auto_complete_text_view_activity)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, data1)

        autoCompleteTextView.setAdapter(adapter1)

        button75.setOnClickListener {
            textView27.text = autoCompleteTextView.text
        }

        autoCompleteTextView.setOnItemClickListener(listener1)
    }

    val listener1 = object : AdapterView.OnItemClickListener {
        override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            textView28.text = "${data1[p2]} 항목 클릭!"

        }

    }

}