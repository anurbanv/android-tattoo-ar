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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.anurban.android_tattoo_ar.app.feature.idea.new.NewIdeaScreenEvent.GoBackAction
import com.anurban.android_tattoo_ar.app.feature.idea.new.NewIdeaScreenEvent.SubmitIdeaAction
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun NewIdeaScreen(
    navigator: DestinationsNavigator,
) {
    NewIdeaScreenUi(
        eventListener = {
            when (it) {
                is NewIdeaScreenEvent.DescriptionChange -> {}
                GoBackAction -> navigator.popBackStack()
                SubmitIdeaAction -> {}
            }
        }
    )
}

@Composable
private fun NewIdeaScreenUi(
    eventListener: (NewIdeaScreenEvent) -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Select style")
        MyDropDownMenuBox()
        Text(text = "Describe your tattoo idea")
        TextField(
            value = "",
            onValueChange = { eventListener(NewIdeaScreenEvent.DescriptionChange(it)) },
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
}

@Preview
@Composable
private fun NewIdeaScreenPreview() {
    NewIdeaScreenUi()
}
