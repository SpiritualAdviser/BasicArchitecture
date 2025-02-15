package ru.otus.basicarchitecture.ui.interests

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.otus.basicarchitecture.ui.data.WizardCache
import javax.inject.Inject

@HiltViewModel
class InterestsViewModel @Inject constructor(
    private var wizardCache: WizardCache
) : ViewModel() {
    fun setSports(hobby: String) {
        wizardCache.hobby_sports = hobby
    }

    fun setCreative(hobby: String) {
        wizardCache.hobby_сreative = hobby
    }

    fun setIntelligence(hobby: String) {
        wizardCache.hobby_intelligence = hobby
    }
}