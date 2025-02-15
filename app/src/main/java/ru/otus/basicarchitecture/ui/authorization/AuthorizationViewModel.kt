package ru.otus.basicarchitecture.ui.authorization

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.otus.basicarchitecture.ui.data.WizardCache
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private var wizardCache: WizardCache
) : ViewModel() {

    fun setName(name: String) {
        wizardCache.personName = name
    }

    fun setSurname(surname: String) {
        wizardCache.personSurname = surname
    }

    fun setBirthDate(birthDate: String) {
        wizardCache.personBirthDate = birthDate
    }
}