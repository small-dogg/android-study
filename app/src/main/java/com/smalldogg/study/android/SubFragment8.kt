package com.smalldogg.study.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_sub8.*

class SubFragment8 : Fragment {
    lateinit var title: String

    constructor(title:String){
        this.title = title
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_sub8, null)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textView85.text =title
        super.onViewCreated(view, savedInstanceState)
    }
}