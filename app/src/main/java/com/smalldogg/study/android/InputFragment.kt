package com.smalldogg.study.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_input.*

class InputFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input,null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        input_button.setOnClickListener {
            val activity = activity as ActivityControllerActivity

            activity.value1 = input_edit1.text.toString()
            activity.value2 = input_edit2.text.toString()

            activity.setFragment("result")
        }
    }
}