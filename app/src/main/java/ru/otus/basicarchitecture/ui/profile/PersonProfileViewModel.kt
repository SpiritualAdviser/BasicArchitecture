package ru.otus.basicarchitecture.ui.profile

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.otus.basicarchitecture.ui.data.WizardCache
import javax.inject.Inject

@HiltViewModel
class PersonProfileViewModel @Inject constructor(
    private var wizardCache: WizardCache

) : ViewModel() {

    var personName: String = wizardCache.personName
    var personSurname: String = wizardCache.personSurname
    var personBirthDate: String = wizardCache.personBirthDate

    var personCountry: String = wizardCache.personCountry
    var personCity: String = wizardCache.personCity
    var personAddress: String = wizardCache.personAddress

    var hobby_sports: String = wizardCache.hobby_sports
    var hobby_сreative: String = wizardCache.hobby_сreative
    var hobby_intelligence: String = wizardCache.hobby_intelligence

    // TODO: Implement the ViewModel
}