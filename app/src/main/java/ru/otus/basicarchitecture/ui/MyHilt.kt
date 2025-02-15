package ru.otus.basicarchitecture.ui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import ru.otus.basicarchitecture.ui.data.WizardCache
import javax.inject.Inject

@HiltAndroidApp
class MyHilt : Application() {

    @Inject
    lateinit var wizardCache: WizardCache

    override fun onCreate() {
        super.onCreate()
        wizardCache
    }
}