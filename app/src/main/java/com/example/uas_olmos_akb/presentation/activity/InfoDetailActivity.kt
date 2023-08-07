package com.example.uas_olmos_akb.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uas_olmos_akb.databinding.ActivityInfoDetailBinding

class InfoDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}