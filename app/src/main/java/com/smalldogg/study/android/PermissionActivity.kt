package com.smalldogg.study.android

import android.Manifest.permission
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.permission_activity.*

class PermissionActivity : AppCompatActivity() {

    val permissionList = arrayOf(
        permission.INTERNET,
        permission.ACCESS_FINE_LOCATION,
        permission.ACCESS_COARSE_LOCATION,
        permission.READ_CONTACTS,
        permission.WRITE_CONTACTS,
        permission.READ_EXTERNAL_STORAGE,
        permission.WRITE_EXTERNAL_STORAGE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.permission_activity)

        textView35.text = ""

        for (permission in permissionList) {
            //권한 허용 여부를 확인한다.
            val chk = checkCallingOrSelfPermission(permission)

            if (chk == PackageManager.PERMISSION_GRANTED) {
                textView35.append("$permission : 허용 \n")
            } else {
                textView35.append("$permission : 거부 \n")
            }
        }

        button78.setOnClickListener {
            //거부된 권한을 사용자에게 확인받음
            requestPermissions(permissionList,0)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        for (idx in grantResults.indices) {
            if (grantResults[idx] == PackageManager.PERMISSION_GRANTED) {
                textView35.append("${permissions[idx]} : 허용\n")
            } else {
                textView35.append("${permissions[idx]} : 거부\n")
            }
        }
    }

}