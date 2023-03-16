package com.smalldogg.study.android

import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.custom_toast.view.*
import kotlinx.android.synthetic.main.toast_activity.*

class ToastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.toast_activity)

        button94.setOnClickListener {
            val t1 = Toast.makeText(this, "기본 Toast 입니다.", Toast.LENGTH_SHORT)

            //callback 객체 생성
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                val callback = object : Toast.Callback() {
                    override fun onToastHidden() {
                        super.onToastHidden()
                        textView47.text = "Toast 메시지가 사라졌습니다."
                    }

                    override fun onToastShown() {
                        super.onToastShown()
                        textView47.text = "Toast 메시지가 나타났습니다."
                    }
                }

                t1.addCallback(callback)
            }
            t1.show()
        }

        button95.setOnClickListener {
            //Toast에 보여줄 View를 생성한다.
            val toastView = layoutInflater.inflate(R.layout.custom_toast, null)

            toastView.run {
                toast_image.setImageResource(R.drawable.img_android)
                toast_text.text = "Custom Toast 입니다"
            }

            toastView.setBackgroundResource(android.R.drawable.toast_frame)

            //Toast 객체 생성
            val t2 = Toast(this)
            //Toast View 적용
            t2.view = toastView

            t2.setGravity(Gravity.CENTER, 0, 0)

            t2.duration = Toast.LENGTH_LONG

            t2.show()
        }
    }

}