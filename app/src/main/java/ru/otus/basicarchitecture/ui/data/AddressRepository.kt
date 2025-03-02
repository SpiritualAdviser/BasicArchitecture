package ru.otus.basicarchitecture.ui.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AddressRepository @Inject constructor() {

    private val apiService = RetrofitClient.getClient().create(AddressIP::class.java)

    suspend fun getDataNotice(dataModal: AddressData) {
        apiService.postData(
            dataModal = dataModal
        )
    }
}