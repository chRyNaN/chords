package com.chrynan.chords.util

import android.text.Spannable
import android.text.SpannableString
import com.chrynan.chords.model.Chord
import com.chrynan.chords.span.ChordSpan
import com.chrynan.chords.span.TouchableSpanViewModel

fun chordSpan(
    chord: Chord,
    viewModel: TouchableSpanViewModel = TouchableSpanViewModel(),
    listener: ChordSpan.ChordSelectedListener
): SpannableString {
    val spannable = SpannableString(chord.name)
    val chordSpan = ChordSpan(chord = chord, viewModel = viewModel, listener = listener)

    spannable.setSpan(chordSpan, 0, chord.name?.length ?: 0, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

    return spannable
}

fun chordSpan(
    text: String,
    chord: Chord,
    viewModel: TouchableSpanViewModel = TouchableSpanViewModel(),
    listener: ChordSpan.ChordSelectedListener
): SpannableString {
    val spannable = SpannableString(text)
    val chordSpan = ChordSpan(chord = chord, viewModel = viewModel, listener = listener)

    spannable.setSpan(chordSpan, 0, text.length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

    return spannable
}

fun chordSpan(
    chord: Chord,
    viewModel: TouchableSpanViewModel = TouchableSpanViewModel(),
    listener: (Chord) -> Unit
): SpannableString {
    val spannable = SpannableString(chord.name)
    val chordSpan =
        ChordSpan(chord = chord, viewModel = viewModel, listener = object : ChordSpan.ChordSelectedListener {
            override fun onChordSpanSelected(chord: Chord) {
                listener.invoke(chord)
            }
        })

    spannable.setSpan(chordSpan, 0, chord.name?.length ?: 0, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

    return spannable
}

fun chordSpan(
    text: String,
    chord: Chord,
    viewModel: TouchableSpanViewModel = TouchableSpanViewModel(),
    listener: (Chord) -> Unit
): SpannableString {
    val spannable = SpannableString(text)
    val chordSpan =
        ChordSpan(chord = chord, viewModel = viewModel, listener = object : ChordSpan.ChordSelectedListener {
            override fun onChordSpanSelected(chord: Chord) {
                listener.invoke(chord)
            }
        })

    spannable.setSpan(chordSpan, 0, text.length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

    return spannable
}
