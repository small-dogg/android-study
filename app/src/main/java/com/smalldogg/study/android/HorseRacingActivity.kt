package com.smalldogg.study.android

import android.annotation.SuppressLint
import android.graphics.drawable.*
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.horse_racing_activity.*
import kotlinx.android.synthetic.main.include_other_layout_activity.view.*
import java.lang.Integer.min
import java.util.*
import kotlin.concurrent.timer

class HorseRacingActivity : AppCompatActivity() {

    var horseList = ArrayList<SeekBar>();
    var statusList = ArrayList<Int>();

    var timer: Timer? = null
    var minValue = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.horse_racing_activity)
        textView43.text = ""

        play.setOnClickListener { TimeFun() }

        horseAdd.setOnClickListener {
            val lLayout = findViewById<LinearLayout>(R.id.horseList)
            var horse = setupSeekBar()
            lLayout?.addView(horse)
            horseList.add(horse)
            statusList.add(0)
        }

        horseDelete.setOnClickListener {
            val lLayout = findViewById<LinearLayout>(R.id.horseList)
            val lastHorse = horseList.last()
            lLayout?.removeView(lastHorse)
            horseList.remove(lastHorse)
            statusList.remove(statusList.last())
        }
    }

    fun TimeFun() {
        timer = timer(period = 100, initialDelay = 0) {
            if (minValue > 100) cancel()
            for (i in 0..horseList.lastIndex) {
                val nextInt = Random().nextInt(2)
                var currentValue = statusList.get(i)
                currentValue += nextInt
                minValue = min(currentValue, minValue)
                statusList.set(i, currentValue)
                horseList.get(i).progress += nextInt
            }

        }
    }

    @SuppressLint("ResourceType")
    private fun setupSeekBar(): SeekBar {
        val seekBar = SeekBar(this)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )


        layoutParams.setMargins(30, 30, 30, 30)
        seekBar.layoutParams = layoutParams

        seekBar.progressDrawable = resources.getDrawable(R.drawable.horse_seekbar)

        var thumb = ImageView(this)
        Glide.with(this)
            .asGif()
            .load(R.drawable.run_horse)
            .into(thumb)


        seekBar.thumb = thumb.drawable

        return seekBar
    }
}