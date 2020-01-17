package com.chrynan.chords.view

import com.chrynan.chords.model.ChordViewModel

class ChordViewBinder(private val view: ChordView) {

    fun bind(viewModel: ChordViewModel) {
        view.fitToHeight = viewModel.fitToHeight
        view.fretColor = viewModel.fretMarkerColor
        view.fretLabelTextColor = viewModel.fretNumberColor
        view.noteLabelTextColor = viewModel.noteNumberColor
        view.noteColor = viewModel.noteColor
        view.stringColor = viewModel.stringColor
        view.stringLabelTextColor = viewModel.stringMarkerColor
        view.openStringText = viewModel.openStringText
        view.mutedStringText = viewModel.mutedText
        view.showFingerNumbers = viewModel.showFingerNumbers
        view.showFretNumbers = viewModel.showFretNumbers
        view.stringLabelState = viewModel.stringLabelState
    }
}