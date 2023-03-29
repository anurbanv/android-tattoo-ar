package com.anurban.android_tattoo_ar.app.feature.idea.new

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewIdeaViewModel @Inject constructor() : ViewModel() {

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
