package com.chrynan.chords.util

import android.text.Spannable
import android.text.SpannableString
import com.chrynan.chords.model.Chord
import com.chrynan.chords.span.ChordSpan
import com.chrynan.chords.span.TouchableSpan
import com.chrynan.chords.span.TouchableSpanView

fun chordSpan(chord: Chord, listener: ChordSpan.ChordSelectedListener): SpannableString {
    val spannable = SpannableString(chord.name)
    val chordSpan = ChordSpan(chord = chord, listener = listener)

    spannable.setSpan(chordSpan, 0, chord.name?.length ?: 0, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

    return spannable
}

fun chordSpan(text: String, chord: Chord, listener: ChordSpan.ChordSelectedListener): SpannableString {
    val spannable = SpannableString(text)
    val chordSpan = ChordSpan(chord = chord, listener = listener)

    spannable.setSpan(chordSpan, 0, text.length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

    return spannable
}

fun chordSpan(chord: Chord, listener: (Chord) -> Unit): SpannableString {
    val spannable = SpannableString(chord.name)
    val chordSpan = ChordSpan(chord = chord, listener = object : ChordSpan.ChordSelectedListener {
        override fun onChordSpanSelected(chord: Chord) {
            listener.invoke(chord)
        }
    })

    spannable.setSpan(chordSpan, 0, chord.name?.length ?: 0, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

    return spannable
}

fun chordSpan(text: String, chord: Chord, listener: (Chord) -> Unit): SpannableString {
    val spannable = SpannableString(text)
    val chordSpan = ChordSpan(chord = chord, listener = object : ChordSpan.ChordSelectedListener {
        override fun onChordSpanSelected(chord: Chord) {
            listener.invoke(chord)
        }
    })

    spannable.setSpan(chordSpan, 0, text.length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

    return spannable
}

fun styledChordSpan(chord: Chord, listener: ChordSpan.ChordSelectedListener, styleBuilder: TouchableSpanView.() -> Unit): SpannableString {
    val spannable = SpannableString(chord.name)
    val chordSpan = ChordSpan(chord = chord, listener = listener)
    styleBuilder.invoke(chordSpan)

    spannable.setSpan(chordSpan, 0, chord.name?.length ?: 0, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

    return spannable
}

fun styledChordSpan(text: String, chord: Chord, listener: ChordSpan.ChordSelectedListener, styleBuilder: TouchableSpanView.() -> Unit): SpannableString {
    val spannable = SpannableString(text)
    val chordSpan = ChordSpan(chord = chord, listener = listener)
    styleBuilder.invoke(chordSpan)

    spannable.setSpan(chordSpan, 0, text.length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

    return spannable
}

fun chordSpanWithDrawState(chord: Chord, listener: ChordSpan.ChordSelectedListener, drawStateListener: TouchableSpan.DrawStateListener): SpannableString {
    val spannable = SpannableString(chord.name)
    val chordSpan = ChordSpan(chord = chord, listener = listener)
    chordSpan.drawStateListener = drawStateListener

    spannable.setSpan(chordSpan, 0, chord.name?.length ?: 0, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

    return spannable
}

fun chordSpanWithDrawState(text: String, chord: Chord, listener: ChordSpan.ChordSelectedListener, drawStateListener: TouchableSpan.DrawStateListener): SpannableString {
    val spannable = SpannableString(text)
    val chordSpan = ChordSpan(chord = chord, listener = listener)
    chordSpan.drawStateListener = drawStateListener

    spannable.setSpan(chordSpan, 0, text.length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

    return spannable
}
