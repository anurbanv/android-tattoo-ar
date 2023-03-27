package com.anurban.android_tattoo_ar

import android.app.Application
import com.anurban.android_tattoo_ar.core.data.api.AppApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    lateinit var appApi: AppApi

    override fun onCreate() {
        super.onCreate()

        instance = this

        appApi = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(AppApi::class.java)
    }
}
