@file:Suppress("unused")

package com.chrynan.chords.android.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.chrynan.chords.model.Chord
import com.chrynan.chords.model.ChordChart
import com.chrynan.chords.model.ChordViewModel
import com.chrynan.chords.view.ChordViewBinder

@ExperimentalUnsignedTypes
@Composable
fun ChordWidget(
    modifier: Modifier = Modifier,
    chord: Chord? = null,
    chart: ChordChart = ChordChart.STANDARD_TUNING_GUITAR_CHART,
    viewModel: ChordViewModel = ChordViewModel()
) {
    AndroidView(
        factory = { com.chrynan.chords.widget.ChordWidget(context = it) },
        modifier = modifier,
        update = { widget ->
            val binder = ChordViewBinder(widget)

            widget.chord = chord
            widget.chart = chart

            binder.bind(viewModel)
        }
    )
}
