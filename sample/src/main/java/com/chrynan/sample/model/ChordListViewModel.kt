package com.chrynan.sample.model

import com.chrynan.aaaah.asUniqueAdapterId

data class ChordListViewModel(
        val title: String,
        val items: List<ChordViewModel>
) : AdapterItemViewModel {

    override val uniqueAdapterId = "$title;$items".asUniqueAdapterId()
}