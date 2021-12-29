@file:Suppress("unused")

package com.chrynan.chords.util

import com.chrynan.chords.model.ChordViewData
import com.chrynan.chords.view.ChordViewBinder
import com.chrynan.chords.widget.ChordWidget

/**
 * This [ChordViewBinder.bind]s the provided [viewModel] to the [ChordViewBinder.view] and calls [ChordWidget.render]
 * if the underlying [ChordViewBinder.view] is an instance of [ChordWidget].
 *
 * @author chRyNaN
 */
@ExperimentalUnsignedTypes
fun ChordViewBinder.bindAndRender(viewModel: ChordViewData) {
    bind(viewModel = viewModel)

    val v = view

    if (v is ChordWidget) v.render()
}
