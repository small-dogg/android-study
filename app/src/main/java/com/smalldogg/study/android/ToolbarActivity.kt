package com.smalldogg.study.android

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_animation_activity.*
import kotlinx.android.synthetic.main.toolbar_activity.*

class ToolbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.toolbar_activity)

        // toolbar를 액션바 대신 사용하도록 설정한다.
        setSupportActionBar(toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu4, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_item1 -> {
                textView79.text = "메뉴 1을 눌렀음"
            }
            R.id.action_item2 -> {
                textView79.text = "메뉴 2을 눌렀음"
            }
            R.id.action_item3 -> {
                textView79.text = "메뉴 3을 눌렀음"
            }
        }
        return super.onOptionsItemSelected(item)

    }
}