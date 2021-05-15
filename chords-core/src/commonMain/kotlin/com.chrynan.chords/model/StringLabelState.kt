@file:Suppress("unused")

package com.chrynan.chords.model

import com.chrynan.chords.view.ChordView
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An enum class defining the possible string label display states for a chord diagram, or
 * [ChordView]. The [SHOW_NUMBER] enum value indicates that the number of the string will be used
 * as a label. The [SHOW_LABEL] enum value indicates that the label of the string, provided by a
 * [StringLabel], will be used as a label if it is not null. The [HIDE] enum value indicates that
 * the string labels will not be shown. Refer to [StringLabel] for more information.
 *
 * @author chRyNaN
 */
@Serializable
enum class StringLabelState(val typeName: String) {

    @SerialName(value = "show_number")
    SHOW_NUMBER(typeName = "show_number"),

    @SerialName(value = "show_label")
    SHOW_LABEL(typeName = "show_label"),

    @SerialName(value = "hide")
    HIDE(typeName = "hide");

    companion object {

        fun fromTypeName(typeName: String, ignoreCase: Boolean = false): StringLabelState? =
            values().firstOrNull { it.typeName.equals(typeName, ignoreCase) }
    }
}
