package com.chrynan.chords.span

import android.text.SpannableString
import android.text.SpannableStringBuilder

class SpannableStringBuilderDsl internal constructor() {

    private val spannableStringBuilder = SpannableStringBuilder()

    operator fun SpannableString.unaryPlus(): SpannableString {
        spannableStringBuilder.append(this)
        return this
    }

    internal fun build(): SpannableStringBuilder = spannableStringBuilder
}

fun buildSpannableString(builderAction: SpannableStringBuilderDsl.() -> Unit): SpannableStringBuilder =
        SpannableStringBuilderDsl().apply(builderAction).build()