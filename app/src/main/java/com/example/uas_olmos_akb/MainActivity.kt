package com.example.uas_olmos_akb

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uas_olmos_akb.databinding.ActivityMainBinding
import com.example.uas_olmos_akb.presentation.activity.HargaTerkiniActivity
import com.example.uas_olmos_akb.presentation.activity.SpesifikasiActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCekSpesifikasiMotor.setOnClickListener {
            val intent = Intent(this, SpesifikasiActivity::class.java)
            startActivity(intent)
        }
        binding.btnCekHarga.setOnClickListener {
            startActivity(Intent(this, HargaTerkiniActivity::class.java))
        }
    }

}