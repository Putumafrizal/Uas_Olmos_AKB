package com.example.uas_olmos_akb

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.uas_olmos_akb.data.remote.ApiService
import com.example.uas_olmos_akb.data.repository.MotorcycleRepository
import com.example.uas_olmos_akb.presentation.viewmodel.MotorcycleViewModel
import com.example.uas_olmos_akb.data.remote.RetrofitClient
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext
import org.koin.dsl.module

class MainActivity : Application() {

    override fun onCreate() {
        super.onCreate()

        context = applicationContext

        GlobalContext.startkoin{
            andoridLogger()
            androidContext(this@MainActivity)
            modules(
                VmModule,
                repositoryModule
            )
        }


    }

    private val vmModule = module {
        viewModel { MotorcycleViewModel(get()) }
    }

    private val repositoryModule = module {
        single { RetrofitClient.createService<ApiService>() }
        single { MotorcycleRepository(get()) }
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }
}