package com.smalldogg.study.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_activity.*

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_activity)

        val frag1 = FirstFragment()
        val frag2 = SecondFragment()

        button125.setOnClickListener {
            // Fragment 작업 시작
            val tran = supportFragmentManager.beginTransaction()
            //Fragment를 셋팅한다.
            tran.replace(R.id.container1,frag1)
            tran.addToBackStack("frag1")
            tran.commit()
        }

        button126.setOnClickListener {
            val tran = supportFragmentManager.beginTransaction()
            tran.replace(R.id.container1,frag2)
            tran.addToBackStack("frag2")
            tran.commit()
        }
    }

}