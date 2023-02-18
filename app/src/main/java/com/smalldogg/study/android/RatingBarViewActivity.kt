package com.smalldogg.study.android

import android.os.Bundle
import android.widget.RatingBar
import android.widget.RatingBar.OnRatingBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.rating_bar_view_activity.*

class RatingBarViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rating_bar_view_activity)

        button63.setOnClickListener {
            textView16.text = "Rating 1 : ${ratingBar.rating}\n"
            textView16.append("Rating 2 : ${ratingBar2.rating}\n")
            textView16.append("Rating 3 : ${ratingBar3.rating}\n")
            textView16.append("Rating 4 : ${ratingBar4.rating}\n")
        }

        button64.setOnClickListener {
            ratingBar.rating = 1.0f
            ratingBar2.rating = 2.0f
            ratingBar3.rating = 3.5f
            ratingBar4.rating = 4.0f
        }

        ratingBar2.setOnRatingBarChangeListener(listner1)
        ratingBar3.setOnRatingBarChangeListener(listner1)
    }

    val listner1 = object : OnRatingBarChangeListener {
        override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
            when (ratingBar?.id) {
                R.id.ratingBar2 -> {
                    textView17.text = "Rating 2 : ${rating}\n"
                    if (fromUser) {
                        textView17.append("사용자에 의해 설정됨")
                    } else {
                        textView17.append("사용자에 의해 설정됨")
                    }

                }
                R.id.ratingBar3 -> {
                    textView17.text = "Rating 3 : ${rating}\n"

                    if (fromUser) {
                        textView17.append("사용자에 의해 설정됨")
                    } else {
                        textView17.append("사용자에 의해 설정됨")
                    }
                }

            }
        }

    }


}