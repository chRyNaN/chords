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
            val model = ChordViewModel(fretNumberColor = ChordWidget.DEFAULT_COLOR,
                    barLineColor = ChordWidget.DEFAULT_COLOR, fretMarkerColor = ChordWidget.DEFAULT_COLOR,
                    noteColor = ChordWidget.DEFAULT_COLOR, noteNumberColor = ChordWidget.DEFAULT_TEXT_COLOR,
                    stringColor = ChordWidget.DEFAULT_COLOR, stringMarkerColor = ChordWidget.DEFAULT_COLOR)
            binder.bind(model)
        }

        val chord = chord(name = "G") {
            +ChordMarker.Note(
                    finger = Finger.MIDDLE,
                    fret = FretNumber(3),
                    string = StringNumber(number = 6))

            +ChordMarker.Note(
                    finger = Finger.INDEX,
                    fret = FretNumber(2),
                    string = StringNumber(number = 5))

            +ChordMarker.Open(string = StringNumber(number = 4))

            +ChordMarker.Open(string = StringNumber(number = 3))

            +ChordMarker.Note(
                    finger = Finger.RING,
                    fret = FretNumber(3),
                    string = StringNumber(number = 2))

            +ChordMarker.Note(
                    finger = Finger.PINKY,
                    fret = FretNumber(3),
                    string = StringNumber(number = 1))
        }

        chordWidget?.chord = chord
    }
}
