package com.bestuna.todo.base

import android.app.Application
import android.log.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.e("== STARTED ================================================================")
    }
}
