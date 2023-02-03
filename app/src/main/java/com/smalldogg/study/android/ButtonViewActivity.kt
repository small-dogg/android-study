package com.smalldogg.study.android

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.button_view_activity.*

class ButtonViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.button_view_activity)

        button_test_1.setOnClickListener(listener1)
        button_test_2.setOnClickListener(listener1)
        button_test_3.setOnClickListener(listener1)
    }

    //버튼을 클릭하면 동작하는 리스너 객체
    val listener1 = object : View.OnClickListener{
        @SuppressLint("SetTextI18n")
        override fun onClick(v: View?) {
            when(v?.id){
                R.id.button_test_1 -> {
                    text1.text = "${button_test_1.text} 버튼을 눌렀습니다."
                }
                R.id.button_test_2 ->{
                    text1.text = "${button_test_2.text} 버튼을 눌렀습니다."
                }
                R.id.button_test_3 ->{
                    text1.text = "${button_test_3.text} 버튼을 눌렀습니다."
                }
            }

        }
    }

}