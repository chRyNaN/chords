package com.chrynan.chords.view

import com.chrynan.chords.model.ChordViewModel

/**
 * A class that can bind a [ChordViewModel] to a [ChordView] by calling the appropriate functions
 * with their related values.
 *
 * @property [view] The [ChordView] that will be updated with the values from the [ChordViewModel]
 * in the [bind] function.
 *
 * @author chRyNaN
 */
class ChordViewBinder(private val view: ChordView) {

    /**
     * Binds the [ChordViewModel] to the associated [ChordView] to this [ChordViewBinder] by
     * calling the appropriate [ChordView] functions with the values from the [ChordViewModel].
     * After this function is called, the [ChordView] should reflect the values from the
     * [ChordViewModel]. Note that there are some properties and functions that the [ChordView] may
     * have that are not present on the [ChordViewModel]. Only values present on the
     * [ChordViewModel] will be applied to the [ChordView].
     *
     * @author chRyNaN
     */
    fun bind(viewModel: ChordViewModel) {
        view.fitToHeight = viewModel.fitToHeight
        view.fretColor = viewModel.fretColor
        view.fretLabelTextColor = viewModel.fretLabelTextColor
        view.noteColor = viewModel.noteColor
        view.noteLabelTextColor = viewModel.noteLabelTextColor
        view.stringColor = viewModel.stringColor
        view.stringLabelTextColor = viewModel.stringLabelTextColor
        view.openStringText = viewModel.openStringText
        view.mutedStringText = viewModel.mutedStringText
        view.showFingerNumbers = viewModel.showFingerNumbers
        view.showFretNumbers = viewModel.showFretNumbers
        view.stringLabelState = viewModel.stringLabelState
    }
}