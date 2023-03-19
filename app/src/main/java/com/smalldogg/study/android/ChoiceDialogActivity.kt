package com.smalldogg.study.android

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.choice_dialog_activity.*

class ChoiceDialogActivity : AppCompatActivity() {

    val data1 = arrayOf("항목1", "항목2", "항목3", "항목4", "항목5", "항목6", "항목7", "항목8")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choice_dialog_activity)

        button106.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            builder.setTitle("Single Choice List")

            builder.setSingleChoiceItems(data1, 3) { dialogInterface, i ->
                val t1 = Toast.makeText(this, data1[i], Toast.LENGTH_SHORT)
                t1.show()
            }
            builder.setNegativeButton("취소", null)

            builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->
                val alert = dialogInterface as AlertDialog

                val idx = alert.listView.checkedItemPosition

                textView54.text = "선택된 항목 : ${data1[idx]}"
            }

            builder.show()
        }

        button107.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            val boolArray = booleanArrayOf(true, false, false, true, false, false, false, false)

            builder.setMultiChoiceItems(
                data1,
                boolArray
            ) { dialogInterface: DialogInterface, i: Int, b: Boolean ->

                if (b) {
                    Toast.makeText(this, "${data1[i]}가 체크되었습니다.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "${data1[i]}가 체크 해제되었습니다.", Toast.LENGTH_SHORT).show()

                }

            }

            builder.setNegativeButton("취소", null)

            builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->
                val alert = dialogInterface as AlertDialog

                textView54.text = ""

                val positions = alert.listView.checkedItemPositions

                for (i in 0 until positions.size()) {
                    var index = positions.keyAt(i)

                    if (positions.get(index)) {
                        textView54.append("${data1[index]}, ")
                    }
                }

            }

            builder.show()
        }
    }

}