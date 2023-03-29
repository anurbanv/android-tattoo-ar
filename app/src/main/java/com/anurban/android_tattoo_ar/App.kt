package com.anurban.android_tattoo_ar

import android.app.Application
import androidx.room.Room
import com.anurban.android_tattoo_ar.core.data.api.AppApi
import com.anurban.android_tattoo_ar.core.data.database.AppDatabase
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@HiltAndroidApp
class App : Application() {

    companion object {
        lateinit var instance: App
    }

    lateinit var appApi: AppApi

    lateinit var appDatabase: AppDatabase

    override fun onCreate() {
        super.onCreate()

        instance = this

        appApi = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.google.com/")
            .build().create(AppApi::class.java)

        appDatabase = Room
            .databaseBuilder(applicationContext, AppDatabase::class.java, "app-db")
            .build()
    }
}
