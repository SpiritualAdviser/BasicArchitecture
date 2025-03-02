package ru.otus.basicarchitecture.ui.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AddressData @Inject constructor() {
    var personAddress: String = ""
}