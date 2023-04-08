package com.smalldogg.study.android

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_fragment_activity.*

class SubFragment4: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val mainActivity = activity as DialogFragmentActivity

        val builder = AlertDialog.Builder(mainActivity)
        builder.setTitle("타이틀 입니다")
        builder.setMessage("메시지입니다")
        builder.setPositiveButton("Positive") { dialogInterface, i ->
            mainActivity.textView69.text = "Positive"
        }

        builder.setNeutralButton("Neutral"){dialogInterface, i ->
            mainActivity.textView69.text = "Neutral"
        }

        builder.setNegativeButton("Negative"){dialogInterface, i ->
            mainActivity.textView69.text = "Negative"

        }

        val alert = builder.create()

        return alert

    }
}