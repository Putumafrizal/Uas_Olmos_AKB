package com.example.uas_olmos_akb.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.moto.olmos.R
import com.example.uas_olmos_akb.databinding.ActivityHargaTerkiniBinding

class HargaTerkiniActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHargaTerkiniBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHargaTerkiniBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}