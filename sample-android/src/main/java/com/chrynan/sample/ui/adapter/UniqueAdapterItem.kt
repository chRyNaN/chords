package com.chrynan.sample.ui.adapter

typealias AdapterId = Long

interface UniqueAdapterItem {

    val uniqueAdapterId: AdapterId
}

inline fun <reified T : Any> T.asUniqueAdapterId(): AdapterId = hashCode().toLong()
