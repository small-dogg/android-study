package com.smalldogg.study.android

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class ActivityLifeCycleActivity : AppCompatActivity() {

    //Activity가 생성될 때 자동으로 호출된다.
    //화면 전환이 발생할 때 자동으로 호출된다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_activity)

        Log.d("test", "onCreate")
    }

    //onCreate 메서드 호출 이후에 자동으로 호출
    //Activity가 정지 상태가 되었다가 활동 상태로 돌아올 때 호출
    override fun onStart() {
        super.onStart()
        Log.d("test1", "onStart")
    }

    //onStart 메서드가 호출된 이후에 자동으로 호출된다.
    //Activity 일시 정지 되엌ㅅ다가 다시 돌아 올때 호출
    override fun onResume() {
        super.onResume()
        Log.d("test1", "onResume")
    }

    //Activity가 정지 상태가 되었다가 활동 상태로 돌아갈 때 onStart 전에 호출된다.
    override fun onRestart() {
        super.onRestart()
        Log.d("test1", "onRestart")
    }

    //Activity가 일시 정지 상태가 될 때 호출된다.
    //화면상에서 완전히 사라지거나 현재 화면 위에 작은 팝업 창 같은 것이 나타날 때 호출
    override fun onPause() {
        super.onPause()
        Log.d("test1", "onPause")
    }

    //Activity가 화면에서 사라질 때 호출된다.
    override fun onStop() {
        super.onStop()
        Log.d("test1", "onStop")
    }

    //Activity의 수행이 완전히 종료되어 메모리상에서 제거될 때 호출된다.
    override fun onDestroy() {
        super.onDestroy()
        Log.d("test1", "onDestroy")
    }
}