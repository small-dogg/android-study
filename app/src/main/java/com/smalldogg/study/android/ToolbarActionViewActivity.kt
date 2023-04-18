package com.smalldogg.study.android

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import kotlinx.android.synthetic.main.toolbar_action_view_activity.*

class ToolbarActionViewActivity : AppCompatActivity() {

    val dataList = arrayOf("aaaa","bbb","cccc","ddddd")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.toolbar_action_view_activity)

        setSupportActionBar(toolbar2)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dataList)
        list2.adapter = adapter

        list2.isTextFilterEnabled = true
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu5, menu)

        val item1 = menu?.findItem(R.id.menu4_item1)
        val search1 = item1?.actionView as SearchView

        search1.queryHint = "검색어 입력"

        //액션뷰가 접혀지거나 펼쳐졌을 때 반응할 리스너
        val listener1 = object : MenuItem.OnActionExpandListener{
            override fun onMenuItemActionCollapse(p0: MenuItem): Boolean {
                textView80.text = "접혀졌습니다."
                return true
            }

            override fun onMenuItemActionExpand(p0: MenuItem): Boolean {
                textView80.text = "펼쳐졌습니다."
                return true
            }
        }

        item1.setOnActionExpandListener(listener1)

        val listener2 = object : OnQueryTextListener{

            override fun onQueryTextChange(newText: String?): Boolean {
                textView80.text = "입력 중입니다."
                textView81.text = "입력중 $newText"

                list2.setFilterText(newText)
                if (newText?.length == 0) {
                    list2.clearTextFilter()
                }
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                textView80.text = "입력 완료"
                textView81.text = "입력완료 $query"

                search1.clearFocus()
                return true
            }
        }

        search1.setOnQueryTextListener(listener2)


        return true
    }
}