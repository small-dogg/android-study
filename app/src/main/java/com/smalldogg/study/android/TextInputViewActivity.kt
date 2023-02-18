package com.smalldogg.study.android

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.text_input_view_activity.*

class TextInputViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.text_input_view_activity)

        textInputButton01.setOnClickListener {
            textInputTextView.text = textInputLayout1.editText?.text

            textInputLayout1.editText?.clearFocus()

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(textInputLayout1.editText?.windowToken, 0)
        }

        textInputLayout1.editText?.addTextChangedListener(listener1)
    }

    val listener1 = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            if (s != null) {
                if (s.length > 20) {
                    textInputLayout1.error = "20글자 이하로 입력해주세요."
                } else {
                    textInputLayout1.error = null
                }
            }
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
    }

}