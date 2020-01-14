package com.chrynan.chords.view

class ChordViewBinder(private val view: ChordView) {

    fun bind(viewModel: com.chrynan.chords.model.ChordViewModel) {
        view.fretStart = viewModel.fretStart
        view.fretEnd = viewModel.fretEnd
        view.barLineColor = viewModel.barLineColor
        view.fretMarkerColor = viewModel.fretMarkerColor
        view.fretNumberColor = viewModel.fretNumberColor
        view.noteNumberColor = viewModel.noteNumberColor
        view.noteColor = viewModel.noteColor
        view.stringColor = viewModel.stringColor
        view.stringMarkerColor = viewModel.stringMarkerColor
        view.openStringText = viewModel.openStringText
        view.mutedText = viewModel.mutedText
        view.showFingerNumbers = viewModel.showFingerNumbers
        view.showFretNumbers = viewModel.showFretNumbers
        view.stringLabelState = viewModel.stringLabelState
        view.stringCount = viewModel.stringCount
    }
}