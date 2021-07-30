package com.chrynan.chords.sample.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.chrynan.chords.compose.ChordWidget

@OptIn(ExperimentalUnsignedTypes::class)
@Composable
fun MainLayout() {
    MaterialTheme(colors = colors) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            ChordWidget(
                modifier = Modifier
                    .size(width = 200.dp, height = 200.dp)
                    .align(Alignment.Center),
                chord = chord,
                chart = chordChart,
                viewModel = chordViewModel
            )
        }
    }
}
