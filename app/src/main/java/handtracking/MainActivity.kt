package handtracking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mediapipemultihandstrackingapp.R
import com.google.mediapipe.components.PermissionHelper

class MainActivity : AppCompatActivity() {

    lateinit var handTrackingBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handTrackingBtn = findViewById(R.id.openBtn)
        handTrackingBtn.setOnClickListener {
            if (!PermissionHelper.cameraPermissionsGranted(this))
                PermissionHelper.checkAndRequestCameraPermissions(this)
            if (PermissionHelper.cameraPermissionsGranted(this)) {
                val intent = Intent(this, HandTrackingActivity::class.java)
                startActivity(intent)
            }
        }

        PermissionHelper.checkAndRequestCameraPermissions(this)
        handTrackingBtn.isEnabled = PermissionHelper.cameraPermissionsGranted(this)

    }

    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<String>,
            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        PermissionHelper.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}