package com.smalldogg.study.android

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.edit_text_view_activity.*

class EditTextViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_text_view_activity)

        getString.setOnClickListener {
            textView2.text = editText1.text

            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(editText1.windowToken, 0)

            editText1.clearFocus()
        }

        editText1.addTextChangedListener(listener1)

        editText1.setOnEditorActionListener { v, actionId, event ->
            textView2.text = "엔터 버튼을 눌렀습니다."
            textView3.text = editText1.text
            false
        }
    }

    val listener1 = object : TextWatcher {
        //문자열 변경 전
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            textView2.text = "before : ${s}"
        }

        //문자열 변경 작업이 완료되었을 때
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            textView3.text = "changed : ${s}"
        }

        //변경된 문자열 화면에 반영도이ㅓㅆ을 때
        override fun afterTextChanged(s: Editable?) {
            textView4.text = "after : ${s}"
        }
    }

}