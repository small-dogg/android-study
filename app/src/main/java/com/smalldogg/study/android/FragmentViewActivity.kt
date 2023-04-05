package com.smalldogg.study.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FragmentViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_view_activity)

        val frag = SubFragment2()
        val tran = supportFragmentManager.beginTransaction()
        tran.replace(R.id.container3, frag)
        tran.commit()
    }

}