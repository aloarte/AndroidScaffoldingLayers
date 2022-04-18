package com.p4r4d0x.myapplicationlayers.di

import android.app.Application
import com.p4r4d0x.myapplicationlayers.dataSourcesModule
import com.p4r4d0x.myapplicationlayers.repositoriesModule
import com.p4r4d0x.myapplicationlayers.useCasesModule
import com.p4r4d0x.myapplicationlayers.vmModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(vmModule, repositoriesModule, useCasesModule, dataSourcesModule)
        }
    }
}