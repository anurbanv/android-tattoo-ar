package com.anurban.android_tattoo_ar.app.feature.idea.new

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.anurban.android_tattoo_ar.core.feature.idea.CurrentIdeaManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewIdeaViewModel @Inject constructor(
    private val currentIdeaManager: CurrentIdeaManager,
) : ViewModel() {

    private val mutableState = MediatorLiveData<NewIdeaScreenState>().apply {
        value = NewIdeaScreenState()
    }

    val state: LiveData<NewIdeaScreenState> = mutableState

    fun onDescriptionChanged(description: String) {
        mutableState.value = mutableState.value?.copy(
            descriptionInput = description,
        )
    }

    fun onDropDownMenuToggle(expanded: Boolean) {
        mutableState.value = mutableState.value?.copy(
            dropDownExpanded = expanded,
        )
    }

    fun onStyleOptionSelected(optionId: Int) {
        mutableState.value = mutableState.value?.copy(
            selectedOptionId = optionId,
            dropDownExpanded = false,
        )
    }

    fun onSubmitIdeaClick() {
        val state = mutableState.value ?: return

        currentIdeaManager.setIdeaRequest(
            style = state.selectedStyle,
            description = state.descriptionInput,
        )

        mutableState.value = mutableState.value?.copy(
            navigateToDetailsScreen = true,
        )
    }

    fun cancelNavigationRequest() {
        mutableState.value = mutableState.value?.copy(
            navigateToDetailsScreen = false,
        )
    }
}
