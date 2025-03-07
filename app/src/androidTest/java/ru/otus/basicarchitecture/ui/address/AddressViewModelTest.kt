package ru.otus.basicarchitecture.ui.address

import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.anyString
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.otus.basicarchitecture.ui.data.AddressData
import ru.otus.basicarchitecture.ui.data.AddressIP
import ru.otus.basicarchitecture.ui.data.RetrofitClient
import ru.otus.basicarchitecture.ui.data.WizardCache

@RunWith(MockitoJUnitRunner::class)
class AddressViewModelTest {
    private lateinit var server: MockWebServer
    private lateinit var viewModel: AddressViewModel

    private var retrofitClient: RetrofitClient = RetrofitClient()

    @Before
    fun set() {
        server = MockWebServer()
        val wizardCache = WizardCache()
        val addressData = AddressData()

        retrofitClient.apiService = Retrofit.Builder()
            .baseUrl(server.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AddressIP::class.java)

        viewModel = AddressViewModel(wizardCache, addressData, retrofitClient)
        server.start()
    }

    @Test
    fun getDataNotice() {
        runBlocking {

            val response = MockResponse().setResponseCode(200).setBody(
                """
                {
                    "suggestions": [
                        {
                            "value": "г Москва, ул Хабаровская",
                        },
                    ]
                }

            """.trimIndent()
            )
            server.enqueue(response)

            verify(viewModel.getDataNotice(anyString()))
        }
    }

    @Test
    fun setAddress() {

        viewModel.setAddress("Москва")

        val result = viewModel.wizardCache.personAddress
        val exceptedValue = "Москва"
        assertEquals(exceptedValue, result)
    }

    @After
    fun shutdown() {
        server.shutdown()
    }
}