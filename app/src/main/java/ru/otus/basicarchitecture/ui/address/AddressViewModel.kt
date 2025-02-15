package ru.otus.basicarchitecture.ui.address

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.otus.basicarchitecture.ui.data.WizardCache
import javax.inject.Inject

@HiltViewModel
class AddressViewModel @Inject constructor(
    private var wizardCache: WizardCache

) : ViewModel() {
    fun setCountry(country: String) {
        wizardCache.personCountry = country
    }

    fun setCity(city: String) {
        wizardCache.personCity = city
    }

    fun setAddress(address: String) {
        wizardCache.personAddress = address
    }
}