package com.chrynan.chords.util

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import androidx.annotation.StyleableRes
import androidx.core.content.res.ResourcesCompat

/**
 * Retrieves a [Typeface] from this [TypedArray] for the provided [fontFamilyResId]. If the
 * provided [fontFamilyResId] is not found then the [defaultValue] will be returned. If no
 * [defaultValue] is provided and no [fontFamilyResId] is found, then null will be returned.
 *
 * @author chRyNaN
 */
fun TypedArray.getTypeface(
    context: Context,
    @StyleableRes fontFamilyResId: Int,
    defaultValue: Typeface? = null
): Typeface? =
    try {
        val resourceID = getResourceId(fontFamilyResId, 0)

        if (resourceID != 0) {
            ResourcesCompat.getFont(context, resourceID)
        } else {
            null
        }
    } catch (e: Exception) {
        Typeface.create(getString(fontFamilyResId), Typeface.NORMAL)
    } ?: defaultValue
