package com.smalldogg.study.android

import android.os.Bundle
import android.view.View
import android.view.View.OnScrollChangeListener
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.scroll_view_activity.*

class ScrollViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scroll_view_activity)

        button65.setOnClickListener {
            textView20.text = "Y : ${scroll1.scrollY}"
            textView21.text = "X : ${scroll2.scrollX}"
        }

        button66.setOnClickListener {
//            지정된 위치로 애니메이션 없이 이동
//            scroll1.scrollTo(0,500)
//            scroll2.scrollTo(500,0)
            //지정된 위치로 애니메이션과 함께 이동
//            scroll1.smoothScrollTo(0,500)
//            scroll2.smoothScrollTo(500,0)

            //현재 윛에서 지정된 만큼 애니메이션과 함께 이동
            scroll1.smoothScrollBy(0, 10)
            scroll2.smoothScrollBy(10, 0)
        }
        scroll1.setOnScrollChangeListener(listener1)
        scroll2.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            textView21.text = "X : $oldScrollX -> $scrollX"

        }
    }

    val listener1 = object : OnScrollChangeListener {
        override fun onScrollChange(
            v: View?,
            scrollX: Int,
            scrollY: Int,
            oldScrollX: Int,
            oldScrollY: Int
        ) {
            when (v?.id) {
                R.id.scroll1 -> textView20.text = "Y : ${oldScrollY} -> ${scrollY}"
            }
        }

    }
}