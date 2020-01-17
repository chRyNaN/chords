package com.chrynan.sample

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import androidx.appcompat.app.AppCompatActivity
import com.chrynan.chords.model.*
import com.chrynan.chords.span.ChordSpan
import com.chrynan.chords.span.LinkTouchMovementMethod
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
        ChordSpan.SelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chord = chord("G") {
            +ChordMarker.Note(
                    fret = FretNumber(3),
                    finger = Finger.MIDDLE,
                    string = StringNumber(6)
            )
            +ChordMarker.Note(
                    fret = FretNumber(2),
                    finger = Finger.INDEX,
                    string = StringNumber(5)
            )
            +ChordMarker.Open(string = StringNumber(4))
            +ChordMarker.Open(string = StringNumber(3))
            +ChordMarker.Note(
                    fret = FretNumber(3),
                    finger = Finger.RING,
                    string = StringNumber(2)
            )
            +ChordMarker.Note(
                    fret = FretNumber(3),
                    finger = Finger.PINKY,
                    string = StringNumber(1)
            )
        }

        val text = SpannableString("G")
        val span = ChordSpan(chord, this)
        text.setSpan(span, 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        songTextView?.text = text
        songTextView?.movementMethod = LinkTouchMovementMethod()
    }

    override fun onChordSpanSelected(chord: Chord) {
        val labels = setOf(
                StringLabel(string = 1, label = "e"),
                StringLabel(string = 2, label = "B"),
                StringLabel(string = 3, label = "G"),
                StringLabel(string = 4, label = "D"),
                StringLabel(string = 5, label = "A"),
                StringLabel(string = 6, label = "E")
        )
        val chart = ChordChart(stringLabels = labels)
        ChordBottomSheetDialogFragment.newInstance(chord, chart)
                .show(supportFragmentManager, null)
    }
}
