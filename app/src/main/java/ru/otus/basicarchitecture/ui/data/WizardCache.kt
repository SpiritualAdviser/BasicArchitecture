package ru.otus.basicarchitecture.ui.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WizardCache @Inject constructor() {

    var personName: String = ""
    var personSurname: String = ""
    var personBirthDate: String = ""

    var personCountry: String = ""
    var personCity: String = ""
    var personAddress: String = ""

    var hobby_sports: String = ""
    var hobby_сreative: String = ""
    var hobby_intelligence: String = ""
}