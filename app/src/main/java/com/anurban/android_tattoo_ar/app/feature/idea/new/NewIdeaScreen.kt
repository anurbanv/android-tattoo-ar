@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.anurban.android_tattoo_ar.app.feature.idea.new

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.anurban.android_tattoo_ar.app.feature.destinations.IdeaDetailsScreenDestination
import com.anurban.android_tattoo_ar.app.feature.idea.new.NewIdeaScreenEvent.DescriptionChange
import com.anurban.android_tattoo_ar.app.feature.idea.new.NewIdeaScreenEvent.GoBackAction
import com.anurban.android_tattoo_ar.app.feature.idea.new.NewIdeaScreenEvent.StyleOptionSelected
import com.anurban.android_tattoo_ar.app.feature.idea.new.NewIdeaScreenEvent.SubmitIdeaAction
import com.anurban.android_tattoo_ar.app.feature.idea.new.NewIdeaScreenEvent.ToggleMenuExpand
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun NewIdeaScreen(
    navigator: DestinationsNavigator,
) {
    val viewModel: NewIdeaViewModel = hiltViewModel()

    val state = viewModel.state.observeAsState().value

    NewIdeaScreenUi(
        state = state,
        eventListener = {
            with(it) {
                when (this) {
                    is DescriptionChange -> viewModel.onDescriptionChanged(description)
                    GoBackAction -> navigator.popBackStack()
                    SubmitIdeaAction -> navigator.navigate(IdeaDetailsScreenDestination)
                    is ToggleMenuExpand -> viewModel.onDropDownMenuToggle(expanded)
                    is StyleOptionSelected -> viewModel.onStyleOptionSelected(optionId)
                }
            }
        },
    )
}

@Composable
private fun NewIdeaScreenUi(
    state: NewIdeaScreenState?,
    eventListener: (NewIdeaScreenEvent) -> Unit = {},
) {
    state ?: return

    val options = listOf(
        DropDownMenuOption(id = 1, text = "Style 1"),
        DropDownMenuOption(id = 2, text = "Style 2"),
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Select style")
        MyDropDownMenuBox(
            options = options,
            isExpanded = state.dropDownExpanded,
            selectedOption = options.find { it.id == state.selectedOptionId },
            onExpandChange = { eventListener(ToggleMenuExpand(it)) },
            onDismissRequest = { eventListener(ToggleMenuExpand(false)) },
            onOptionSelected = { eventListener(StyleOptionSelected(it)) },
        )
        Text(text = "Describe your tattoo idea")
        TextField(
            value = state.descriptionInput,
            onValueChange = { eventListener(DescriptionChange(it)) },
        )
        Button(onClick = { eventListener(SubmitIdeaAction) }) {
            Text(text = "Go AI")
        }
        Button(onClick = { eventListener(GoBackAction) }) {
            Text(text = "Go back")
        }
    }
}

sealed interface NewIdeaScreenEvent {
    object GoBackAction : NewIdeaScreenEvent
    object SubmitIdeaAction : NewIdeaScreenEvent
    data class DescriptionChange(val description: String) : NewIdeaScreenEvent
    data class ToggleMenuExpand(val expanded: Boolean) : NewIdeaScreenEvent
    data class StyleOptionSelected(val optionId: Int) : NewIdeaScreenEvent
}

data class NewIdeaScreenState(
    val selectedStyle: Int = 0,
    val descriptionInput: String = "",
    val dropDownExpanded: Boolean = false,
    val selectedOptionId: Int = 0,
)

@Preview
@Composable
private fun NewIdeaScreenPreview() {
    NewIdeaScreenUi(
        state = NewIdeaScreenState(),
    )
}
