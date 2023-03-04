package com.smalldogg.study.android

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.horse_racing_activity.*
import java.util.*

class HorseRacingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.horse_racing_activity)
        textView43.text=""
        play.setOnClickListener(listener1)

    }

    val listener1 = object : View.OnClickListener {
        override fun onClick(v: View?) {
            while (horse1.progress != 100) {
                Thread.sleep(100)
                val run = Random().nextInt(2)
                textView43.append("$run")
                horse1.incrementProgressBy(run)
            }
        }

    }

}