package com.chrynan.chords.sample.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chrynan.chords.compose.ChordWidget
import com.chrynan.chords.model.*

class MainActivity : AppCompatActivity() {

    @OptIn(ExperimentalUnsignedTypes::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val chord = chord(name = "D Major") {
                +ChordMarker.Muted(string = StringNumber(6))
                +ChordMarker.Muted(string = StringNumber(5))
                +ChordMarker.Open(string = StringNumber(4))
                +ChordMarker.Note(
                    fret = FretNumber(2),
                    finger = Finger.INDEX,
                    string = StringNumber(3)
                )
                +ChordMarker.Note(
                    fret = FretNumber(3),
                    finger = Finger.RING,
                    string = StringNumber(2)
                )
                +ChordMarker.Note(
                    fret = FretNumber(2),
                    finger = Finger.MIDDLE,
                    string = StringNumber(1)
                )
            }

            ChordWidget(
                modifier = Modifier.size(width = 200.dp, height = 200.dp),
                chord = chord,
                chart = ChordChart.STANDARD_TUNING_GUITAR_CHART,
                viewModel = ChordViewModel(
                    showFingerNumbers = true,
                    showFretNumbers = true,
                    stringLabelState = StringLabelState.SHOW_LABEL
                )
            )
        }
    }
}
