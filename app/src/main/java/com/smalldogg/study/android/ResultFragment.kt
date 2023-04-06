package com.smalldogg.study.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_input.*
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result,null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainActivity = activity as ActivityControllerActivity

        result_text1.text = mainActivity.value1
        result_text2.text = mainActivity.value2

        mainActivity.setFragment("result")
    }

    override fun onResume() {
        super.onResume()
        input_edit1.setText("")
        input_edit2.setText("")
    }
}