package com.smalldogg.study.android

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.grid_view_activity.*

class GridViewActivity : AppCompatActivity() {

    val data1 = arrayOf(
        "그리드1", "그리드2", "그리드3", "그리드4", "그리드5",
        "그리드6", "그리드7", "그리드8", "그리드9", "그리드10",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grid_view_activity)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)

        grid1.adapter = adapter1

        grid1.setOnItemClickListener(listener1)
    }

    val listener1 = object : OnItemClickListener {
        override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            when (p0?.id) {
                R.id.grid1 -> textView25.text = "${data1[p2]} 항목을 클릭했습니다."
            }
        }

    }

}