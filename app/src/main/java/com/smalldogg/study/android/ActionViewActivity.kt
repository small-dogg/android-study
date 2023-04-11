package com.smalldogg.study.android

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import kotlinx.android.synthetic.main.action_view_activity.*

class ActionViewActivity : AppCompatActivity() {

    val data1 = arrayOf("aaaa","bbbb","cccc","dddd","ccdd")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.action_view_activity)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)
        actionList1.adapter = adapter

        // 검색어 기준으로 필터링 될 수 있도록 설정한다.
        actionList1.isTextFilterEnabled = true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu3, menu)

        // SearchView를 가지고 있는 메뉴 아이템 객체를 추출
        val item1 = menu?.findItem(R.id.search_item1)
        //SearchView 객체를 가지고 온다.
        val search1 = item1?.actionView as SearchView

        search1.queryHint = "검색어 입력"

        //메뉴 아이템에 배치된 뷰가 접히거나 펼쳐질 때 반응하는 리스너
        val listener1 = object : MenuItem.OnActionExpandListener{
            //접혔음
            override fun onMenuItemActionCollapse(p0: MenuItem): Boolean {
                textView73.text = "접혔다"

                return true
            }

            //펼쳐짐
            override fun onMenuItemActionExpand(p0: MenuItem): Boolean {
                textView73.text = "펼쳐졌다"

                return true
            }
        }

        item1.setOnActionExpandListener(listener1)

        //searchView의 리스너
        val listener2 = object : OnQueryTextListener{
            //SearchView의 문자열을 입력할 때 마다 호출
            override fun onQueryTextChange(newText: String?): Boolean {
                textView73.text = "문자열 입력중"
                textView74.text = "입력중 : ${newText}"

                //SearchView에 입력한 내용을 ListView의 필터 문자열로 설정한다.
                actionList1.setFilterText(newText)

                //만약 설정한 문자열의 길이가 0이라면 필터 문자열을 제거한다.
                if (newText?.length == 0) {
                    actionList1.clearTextFilter()
                }
                return true
            }

            //키보드의 돋보기 버턴을 눌렀을 때 호출되는 메서드
            override fun onQueryTextSubmit(query: String?): Boolean {
                textView73.text = "문자열 입력완료"
                textView74.text = "입력완료 : ${query}"
                search1.clearFocus()
                return true
            }
        }
        search1.setOnQueryTextListener(listener2)


        return true
    }

}