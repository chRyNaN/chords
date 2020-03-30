package com.chrynan.chords.model

import com.chrynan.chords.view.ChordView

/**
 * An enum class defining the possible string label display states for a chord diagram, or
 * [ChordView]. The [SHOW_NUMBER] enum value indicates that the number of the string will be used
 * as a label. The [SHOW_LABEL] enum value indicates that the label of the string, provided by a
 * [StringLabel], will be used as a label if it is not null. The [HIDE] enum value indicates that
 * the string labels will not be shown. Refer to [StringLabel] for more information.
 *
 * @author chRyNaN
 */
enum class StringLabelState {

    SHOW_NUMBER,
    SHOW_LABEL,
    HIDE
}