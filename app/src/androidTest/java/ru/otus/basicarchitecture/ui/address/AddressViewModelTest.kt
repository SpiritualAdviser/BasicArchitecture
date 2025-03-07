package ru.otus.basicarchitecture.ui.address

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import ru.otus.basicarchitecture.ui.authorization.AuthorizationViewModel
import ru.otus.basicarchitecture.ui.data.AddressData
import ru.otus.basicarchitecture.ui.data.WizardCache

@RunWith(AndroidJUnit4::class)
class AddressViewModelTest {

    private lateinit var viewModel: AddressViewModel

    @Before
    fun set() {
        val wizardCache = WizardCache()
        val addressData = AddressData()
        viewModel = AddressViewModel(wizardCache, addressData)
    }

    @Test
    fun getDataNotice() {
    }
}