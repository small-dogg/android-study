package com.smalldogg.study.android

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.checkbox_view_activity.*
import kotlinx.android.synthetic.main.multi_auto_complete_text_view_activity.*

//구분자를 활룡해서 여러 문자열을 동시에 입력 받을 수 있음
class MultiAutoCompleteTextViewActivity : AppCompatActivity() {

    val data1 = arrayOf("abcd", "abca", "abcb", "abcc", "bbaa", "bbab", "bcab", "bdab")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.multi_auto_complete_text_view_activity)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, data1)

        //구분자
        multiAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        multiAutoCompleteTextView.setAdapter(adapter1)

        button77.setOnClickListener {
//            textView29.text = multiAutoCompleteTextView.text

            val strArray = multiAutoCompleteTextView.text.split(",")

            textView29.text = ""

            for (s in strArray) {
                if (s.trim() != "") {
                    textView29.append("${s.trim()}\n")
                }

            }
        }

        multiAutoCompleteTextView.setOnItemClickListener { adapterView, view, i, l ->
            textView30.text = "${data1[i]} 항목을 선택하였습니다."
        }
    }

}