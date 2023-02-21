package com.smalldogg.study.android

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import kotlinx.android.synthetic.main.view_pager_activity.*

class ViewPagerActivity : AppCompatActivity() {

    //ViewPager를 통해 보여줄 View들을 담을 리스트

    val viewList = ArrayList<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_pager_activity)

        val view1 = layoutInflater.inflate(R.layout.view1, null)
        val view2 = layoutInflater.inflate(R.layout.view2, null)
        val view3 = layoutInflater.inflate(R.layout.view3, null)

        val view4 = layoutInflater.inflate(R.layout.view1, null)
        val view5 = layoutInflater.inflate(R.layout.view2, null)
        val view6 = layoutInflater.inflate(R.layout.view3, null)

        viewList.add(view1)
        viewList.add(view2)
        viewList.add(view3)
        viewList.add(view4)
        viewList.add(view5)
        viewList.add(view6)

        val adapter = object : PagerAdapter() {
            //ViewPager 가 보여줄 View의 개수
            override fun getCount(): Int {
                return viewList.size
            }

            //ViewPager가 보여줄 화면 View를 반환하는 메서드
            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                pager1.addView(viewList[position])
                return return viewList[position]

            }

            //instantiateItem이 반환한 객체를 화면으로 사용할 것 인가를 검사하는 메서드
            override fun isViewFromObject(view: View, obj: Any): Boolean {
                return view == obj
            }

            //사라지는 View 객체를 소멸시키는 메서드(Optional)
            override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
                pager1.removeView(obj as View)
            }

        }

        pager1.adapter = adapter

        val listener1 = object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                textView26.text = "$position 번째 View가 나타났습니다."
            }

            override fun onPageSelected(position: Int) {
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        }

        pager1.addOnPageChangeListener(listener1)
    }

}