package com.smalldogg.study.android

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.tab_layout_activity.*

class TabLayoutActivity : androidx.fragment.app.FragmentActivity() {

    //ViewPager2에 셋팅하기 위한 Fragment들을 가지고 있는 ArrayList
    val fragmentList = ArrayList<Fragment>()

    //탭에 표시될 문자열을 가지고 있는 리스트
    val tabTitle = ArrayList<String>()

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tab_layout_activity)

        setActionBar(toolbar)

        toolbar.setTitleTextColor(Color.BLACK)

        tabs.setTabTextColors(Color.BLACK, Color.RED)

       for(i in 0..9){
           val sub = SubFragment8("$i 번째 프래그먼트")
           fragmentList.add(sub)
       }

       val adapter1 = object : FragmentStateAdapter(this) {
           override fun getItemCount(): Int {
               return fragmentList.size
           }

           override fun createFragment(position: Int): Fragment {
               return fragmentList[position]
           }
       }
       pager3.adapter = adapter1

       //tab과 viewPager를 연결한다.
       TabLayoutMediator(tabs, pager3){tab, position ->
           tab.text = "탭 $position"
       }.attach()

    }

}