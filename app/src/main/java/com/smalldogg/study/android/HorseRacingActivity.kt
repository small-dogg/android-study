package com.smalldogg.study.android

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.horse_racing_activity.*
import java.util.*
import kotlin.concurrent.timer

class HorseRacingActivity : AppCompatActivity() {


    var timer : Timer? = null
    var deltaTime = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.horse_racing_activity)
        textView43.text=""

        play.setOnClickListener { TimeFun() }

    }

    fun TimeFun() {
        timer = timer(period = 100, initialDelay = 0){
            val nextInt = Random().nextInt(2)
            if(deltaTime > 100) cancel()
            deltaTime += nextInt
            horse1.setProgress(deltaTime)
        }
    }

}