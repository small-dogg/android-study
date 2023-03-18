package com.smalldogg.study.android

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.TimePicker
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.custom_dialog.view.*
import kotlinx.android.synthetic.main.dialog_activity.*
import java.util.*

class DialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_activity)

        button100.setOnClickListener {
            var builder = AlertDialog.Builder(this)

            builder.setTitle("기본 다이얼로그")
            builder.setMessage("기본 다이얼로그입니다.")
            builder.setIcon(R.mipmap.ic_launcher)

            builder.setPositiveButton("Positive") { dialogInterface, i ->
                textView52.text = "Positive 버튼을 눌렀습니다."

            }
            builder.setNeutralButton("Neutral") { dialogInterface: DialogInterface, i: Int ->
                textView52.text = "Neutral 버튼을 눌렀습니다."

            }
            builder.setNegativeButton("Negative") { dialogInterface: DialogInterface, i: Int ->
                textView52.text = "Negative 버튼을 눌렀습니다."
            }

            builder.show()
        }

        button101.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("커스텀 다이얼로그")
            builder.setIcon(R.mipmap.ic_launcher)

            val custom_view = layoutInflater.inflate(R.layout.custom_dialog, null)
            builder.setView(custom_view)

            builder.setPositiveButton("확인") { dialogInterface, i ->
                //closer 사용
                custom_view.run {
                    textView52.text = "${custom_edit1.text}\n"
                    textView52.append("${custom_edit2.text}")
                }
            }

            builder.setNegativeButton("취소", null)


            builder.show()
        }

        button102.setOnClickListener {
            val calendar = Calendar.getInstance()

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val listener1 =
                OnDateSetListener { view, year, month, dayOfMonth ->
                    textView52.text = "${year}/${month + 1}/${dayOfMonth}"
                }

            val picker = DatePickerDialog(this, listener1, year, month, day)

            picker.show()

        }

        button104.setOnClickListener {
            val cal = Calendar.getInstance()

            val hour = cal.get(Calendar.HOUR)
            val min = cal.get(Calendar.MINUTE)

            val listener2 = TimePickerDialog.OnTimeSetListener{ timePicker: TimePicker, i: Int, i1: Int ->
                textView52.text = "${i}:${i1}"
            }

            val picker = TimePickerDialog(this, listener2, hour, min, true)

            picker.show()
        }
    }

}