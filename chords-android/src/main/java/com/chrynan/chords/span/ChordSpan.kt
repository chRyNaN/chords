package com.chrynan.chords.span

import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import com.chrynan.chords.model.Chord

/**
 * An implementation of [TouchableSpan] that retains a [Chord] and calls a [ChordSelectedListener]
 * with the [chord] when the touchable text is selected. This could be useful to use on the text in
 * a [TextView] to highlight the name of a [Chord]. Then when the [Chord] name is selected, the
 * [ChordSelectedListener.onChordSpanSelected] function will be called and that can open up the
 * [Chord] diagram.
 *
 * @property [chord] The [Chord] associated with this [ChordSpan].
 * @property [listener] The [ChordSelectedListener] to be called when the touchable text is selected.
 *
 * @author chRyNaN
 */
class ChordSpan(
    private val chord: Chord,
    private val listener: ChordSelectedListener,
    viewModel: TouchableSpanViewModel = TouchableSpanViewModel()
) : TouchableSpan() {

    init {
        this.viewModel = viewModel
    }

    override fun onTouch(widget: View, m: MotionEvent): Boolean {
        listener.onChordSpanSelected(chord)
        return false
    }

    /**
     * A listener interface when a [ChordSpan] text is selected. This allows the [Chord] to be
     * passed to the [onChordSpanSelected] function.
     *
     * @author chRyNaN
     */
    interface ChordSelectedListener {

        /**
         * This function will be called when the [ChordSpan] touchable text is selected.
         *
         * @param [chord] The [Chord] that is retained in the [ChordSpan].
         *
         * @author chRyNaN
         */
        fun onChordSpanSelected(chord: Chord)
    }
}
