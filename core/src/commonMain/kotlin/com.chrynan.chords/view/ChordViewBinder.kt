package com.chrynan.chords.view

import com.chrynan.chords.model.ChordViewModel

class ChordViewBinder(private val view: ChordView) {

    fun bind(viewModel: ChordViewModel) {
        view.fitToHeight = viewModel.fitToHeight
        view.fretColor = viewModel.fretColor
        view.fretLabelTextColor = viewModel.fretLabelTextColor
        view.noteColor = viewModel.noteColor
        view.noteLabelTextColor = viewModel.noteLabelTextColor
        view.stringColor = viewModel.stringColor
        view.stringLabelTextColor = viewModel.stringLabelTextColor
        view.openStringText = viewModel.openStringText
        view.mutedStringText = viewModel.mutedText
        view.showFingerNumbers = viewModel.showFingerNumbers
        view.showFretNumbers = viewModel.showFretNumbers
        view.stringLabelState = viewModel.stringLabelState
    }
}