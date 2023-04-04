package com.smalldogg.study.android

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class SubFragment : Fragment() {

    // 프래그먼트가 Activity와 연결이 될 때 호출된다.
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("test","onAttach")
    }

    // 프래그먼트가 생성될 때 호출
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("test","onCreate")
    }

    // 프래그먼트를 통해 보여줄 View를 생성하기 위해 호출
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("test","onCreateView")
        return inflater.inflate(R.layout.fragment_sub, null)
    }

    // 프래그먼트를 통해 보여줄 View가 생성되면 호출
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("test","onViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }

    // 액티비티에서 보여줄 프래그먼트가 완전히 생성되면 호출된다.
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("test","onActivityCreated")
    }

    // 프래그먼트가 가동될 때 호출(프래그먼트가 화면에 표시될 때)
    override fun onStart() {
        Log.d("test","onStart")
        super.onStart()
    }

    // 프래그먼트가 보여지고 나서 호출된다.
    override fun onResume() {
        super.onResume()
        Log.d("test","onResume")
    }

    // 프래그먼트가 일시 정지될때 호출(프래그먼트가 화면에서 사라질 때)
    override fun onPause() {
        super.onPause()
        Log.d("test","onPause")
    }

    // 프래그먼트가 화면에서 완전히 사라져서 더 이상 보여지지 않을 때 호출
    // 프래그먼트 정지
    override fun onStop() {
        super.onStop()
        Log.d("test","onStop")
    }

    // 프래그먼트가 메모리 상에서 완전히 소멸될 때 호출
    // 프래그먼트가 붙어있는 Activity 종료될 때
    override fun onDestroy() {
        super.onDestroy()
        Log.d("test","onDestroy")
    }

    // 프래그먼트와 액티비타가 연결이 완전히 끊기기 전에 호출된다.
    override fun onDetach() {
        super.onDetach()
        Log.d("test","onDetach")
    }
}