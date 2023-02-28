package com.smalldogg.study.android

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.custom_adapter_view_activity.*
import kotlinx.android.synthetic.main.row3.view.*

class CustomAdapterViewActivity : AppCompatActivity() {

    val data1 = arrayOf("데이터1", "데이터2", "데이터3", "데이터4", "데이터5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_adapter_view_activity)

        list4.adapter = adapter1
    }

    val adapter1 = object : BaseAdapter() {
        // 항목의 개수를 반환한다.
        override fun getCount(): Int {
            return data1.size
        }

        override fun getItem(position: Int): Any? {
            return null
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            // 재사용 가능한 View를 변수에 담는다.
            var rowView = convertView

            if (rowView == null) {
                rowView = layoutInflater.inflate(R.layout.row3, null)
            }

//            val text1 = rowView?.findViewById<TextView>(R.id.rowTextView1)
//            val btn1 = rowView?.findViewById<Button>(R.id.rowButton1)
//            val btn2 = rowView?.findViewById<Button>(R.id.rowButton2)
//
//            text1?.text = data1[position]
//
//            btn1?.tag = position
//            btn2?.tag = position
//
//            btn1?.setOnClickListener {
//                textView24.text="${data1[position]}의 첫 번째 버튼을 눌렀습니다."
//            }
//
//            btn2?.setOnClickListener {
//                textView24.text="${it.tag} 두 번째 버튼을 눌렀습니다."
//            }

            rowView?.run {
                rowTextView1.text = data1[position]

                rowButton1.tag = position
                rowButton2.tag = position

                rowButton1.setOnClickListener {
                    textView24.text = "첫 번째 버튼을 눌렀습니다 : ${it.tag}"
                }

                rowButton2.setOnClickListener {
                    textView24.text = "두 번째 버튼을 눌렀습니다 : ${it.tag}"
                }
            }


            return rowView!!
        }

    }
}