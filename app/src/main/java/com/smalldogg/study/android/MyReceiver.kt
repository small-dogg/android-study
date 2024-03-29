package com.smalldogg.study.android

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        //ㅠBR의 이름으로 분기한다.
        when (intent.action) {
            "android.intent.action.BOOT_COMPLETED" ->Toast.makeText(context, "부팅완료", Toast.LENGTH_SHORT).show()
            "android.provider.Telephony.SMS_RECEIVED" -> {
                if (intent.extras != null) {
                    // 문자 메시지 정보 객체를 추출한다.
                    val pduObject = intent.extras?.get("pdus") as Array<Any>
                    if (pduObject != null) {
                        for (obj in pduObject) {
                            //문자 메시지 양식 객체를 추출한다.
                            val format = intent.extras?.getString("format")
                            //문자 메시지 객체를 생성한다.
                            val currentSMS = SmsMessage.createFromPdu(obj as ByteArray?, format)

                            //발신자 전화번호
                            val showMessage = "전화번호 : ${currentSMS.displayOriginatingAddress}\n" +
                                    "${currentSMS.displayMessageBody}"

                            Toast.makeText(context, showMessage, Toast.LENGTH_SHORT).show()
                        }
                    }

                }
            }
        }
    }
}