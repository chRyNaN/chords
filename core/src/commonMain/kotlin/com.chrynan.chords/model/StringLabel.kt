package com.chrynan.chords.model

/**
 * A model containing information about a label for a string in a chord diagram. This model
 * contains the [string] the label should be displayed for and an optional [label] for that string.
 * Chord diagrams may choose to either display this label, if it is not null, display the [string]
 * number, or display no label indicator. Refer to [StringLabelState].
 *
 * @property [string] The [StringNumber] that this label should be displayed for.
 * @property [label] The optional label that should be displayed for this string.
 *
 * @author chRyNaN
 */
data class StringLabel(
        val string: StringNumber,
        val label: String? = null
)