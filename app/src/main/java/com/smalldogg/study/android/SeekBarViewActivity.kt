package com.smalldogg.study.android

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.seek_bar_view_activity.*

class SeekBarViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.seek_bar_view_activity)

        button59.setOnClickListener {
            textView14.text = "SeekBar 1 : ${seekBar.progress}"
            textView15.text = "SeekBar 1 : ${seekBar2.progress}"
        }
        button60.setOnClickListener {
            seekBar.progress = 3
            seekBar2.progress = 8
        }

        button61.setOnClickListener {
            seekBar.incrementProgressBy(1)
            seekBar2.incrementProgressBy(1)
        }
        button62.setOnClickListener {
            seekBar.incrementProgressBy(-1)
            seekBar2.incrementProgressBy(-1)
        }

        seekBar.setOnSeekBarChangeListener(listener1)
        seekBar2.setOnSeekBarChangeListener(listener1)
    }

    val listener1 = object : SeekBar.OnSeekBarChangeListener {
        //Progressbar의 값 변경중
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            when (seekBar?.id) {

                R.id.seekBar -> { textView14.text = "첫번째 프로그래스바가 ${progress}로 설정됨\n" }
                R.id.seekBar2 -> { textView14.text = "첫번째 프로그래스바가 ${progress}로 설정됨\n" }
            }

            if (fromUser) {
                textView14.append("사용자에 의해 설정")
            } else {
                textView14.append("코드에 의해 설정")
            }
        }

        //터치중일 때
        override fun onStartTrackingTouch(seekBar: SeekBar?) {
            when (seekBar?.id) {
                R.id.seekBar -> textView15.text="첫번째 SeekBar 사용자 터치 시작"
                R.id.seekBar2 -> textView15.text="두번째 SeekBar 사용자 터치 시작"
            }
        }

        //터치 끝났을 때
        override fun onStopTrackingTouch(seekBar: SeekBar?) {
            when (seekBar?.id) {
                R.id.seekBar -> textView15.text="첫번째 SeekBar 사용자 터치 종료"
                R.id.seekBar2 -> textView15.text="두번째 SeekBar 사용자 터치 종료"
            }
        }

    }
}