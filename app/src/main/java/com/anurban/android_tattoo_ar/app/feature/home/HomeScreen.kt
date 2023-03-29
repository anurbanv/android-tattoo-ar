package com.anurban.android_tattoo_ar.app.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.anurban.android_tattoo_ar.app.feature.destinations.MyIdeasScreenDestination
import com.anurban.android_tattoo_ar.app.feature.destinations.NewIdeaScreenDestination
import com.anurban.android_tattoo_ar.app.feature.home.HomeScreenEvent.MySavedIdeasActions
import com.anurban.android_tattoo_ar.app.feature.home.HomeScreenEvent.NewIdeaAction
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination(start = true)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator,
) {
    HomeScreenUi(
        eventListener = {
            when (it) {
                MySavedIdeasActions -> navigator.navigate(MyIdeasScreenDestination)
                NewIdeaAction -> navigator.navigate(NewIdeaScreenDestination)
            }
        }
    )
}

@Composable
private fun HomeScreenUi(
    eventListener: (HomeScreenEvent) -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Welcome"
        )
        Button(onClick = { eventListener(NewIdeaAction) }) {
            Text(
                text = "New tattoo idea"
            )
        }
        Button(onClick = { eventListener(MySavedIdeasActions) }) {
            Text(
                text = "My saved tattoo ideas"
            )
        }
    }
}

sealed interface HomeScreenEvent {
    object NewIdeaAction : HomeScreenEvent
    object MySavedIdeasActions : HomeScreenEvent
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreenUi()
}
