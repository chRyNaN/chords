@file:Suppress("unused")

package com.chrynan.chords.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An enum containing the different types of a [ChordMarker]. This is useful for defining the
 * finite [ChordMarker]s and for serializing and de-serializing a [ChordMarker] from different
 * formats, such as JSON.
 *
 * @property [typeName] The name of this [MarkerType].
 *
 * @author chRyNaN
 */
@Serializable
enum class MarkerType(@SerialName(value = "name") val typeName: String) {

    NOTE(typeName = "note"),
    BAR(typeName = "bar"),
    OPEN(typeName = "open"),
    MUTED(typeName = "muted");

    companion object {

        /**
         * Retrieves a [MarkerType] from the provided [name] by finding a matching [typeName]. If
         * none are found, then null will be returned.
         *
         * @author chRyNaN
         */
        fun fromTypeName(name: String, ignoreCase: Boolean = false) = values().firstOrNull {
            it.typeName.equals(name, ignoreCase = ignoreCase)
        }
    }
}
