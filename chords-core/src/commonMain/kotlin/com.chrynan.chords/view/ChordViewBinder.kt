package com.chrynan.chords.view

import com.chrynan.chords.model.ChordViewData

/**
 * A class that can bind a [ChordViewData] to a [ChordView] by calling the appropriate functions
 * with their related values.
 *
 * @property [view] The [ChordView] that will be updated with the values from the [ChordViewData]
 * in the [bind] function.
 *
 * @author chRyNaN
 */
@ExperimentalUnsignedTypes
class ChordViewBinder(val view: ChordView) {

    /**
     * Binds the [ChordViewData] to the associated [ChordView] to this [ChordViewBinder] by
     * calling the appropriate [ChordView] functions with the values from the [ChordViewData].
     * After this function is called, the [ChordView] should reflect the values from the
     * [ChordViewData]. Note that there are some properties and functions that the [ChordView] may
     * have that are not present on the [ChordViewData]. Only values present on the
     * [ChordViewData] will be applied to the [ChordView].
     *
     * @author chRyNaN
     */
    fun bind(viewModel: ChordViewData) {
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
