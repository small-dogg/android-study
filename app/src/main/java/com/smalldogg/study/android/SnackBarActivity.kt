package com.smalldogg.study.android

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.SnackbarLayout
import kotlinx.android.synthetic.main.custom_snackbar.view.*
import kotlinx.android.synthetic.main.snack_bar_activity.*

class SnackBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.snack_bar_activity)

        button98.setOnClickListener {
//            val snack1 = Snackbar.make(it, "기본 스낵바", Snackbar.LENGTH_SHORT)
            val snack1 = Snackbar.make(it, "기본 스낵바", Snackbar.LENGTH_INDEFINITE)

            snack1.setTextColor(Color.RED)
            snack1.setBackgroundTint(Color.BLUE)
            snack1.animationMode=Snackbar.ANIMATION_MODE_FADE

            val callback = object:BaseCallback<Snackbar>(){
                override fun onShown(transientBottomBar: Snackbar?) {
                    super.onShown(transientBottomBar)
                    textView50.text ="SnackBar가 나타났습니다."
                }

                override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                    super.onDismissed(transientBottomBar, event)
                    textView50.text ="SnackBar가 사라졌습니다."
                }
            }

            snack1.addCallback(callback)

            snack1.setAction("Action"){
                textView49.text = "Action Click"
            }

            snack1.show()
        }

        button99.setOnClickListener {
            //스낵바 객체 생성
            val snack2 = Snackbar.make(it, "Custom SnackBar", Snackbar.LENGTH_SHORT)

            //스낵바를 통해 보여줄 뷰를 생성
            val snackView = layoutInflater.inflate(R.layout.custom_snackbar, null)

            snackView.run {
                imageView37.setImageResource(R.drawable.img_android)
                textView51.text = "새로 추가된 View"
                textView51.setTextColor(Color.WHITE)
            }

            //스낵바 레이아웃을 추출하여 새로운 뷰를 추가
            val snackbarLayout = snack2.view as SnackbarLayout
            snackbarLayout.addView(snackView)

            //스낵바에 있는 TextView를 추출하여 이를 보이지 않게 처리
            val snackText = snackbarLayout.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            snackText.visibility = View.INVISIBLE

            snack2.show()
        }
    }

}