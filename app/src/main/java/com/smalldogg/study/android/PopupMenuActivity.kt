package com.smalldogg.study.android

import android.os.Bundle
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.popup_menu_activity.*

class PopupMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.popup_menu_activity)

        button79.setOnClickListener {
            //PopupMenu 객체를 생성한다.
            val pop = PopupMenu(this, textView36)

            //메뉴 구성
            menuInflater.inflate(R.menu.popup, pop.menu)

            pop.setOnMenuItemClickListener {

                when (it.itemId) {
                    R.id.popup1 -> textView36.text = "메뉴 1을 눌렀습니다."
                    R.id.popup2 -> textView36.text = "메뉴 2을 눌렀습니다."
                    R.id.popup3 -> textView36.text = "메뉴 3을 눌렀습니다."
                }

                true
            }

            pop.show()
        }
    }

}