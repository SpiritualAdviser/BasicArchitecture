package ru.otus.basicarchitecture.ui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyHilt : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}