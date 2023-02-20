package com.smalldogg.study.android

import android.os.Bundle
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.custom_list_view2_activity.*

class CustomListView2Activity : AppCompatActivity() {

    val imgRes = intArrayOf(
        R.drawable.imgflag1, R.drawable.imgflag2, R.drawable.imgflag3, R.drawable.imgflag4,
        R.drawable.imgflag5, R.drawable.imgflag6, R.drawable.imgflag7, R.drawable.imgflag8
    )

    val data1 = arrayOf(
        "토고", "프랑스", "스위스", "스페인", "일본", "독일", "브라질", "대한민국"
    )

    val data2 = arrayOf(
        "togo", "france", "swiss", "spain", "japan", "germany", "brazil", "korea"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_list_view2_activity)

        //simple adapter에 셋팅할 데이터를 가지고 있을 ArrayList
        val dataList = ArrayList<HashMap<String, Any>>()

        for (i in imgRes.indices) {
            val map = HashMap<String, Any>()
            map["img"] = imgRes[i]
            map["data1"] = data1[i]
            map["data2"] = data2[i]

            dataList.add(map)
        }

        val keys = arrayOf("img", "data1", "data2")
        val ids = intArrayOf(R.id.row2ImageView, R.id.row2TextView1, R.id.row2TextView2)

        val adapter1 = SimpleAdapter(this, dataList, R.layout.row2, keys, ids)
        list3.adapter = adapter1

        list3.setOnItemClickListener { adapterView, view, i, l ->
            textView23.text = "${data1[i]} 항목을 터치하였습니다."
        }
    }
}