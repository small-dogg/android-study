package com.smalldogg.study.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivityControllerActivity : AppCompatActivity() {
    val inputFragment = InputFragment()
    val resultFragment = ResultFragment()

    var value1 = ""
    var value2 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_controller_activity)

        setFragment("input")
    }

    fun setFragment(name: String) {
        val tran = supportFragmentManager.beginTransaction()

        when(name){
            "input"-> {
                tran.replace(R.id.container4,inputFragment)
            }
            "result" -> {
                tran.replace(R.id.container4,resultFragment)
                tran.addToBackStack(null)
            }
        }

        tran.commit()
    }

}