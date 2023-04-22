package com.smalldogg.study.android

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.app_bar_activity.*

class AppBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_bar_activity)

        setSupportActionBar(toolbar)

        toolbar_layout.setCollapsedTitleTextColor(Color.WHITE)
        toolbar_layout.setExpandedTitleColor(Color.GREEN)

        toolbar_layout.collapsedTitleGravity = Gravity.CENTER_HORIZONTAL
        toolbar_layout.expandedTitleGravity = Gravity.RIGHT + Gravity.TOP

        imageView45.setImageResource(R.drawable.img_android)

        supportActionBar?.title = "타이틀 입니다"
    }

}