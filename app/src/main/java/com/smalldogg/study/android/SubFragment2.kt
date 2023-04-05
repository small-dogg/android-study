package com.smalldogg.study.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_sub2.*
import kotlinx.android.synthetic.main.fragment_view_activity.*

class SubFragment2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sub2, null)
        // 내부의 View들으 ㅣ주소값을 가져온다.
//
//        val text1 = view.findViewById<TextView>(R.id.frag_text1)
//        val btn1 = view.findViewById<Button>(R.id.frag_btn1)
//
//        btn1.setOnClickListener {
//            text1.text = "Fragment 문자열"
//        }

        return view
    }

    //  Fragment가 관리한 View 내부의 View의 주소값들이 셋팅된 후
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        frag_btn1.setOnClickListener {
            frag_text1.text = "Fragment 문자열"
        }

        frag_btn2.setOnClickListener {
            //Activity를 추출한다.
            val parent = activity as FragmentViewActivity
            parent.activity_text1.text = "Activity 문자열"

        }
    }
}