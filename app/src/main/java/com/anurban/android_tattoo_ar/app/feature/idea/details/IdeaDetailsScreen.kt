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

@Composable
fun IdeaDetailsScreen(
    modifier: Modifier = Modifier,
    eventListener: () -> Unit = {},
) {
    Column(
        modifier = modifier.fillMaxSize(),
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
        Button(onClick = { eventListener() }) {
            Text(text = "export")
        }
    }
}

@Preview
@Composable
private fun IdeaDetailsScreenPreview() {
    IdeaDetailsScreen()
}
