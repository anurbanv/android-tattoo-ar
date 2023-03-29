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
}
