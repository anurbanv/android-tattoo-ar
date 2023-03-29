package com.anurban.android_tattoo_ar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.anurban.android_tattoo_ar.app.feature.NavGraphs
import com.anurban.android_tattoo_ar.ui.theme.AndroidtattooarTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidtattooarTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}
