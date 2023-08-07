//package com.example.uas_olmos_akb.presentation.activity
//
//import android.content.Intent
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import com.example.uas_olmos_akb.databinding.ActivityMainBinding
//
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityMainBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//
//        binding.btnCekHarga.setOnClickListener {
//            startActivity(Intent(this, HargaTerkiniActivity::class.java))
//        }
//
//        binding.btnCekSpesifikasiMotor.setOnClickListener {
//            startActivity(Intent(this, SpesifikasiActivity::class.java))
//        }
//    }
//}