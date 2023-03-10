package com.smalldogg.study.android

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.*
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.size
import kotlinx.android.synthetic.main.horse_racing_activity.*
import kotlinx.android.synthetic.main.include_other_layout_activity.view.*
import java.lang.Integer.min
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.timer

class HorseRacingActivity : AppCompatActivity() {

    var horseList = ArrayList<SeekBar>();
    var statusList = ArrayList<Int>();

    var timer : Timer? = null
    var minValue = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.horse_racing_activity)
        textView43.text=""

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
        timer = timer(period = 100, initialDelay = 0){
            if(minValue > 100) cancel()
            for (i in 0..horseList.lastIndex) {
                val nextInt = Random().nextInt(2)
                var currentValue = statusList.get(i)
                currentValue += nextInt
                minValue = min(currentValue,minValue)
                statusList.set(i,currentValue)
                horseList.get(i).progress += nextInt
            }

        }
    }

    @SuppressLint("ResourceType")
    private fun setupSeekBar():SeekBar {
        val seekBar = SeekBar(this)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )


        layoutParams.setMargins(30, 30, 30, 30)
        seekBar.layoutParams = layoutParams

        seekBar.progressDrawable=resources.getDrawable(R.drawable.horse_seekbar)

        seekBar.thumb = Drawable.createFromXml(resources,resources.getXml(R.drawable.horse_thumb))
        return seekBar
    }

    private fun createDrawable(context: Context): Drawable {

        //background drawable
        val gradientDrawable = GradientDrawable(
            GradientDrawable.Orientation.LEFT_RIGHT,
            intArrayOf(Color.parseColor("#E91E63"), Color.parseColor("#FFD5E4"))
        ) //왼쪽에서 오른쪽으로 그라데이션 되는 drawable

        gradientDrawable.gradientType = GradientDrawable.LINEAR_GRADIENT //그라데이션 종류 (직선 그라데이션)
        gradientDrawable.setStroke(8, Color.parseColor("#00ffffff")) //stroke
        gradientDrawable.cornerRadius = 12f //drawable radius
        gradientDrawable.shape = GradientDrawable.RECTANGLE //drawable shape

        //progress drawable
        val clipDrawable = ClipDrawable(
            gradientDrawable, Gravity.LEFT,
            ClipDrawable.HORIZONTAL
        )

        val layerDrawable = LayerDrawable(arrayOf(gradientDrawable,clipDrawable))
        layerDrawable.setId(0, android.R.id.background) //background drawable
        layerDrawable.setId(1, android.R.id.progress) //progress drawable

        return layerDrawable
    }


}