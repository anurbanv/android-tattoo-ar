package com.anurban.android_tattoo_ar.core.feature.idea

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class CurrentIdeaManager @Inject constructor(

) {
    private val mutableState = MutableLiveData(CurrentIdeaState())

    val state: LiveData<CurrentIdeaState> = mutableState

    fun setIdeaRequest(style: Int, description: String) {
        mutableState.value = mutableState.value?.copy(
            ideaStyle = style,
            ideaDescription = description,
        )
    }

    fun setIdeaResponse(imageUrl: String) {
        mutableState.value = mutableState.value?.copy(
            ideaImageUrl = imageUrl,
        )
    }
}

data class CurrentIdeaState(
    val ideaStyle: Int = 0,
    val ideaDescription: String = "",
    val ideaImageUrl: String? = null,
)
