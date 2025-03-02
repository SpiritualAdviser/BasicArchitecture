package ru.otus.basicarchitecture.ui.address

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.otus.basicarchitecture.ui.data.AddressData
import ru.otus.basicarchitecture.ui.data.AddressIP
import ru.otus.basicarchitecture.ui.data.RetrofitClient
import ru.otus.basicarchitecture.ui.data.WizardCache
import javax.inject.Inject

@HiltViewModel
class AddressViewModel @Inject constructor(
    private var wizardCache: WizardCache,
    private var addressData: AddressData

) : ViewModel() {

    private val apiService = RetrofitClient.getClient().create(AddressIP::class.java)

    fun setCountry(country: String) {
        wizardCache.personCountry = country
    }

    fun setCity(city: String) {
        wizardCache.personCity = city
    }

    fun setAddress(address: String) {
        wizardCache.personAddress = address
    }

    fun getDataNotice(address: String) {
        addressData.query = address

        viewModelScope.launch(Dispatchers.IO) {

            try {
                val result = apiService.postData(
                    dataModal = addressData
                )
                if (result.isSuccessful) {
                    result.body()?.let {
                        it.suggestions
                        println()
                    }

                    println()
                }

            } catch (e: Exception) {
                Log.d("my", e.toString())
                println()
            }
        }
    }
}