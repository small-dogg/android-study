package com.smalldogg.study.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class SecondActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second4)

        //HomeButton 메뉴를 활성화 한다
        supportActionBar?.setHomeButtonEnabled(true)
        //노출한다
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //HomeButton의 아이콘 설정
//        supportActionBar?.setHomeAsUpIndicator(R.mipmap.ic_launcher)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}