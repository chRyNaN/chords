package com.chrynan.chords.sample.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Modifier

@Composable
fun ChordList(
    title: String,
    chords: List<ChordViewModel>
) {
    Column {
        Text(text = title)

        LazyRow {
            items(items = chords) { item ->
                ChordNameCard(
                    name = item.title,
                    secondary = item.description ?: "",
                    onClick = {}
                )
            }
        }
    }
}
