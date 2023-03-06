package com.smalldogg.study.android

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.horse_racing_activity.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.timer

class HorseRacingActivity : AppCompatActivity() {

    var horseList = ArrayList<View>();

    var timer : Timer? = null
    var deltaTime = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.horse_racing_activity)
        textView43.text=""

        play.setOnClickListener { TimeFun() }

        horseAdd.setOnClickListener {
            var horse =

            horseList.add()
        }

        horseDelete.setOnClickListener {

        }
    }

    fun TimeFun() {
        timer = timer(period = 100, initialDelay = 0){
            val nextInt = Random().nextInt(2)
            if(deltaTime > 100) cancel()
            deltaTime += nextInt
            horse1.setProgress(deltaTime)
        }
    }

    private fun setupSeekBar() {
        val seekBar = SeekBar(this)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(30, 30, 30, 30)
        seekBar.layoutParams = layoutParams

        // Add SeekBar to LinearLayout
        binding.rootContainer.addView(seekBar)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Write code to perform some action when progress is changed.
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is started.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is stopped.
                Toast.makeText(
                    this@MainActivity,
                    "Progress is " + seekBar.progress + "%",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }


}