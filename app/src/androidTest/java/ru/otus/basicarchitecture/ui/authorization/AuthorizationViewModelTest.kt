package ru.otus.basicarchitecture.ui.authorization

import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import ru.otus.basicarchitecture.ui.address.AddressViewModel
import ru.otus.basicarchitecture.ui.data.AddressData
import ru.otus.basicarchitecture.ui.data.WizardCache

@RunWith(AndroidJUnit4::class)
class AuthorizationViewModelTest {

    private lateinit var viewModel: AuthorizationViewModel

    @Before
    fun set() {
        val wizardCache = WizardCache()
        viewModel = AuthorizationViewModel(wizardCache)

        viewModel.setCurrentDate(1, 1, 2018)
    }

    @Test
    fun ageVerification() {

        runBlocking {

            withContext(Dispatchers.Main) {
                val day = 1
                val month = 1
                val year = 2000

                viewModel.ageVerification(day, month, year)
                val result = viewModel.anAdult.value

                val exceptedValue = true
                assertEquals(exceptedValue, result)
            }
        }
    }
}