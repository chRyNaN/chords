package com.chrynan.chords.util

import com.chrynan.chords.model.ChordViewModel
import com.chrynan.chords.view.ChordViewBinder
import com.chrynan.chords.widget.ChordWidget

/**
 * This [ChordViewBinder.bind]s the provided [viewModel] to the [ChordViewBinder.view] and calls [ChordWidget.render]
 * if the underlying [ChordViewBinder.view] is an instance of [ChordWidget].
 *
 * @author chRyNaN
 */
fun ChordViewBinder.bindAndRender(viewModel: ChordViewModel) {
    bind(viewModel = viewModel)

    if (view is ChordWidget) view.render()
}