package com.chrynan.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chrynan.chords.model.*
import com.chrynan.chords.view.ChordViewBinder
import com.chrynan.chords.widget.ChordWidget
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chordWidget?.let {
            val binder = ChordViewBinder(it)
            val model = ChordViewModel(fretEnd = 3, fretNumberColor = ChordWidget.DEFAULT_COLOR,
                    barLineColor = ChordWidget.DEFAULT_COLOR, fretMarkerColor = ChordWidget.DEFAULT_COLOR,
                    noteColor = ChordWidget.DEFAULT_COLOR, noteNumberColor = ChordWidget.DEFAULT_TEXT_COLOR,
                    stringColor = ChordWidget.DEFAULT_COLOR, stringMarkerColor = ChordWidget.DEFAULT_COLOR)
            binder.bind(model)
        }

        val chord = chord(name = "G") {
            +ChordMarker.Note(
                    finger = Finger.MIDDLE,
                    fretNumber = FretNumber(number = 3),
                    string = ChordString(number = 6, label = "E"))

            +ChordMarker.Note(
                    finger = Finger.INDEX,
                    fretNumber = FretNumber(number = 2),
                    string = ChordString(number = 5, label = "A"))

            +ChordMarker.Open(string = ChordString(number = 4, label = "D"))

            +ChordMarker.Open(string = ChordString(number = 3, label = "G"))

            +ChordMarker.Note(
                    finger = Finger.RING,
                    fretNumber = FretNumber(number = 3),
                    string = ChordString(number = 2, label = "B"))

            +ChordMarker.Note(
                    finger = Finger.PINKY,
                    fretNumber = FretNumber(number = 3),
                    string = ChordString(number = 1, label = "e"))
        }

        chordWidget?.chord = chord
    }
}
