package com.smalldogg.study.android

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.action_bar_activity.*

class ActionBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.action_bar_activity)
    }

    //
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu2, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1 -> {
                textView72.text = "첫 번째 메뉴"
            }
            R.id.item2 -> {
                textView72.text = "두 번째 메뉴"
            }
            R.id.item3 -> {
                textView72.text = "세 번째 메뉴"
            }
            R.id.item4 -> {
                textView72.text = "네 번째 메뉴"
            }
        }
        return super.onOptionsItemSelected(item)
    }

}