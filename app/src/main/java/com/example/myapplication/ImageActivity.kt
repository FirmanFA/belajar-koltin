package com.example.myapplication

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityImageBinding
import com.example.myapplication.utils.PermissionUtils
import com.example.myapplication.utils.StorageUtils
import java.util.*

class ImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setClickListeners()
    }

    private fun setClickListeners(){
        binding.btnCamera.setOnClickListener {
            if (PermissionUtils.isPermissionsGranted(this, getRequiredPermission())){
                openCamera()
            }
        }

        binding.btnGallery.setOnClickListener {
            if(PermissionUtils.isPermissionsGranted(this,getRequiredPermission())){
                openGallery()
            }
        }
    }

    private val cameraResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val bitmap = result.data?.extras?.get("data") as Bitmap
                val uri = StorageUtils.savePhotoToExternalStorage(
                    contentResolver,
                    UUID.randomUUID().toString(),
                    bitmap
                )
                uri?.let {
                    loadImage(it)
                }
            }
        }

    private fun loadImage(uri: Uri) {
        binding.ivImage.setImageURI(uri)
    }

    private val galleryResult =
        registerForActivityResult(ActivityResultContracts.GetContent()) { result ->
            if (result != null) {
                loadImage(result)
            }
        }



    private fun openGallery() {
        intent.type = "image/*"
        galleryResult.launch("image/*")
    }

    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraResult.launch(cameraIntent)
    }

    private fun getRequiredPermission(): Array<String> {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
        } else {
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA
            )
        }
    }
}