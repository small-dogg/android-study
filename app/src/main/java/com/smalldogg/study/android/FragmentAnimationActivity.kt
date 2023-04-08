package com.smalldogg.study.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class FragmentAnimationActivity : AppCompatActivity() {

    val firstFragment = FirstFragment2()
    val secondFragment = SecondFragment2()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_activity)

        setFragment("first")

    }

    fun setFragment(name:String){
        val tran = supportFragmentManager.beginTransaction()

        when (name) {
            "first" -> {
                tran.replace(R.id.container6, firstFragment)
            }
            "second" -> {
                //전환 애니메이션 발생
//                tran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//                tran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                tran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)

                //fade-in & out
//                tran.setCustomAnimations(R.anim.fade_xml1,R.anim.fade_xml2, R.anim.fade_xml1, R.anim.fade_xml2)

                //slide
                tran.setCustomAnimations(R.anim.slide_xml1,R.anim.slide_xml2,R.anim.slide_xml3,R.anim.slide_xml4)

                tran.replace(R.id.container6, secondFragment)
                tran.addToBackStack("second")
            }
        }

        tran.commit()
    }

}