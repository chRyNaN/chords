package com.chrynan.chords.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.json.JsonClassDiscriminator

/**
 * A sealed class containing all the different markers that can be in a [Chord]. A chord marker is
 * a visual indicator of what note(s) should be played. A set of chord markers makes up a Chord.
 *
 * Note that a [ChordMarker] does not contain any information about the frequency of a note but
 * instead contains positional information about a note, or notes, on a visual diagram.
 *
 * @author chRyNaN
 */
@Serializable
@JsonClassDiscriminator("typeName")
@OptIn(ExperimentalSerializationApi::class)
sealed class ChordMarker {

    /**
     * The [MarkerType] of this [ChordMarker]. This is useful for parsing.
     *
     * @author chRyNaN
     */
    @SerialName(value = "type")
    abstract val type: MarkerType

    /**
     * A [ChordMarker] representing a single note that is not an open string.
     *
     * @property [fret] The [FretNumber] of this note.
     * @property [finger] The [Finger] used to play this note.
     * @property [string] The [StringNumber] of this note.
     *
     * @author chRyNaN
     */
    @Serializable
    @SerialName(value = "note")
    data class Note(
        @SerialName(value = "fret") override val fret: FretNumber,
        @SerialName(value = "finger") override val finger: Finger = Finger.UNKNOWN,
        @SerialName(value = "string") override val string: StringNumber
    ) : ChordMarker(),
        FretMarker,
        FingerMarker,
        StringMarker {

        override val type = MarkerType.NOTE
    }

    /**
     * A [ChordMarker] representing multiple notes spanning across multiple strings on a single
     * fret.
     *
     * @property [fret] The [FretNumber] of the notes in this bar.
     * @property [finger] The finger used to bar these notes.
     * @property [startString] The [StringNumber] of the first string this bar starts.
     * @property [endString] The [StringNumber] of the last string this bar ends.
     *
     * @author chRyNaN
     */
    @Serializable
    @SerialName(value = "bar")
    data class Bar(
        @SerialName(value = "fret") override val fret: FretNumber,
        @SerialName(value = "finger") override val finger: Finger = Finger.UNKNOWN,
        @SerialName(value = "start_string") override val startString: StringNumber,
        @SerialName(value = "end_string") override val endString: StringNumber
    ) : ChordMarker(),
        FretMarker,
        FingerMarker,
        StringRangeMarker {

        override val type = MarkerType.BAR

        @Transient
        override val string = startString
    }

    /**
     * A [ChordMarker] representing a single open note.
     *
     * @property [string] The [StringNumber] of this open note.
     *
     * @author chRyNaN
     */
    @Serializable
    @SerialName(value = "open")
    data class Open(
        @SerialName(value = "string") override val string: StringNumber
    ) : ChordMarker(),
        FretMarker,
        StringMarker {

        override val type = MarkerType.OPEN

        @Transient
        override val fret: FretNumber = FretNumber(0)
    }

    /**
     * A [StringMarker] representing a muted, or un-played, string.
     *
     * @property [string] The [StringNumber] of the muted string.
     *
     * @author chRyNaN
     */
    @Serializable
    @SerialName(value = "muted")
    data class Muted(
        @SerialName(value = "string") override val string: StringNumber
    ) : ChordMarker(),
        StringMarker {

        override val type = MarkerType.MUTED
    }

    companion object
}
