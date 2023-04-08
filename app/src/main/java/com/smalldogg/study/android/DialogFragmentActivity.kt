package com.smalldogg.study.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.dialog_fragment_activity.*

class DialogFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_fragment_activity)

        button129.setOnClickListener {
            val subFragment = SubFragment5()
            subFragment.show(supportFragmentManager, "tag")
        }
    }

}