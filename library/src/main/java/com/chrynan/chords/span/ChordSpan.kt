package com.chrynan.chords.span

import android.view.MotionEvent
import android.view.View
import com.chrynan.chords.model.Chord

class ChordSpan(
        private val chord: Chord,
        private val listener: SelectedListener
) : TouchableSpan() {

    override fun onTouch(widget: View, m: MotionEvent): Boolean {
        listener.onChordSpanSelected(chord)
        return false
    }

    interface SelectedListener {

        fun onChordSpanSelected(chord: Chord)
    }
}