package com.smalldogg.study.android

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.button_view_activity.*
import kotlinx.android.synthetic.main.edit_text_view_activity.*
import kotlinx.android.synthetic.main.image_view_activity.*

class ImageViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.image_view_activity)

        imageView4.setImageResource(R.drawable.img_android2)
    }

}