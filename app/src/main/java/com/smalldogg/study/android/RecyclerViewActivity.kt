package com.smalldogg.study.android

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.recycler_view_activity.*
import kotlinx.android.synthetic.main.row4.view.*

class RecyclerViewActivity : AppCompatActivity() {

    val imgRes = intArrayOf(
        R.drawable.imgflag1, R.drawable.imgflag2, R.drawable.imgflag3, R.drawable.imgflag4,
        R.drawable.imgflag5, R.drawable.imgflag6, R.drawable.imgflag7, R.drawable.imgflag8,
    )

    val data1 = arrayOf(
        "토고", "프랑스 문자열을 길게 작성작성 길게 작성", "스위스", "스페인", "일본 문자열을 얘도 길게 한번 작성해봄", "독일", "브라질", "대한민국"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view_activity)

        val adapter1 = RecyclerAdapter()
        recycler1.adapter = adapter1

//        recycler1.layoutManager = LinearLayoutManager(this)
//        recycler1.layoutManager = GridLayoutManager(this, 4)
//        recycler1.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//        recycler1.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
        recycler1.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
    }

    // RecyclerView의 Adapter 클래스
    inner class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolderClass>() {

        //항목 구성을 위한 ViewHolder 객체가 필요할 때 호출되는 메서드
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
            //항목으로 사용할 View 객체를 생성한다.
            val itemView = layoutInflater.inflate(R.layout.row4, null)
            val holder = ViewHolderClass(itemView)
            itemView.setOnClickListener(holder)
            return holder
        }

        //ViewHolder를 통해 항목을 구성할 때, 항목 내의 View 객체에 데이터를 셋팅한다.
        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
            holder.rowImageView.setImageResource(imgRes[position])
            holder.rowTextView.text = data1[position]
        }

        override fun getItemCount(): Int {
            return imgRes.size
        }

        //ViewHolder 클랫스
        inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView),
            OnClickListener {
            // 항목 View 내부의 View 객체의 주소 값을 담는다.
            val rowImageView = itemView.rowImageView4
            val rowTextView = itemView.rowTextView4
            override fun onClick(p0: View?) {
                textView34.text = data1[adapterPosition]
            }

        }


    }
}