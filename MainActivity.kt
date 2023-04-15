package com.govind8061.mypdfviewer

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import java.security.Permission

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkPermission()
        val intent = Intent(this, PdfViewerActivity::class.java)
        startActivity(intent)
    }

    private fun checkPermission():Boolean {
            if (ActivityCompat.checkSelfPermission(this,READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,arrayOf(READ_EXTERNAL_STORAGE), 13)
                return false
            }
        return true
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 13) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show()
            } else {
                ActivityCompat.requestPermissions(this,arrayOf(READ_EXTERNAL_STORAGE), 13)
            }
        }
    }
}