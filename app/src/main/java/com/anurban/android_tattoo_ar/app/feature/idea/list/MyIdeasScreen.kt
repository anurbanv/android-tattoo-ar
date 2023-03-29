package com.anurban.android_tattoo_ar.app.feature.idea.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun MyIdeasScreen(
    navigator: DestinationsNavigator,
) {
    val viewModel: MyIdeasViewModel = hiltViewModel()

    MyIdeasScreenUi(
        eventListener = {
            when (it) {
                MyIdeasScreenEvent.GoBackAction -> navigator.popBackStack()
            }
        }
    )
}

@Composable
private fun MyIdeasScreenUi(
    eventListener: (MyIdeasScreenEvent) -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "My Ideas")

        Button(onClick = { eventListener(MyIdeasScreenEvent.GoBackAction) }) {
            Text(text = "Go back")
        }
    }
}

sealed interface MyIdeasScreenEvent {
    object GoBackAction : MyIdeasScreenEvent
}

class MyIdeasScreenState {

}

@Preview
@Composable
private fun MyIdeasScreenPreview() {
    MyIdeasScreenUi()
}
