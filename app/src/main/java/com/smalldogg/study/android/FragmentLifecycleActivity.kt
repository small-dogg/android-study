package com.smalldogg.study.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_lifecycle_activity.*

class FragmentLifecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_lifecycle_activity)

        val frag = SubFragment()

        button127.setOnClickListener {
            val tran = supportFragmentManager.beginTransaction()
            tran.replace(R.id.container2, frag)
            tran.addToBackStack("aaa")
            tran.commit()
        }

        button128.setOnClickListener {
            val tran = supportFragmentManager.beginTransaction()
            tran.remove(frag)
            tran.commit()
        }
    }

}