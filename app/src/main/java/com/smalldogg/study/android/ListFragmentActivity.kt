package com.smalldogg.study.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ListFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_activity)

        val subFragment = SubFragment3()
        val tran = supportFragmentManager.beginTransaction()
        tran.replace(R.id.container5,subFragment)
        tran.commit()
    }

}