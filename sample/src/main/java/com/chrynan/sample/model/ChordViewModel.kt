package com.chrynan.sample.model

import com.chrynan.aaaah.asUniqueAdapterId
import com.chrynan.chords.model.Chord

data class ChordViewModel(
        val title: String,
        val description: String? = null,
        val chord: Chord
) : AdapterItemViewModel {

    override val uniqueAdapterId = "$title;$chord".asUniqueAdapterId()
}