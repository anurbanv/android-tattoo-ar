package com.anurban.android_tattoo_ar.app.feature.idea.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.anurban.android_tattoo_ar.app.feature.idea.details.IdeaDetailsScreenEvent.ExportIdeaAction
import com.anurban.android_tattoo_ar.app.feature.idea.details.IdeaDetailsScreenEvent.GoBackAction
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun IdeaDetailsScreen(
    navigator: DestinationsNavigator,
) {
    IdeaDetailsScreenUi(
        eventListener = {
            when (it) {
                ExportIdeaAction -> {}
                GoBackAction -> navigator.popBackStack()
            }
        }
    )
}

@Composable
private fun IdeaDetailsScreenUi(
    eventListener: (IdeaDetailsScreenEvent) -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Style")
        Text(text = "Description")
        Image(
            modifier = Modifier
                .size(128.dp),
            painter = rememberAsyncImagePainter("https://i.pinimg.com/originals/f8/bc/0e/f8bc0eb1ad0c66f199ca17973c7d8f6a.jpg"),
            contentDescription = null,
        )
        Button(onClick = { eventListener(ExportIdeaAction) }) {
            Text(text = "export")
        }
        Button(onClick = { eventListener(GoBackAction) }) {
            Text(text = "Go back")
        }
    }
}

sealed interface IdeaDetailsScreenEvent {
    object GoBackAction : IdeaDetailsScreenEvent
    object ExportIdeaAction : IdeaDetailsScreenEvent
}

@Preview
@Composable
private fun IdeaDetailsScreenPreview() {
    IdeaDetailsScreenUi()
}
