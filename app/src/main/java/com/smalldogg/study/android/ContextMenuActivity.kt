package com.smalldogg.study.android

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.context_menu_activity.*

class ContextMenuActivity : AppCompatActivity() {

    val data1 = arrayOf(
        "항목1", "항목2", "항목3", "항목4", "항목5"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.context_menu_activity)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)
        listView10.adapter = adapter

        listView10.setOnItemClickListener { adapterView, view, i, l ->
            textView36.text = "리스트뷰의 항목 클릭 : ${data1[i]}"
        }

        registerForContextMenu(textView36)
        registerForContextMenu(listView10)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        //길게 누른 View의 ID로 분기한다
        when (v?.id) {
            R.id.textView36 -> {
                menu?.setHeaderTitle("텍스트뷰의 메뉴")
                menuInflater.inflate(R.menu.menu1, menu)
            }

            R.id.listView10 -> {

                val info = menuInfo as AdapterView.AdapterContextMenuInfo

                menu?.setHeaderTitle("리스트뷰의 메뉴 : ${info.position}")
                menuInflater.inflate(R.menu.menu2, menu)

            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        //리스트 항목의 인덱스 번호를 받을 변수
        var position = 0

        when (item.itemId) {
            R.id.list_item1, R.id.list_item2 -> {
                val info = item.menuInfo as AdapterContextMenuInfo
                position = info.position
            }
        }

        //메뉴의 ID 값으로 분기하낟.
        when (item.itemId) {
            R.id.text_item1 -> textView36.text = "텍스트 뷰의 메뉴1을 눌렀습니다."
            R.id.text_item2 -> textView36.text = "텍스트 뷰의 메뉴2를 눌렀습니다."
            R.id.list_item1 -> textView36.text = "리스트 뷰의 메뉴1를 눌렀습니다. : $position"
            R.id.list_item2 -> textView36.text = "리스트 뷰의 메뉴2를 눌렀습니다. : $position"
        }

        return super.onContextItemSelected(item)
    }

}