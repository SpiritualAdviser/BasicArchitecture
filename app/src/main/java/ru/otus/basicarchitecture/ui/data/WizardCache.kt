package ru.otus.basicarchitecture.ui.data

import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class WizardCache @Inject constructor() {

    var personName: String = ""
    var personSurname: String = ""
    var personBirthDate: String = ""
}