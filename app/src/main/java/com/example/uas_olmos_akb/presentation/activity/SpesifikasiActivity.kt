package com.example.uas_olmos_akb.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.uas_olmos_akb.R
import com.example.uas_olmos_akb.databinding.ActivitySpesifikasiBinding
import com.example.uas_olmos_akb.databinding.ActivitySplashBinding
import com.example.uas_olmos_akb.presentation.viewmodel.MotorcycleViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpesifikasiActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpesifikasiBinding
    private val motorcycleViewModel: MotorcycleViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpesifikasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btnInfoDetail.setOnClickListener {
            startActivity(Intent(this, InfoDetailActivity::class.java))
        }

        vmObserver()
    }

    private fun vmObserver() {
        motorcycleViewModel.getMotorcycleDetail()

        motorcycleViewModel.listDetail.observe(this) { motoData ->
            val ninja650 = motoData.find { it?.model?.trim() == "Ninja 650" } ?: return@observe

            binding.apply {
                tvEngineType.text = ninja650.engine
                tvDisplacement.text = ninja650.displacement
                tvPower.text = ninja650.power
                tvTorque.text = ninja650.torque
                tvBore.text = ninja650.bore_stroke
                tvCompression.text = ninja650.compression
                tvIgnition.text = ninja650.ignition
                tvFuelSys.text = ninja650.fuel_system

                tvTransmission.text = ninja650.transmission
                tvFinalDrive.text = "Sealed chain"

                tvSusFront.text = ninja650.front_suspension
                tvSusRear.text = ninja650.rear_suspension
                tvFrontBrakes.text = ninja650.front_brakes
                tvRearBrakes.text = ninja650.rear_brakes
                tvFrontTires.text = ninja650.front_tire
                tvRearTires.text = ninja650.rear_tire
                tvFuelCap.text = ninja650.fuel_capacity

                tvFrameType.text = ninja650.frame
                tvRake.text = "24.0'/3.9 in"
                tvOvrLength.text = ninja650.total_length
                tvOvrWidth.text = ninja650.total_width
                tvOvrHeight.text = ninja650.total_height
                tvWheelbase.text = ninja650.wheelbase
                tvGrClear.text = ninja650.ground_clearance
                tvSeatHeight.text = ninja650.seat_height
                tvCurbHeight.text = "419.0 lb (190.0kg)"
            }
        }

        motorcycleViewModel.isLoading.observe(this) { isLoading ->
            if (isLoading) {
                binding.lvLoading.visibility = View.VISIBLE
            } else {
                binding.lvLoading.visibility = View.GONE
            }
        }
    }
}