package com.smalldogg.study.android

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.button_view_activity.*
import kotlinx.android.synthetic.main.edit_text_view_activity.*
import kotlinx.android.synthetic.main.text_input_view_activity.*

class TextInputViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_text_view_activity)

        button40.setOnClickListener {
            textView.text = textInputLayout1.editText?.text

            textInputLayout1.editText?.clearFocus()

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(textInputLayout1.editText?.windowToken, 0)
        }
    }

}