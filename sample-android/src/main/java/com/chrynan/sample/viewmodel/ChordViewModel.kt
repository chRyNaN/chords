package com.chrynan.sample.viewmodel

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chords.model.Chord
import com.chrynan.sample.viewmodel.AdapterItemViewModel

data class ChordViewModel(
        val title: String,
        val description: String? = null,
        val chord: Chord
) : AdapterItemViewModel {

    override val uniqueAdapterId = "$title;$chord".asUniqueAdapterId()
}