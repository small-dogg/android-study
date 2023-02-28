package com.smalldogg.study.android

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.option_menu_activity.*

class OptionMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.option_menu_activity)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //XML로 메뉴를 구성한다.
//        menuInflater.inflate(R.menu.main_menu, menu)

        menu?.add(Menu.NONE, Menu.FIRST, Menu.NONE, "코드 메뉴1")
        val sub = menu?.addSubMenu("코드 메뉴2")
        sub?.add(Menu.NONE, Menu.FIRST + 10, Menu.NONE, "코드 메뉴 2-1")
        sub?.add(Menu.NONE, Menu.FIRST + 20, Menu.NONE, "코드 메뉴 2-1")
        menu?.add(Menu.NONE, Menu.FIRST + 2, Menu.NONE, "코드 메뉴3")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //메뉴의 id 별로 분기

//        when (item.itemId) {
//            R.id.item1 -> textView35.text= "메뉴 1을 눌렀습니다."
//            R.id.item2 -> textView35.text= "메뉴 2을 눌렀습니다."
//            R.id.item2_1 -> textView35.text= "메뉴 2-1을 눌렀습니다."
//            R.id.item2_2 -> textView35.text= "메뉴 2-2을 눌렀습니다."
//            R.id.item3 -> textView35.text= "메뉴 3을 눌렀습니다."
//        }

        when (item.itemId) {
            Menu.FIRST -> textView35.text = "코드 메뉴 1을 눌렀습니다."
            Menu.FIRST + 10 -> textView35.text = "코드 메뉴 2-1을 눌렀습니다."
            Menu.FIRST + 20 -> textView35.text = "코드 메뉴 2-2을 눌렀습니다."
            Menu.FIRST + 2 -> textView35.text = "코드 메뉴 3을 눌렀습니다."
        }

        return super.onOptionsItemSelected(item)
    }

}