package com.smalldogg.study.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import kotlinx.android.synthetic.main.viewpager2_activity.*

class ViewPager2Activity : androidx.fragment.app.FragmentActivity() {

    val frag1 = SubFragment5()
    val frag2 = SubFragment6()
    val frag3 = SubFragment7()

    val fragList = arrayOf(frag1, frag2, frag3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.viewpager2_activity)

        setActionBar(toolbar5)

        val adapter1 = object : FragmentStateAdapter(this){
            override fun getItemCount(): Int {
                return fragList.size

            }

            override fun createFragment(position: Int): Fragment {
                return fragList[position]
            }
        }

        pager2.adapter = adapter1
    }

}