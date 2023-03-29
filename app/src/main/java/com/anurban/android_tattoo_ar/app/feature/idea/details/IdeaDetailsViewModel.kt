package com.anurban.android_tattoo_ar.app.feature.idea.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.anurban.android_tattoo_ar.core.data.database.entity.Idea
import com.anurban.android_tattoo_ar.core.feature.idea.CurrentIdeaManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IdeaDetailsViewModel @Inject constructor(
    currentIdeaManager: CurrentIdeaManager,
) : ViewModel() {

    private val mutableState = MediatorLiveData<IdeaDetailsScreenState>().apply { 
        value = IdeaDetailsScreenState()
    }
    
    val state: LiveData<IdeaDetailsScreenState> = mutableState
    
    init {
        mutableState.addSource(currentIdeaManager.state) {
            mutableState.value = mutableState.value?.copy(
                idea = Idea(
                    style = it.ideaStyle,
                    description = it.ideaDescription,
                )
            )
        }
    }
}

data class IdeaDetailsScreenState(
    val idea: Idea = Idea(),
)
