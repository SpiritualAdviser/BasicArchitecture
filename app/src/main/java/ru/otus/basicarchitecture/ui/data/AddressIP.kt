package ru.otus.basicarchitecture.ui.data

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import ru.otus.basicarchitecture.BuildConfig

interface AddressIP {

    @POST("address")
    suspend fun postData(
        @Header("Authorization") apiKey: String = "Token ${BuildConfig.apiKey}" ,
        @Body dataModal: AddressData
    ): Response<ResponseData>
}

object RetrofitClient {
    private var retrofit: Retrofit? = null

    private const val baseUrl = "https://suggestions.dadata.ru/suggestions/api/4_1/rs/suggest/"

    fun getClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}

