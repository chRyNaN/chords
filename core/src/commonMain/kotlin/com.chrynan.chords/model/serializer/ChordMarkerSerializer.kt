package com.chrynan.chords.model.serializer

import com.chrynan.chords.model.ChordMarker
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PolymorphicKind
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@OptIn(ExperimentalSerializationApi::class, InternalSerializationApi::class)
object ChordMarkerSerializer : KSerializer<ChordMarker> {

    override val descriptor: SerialDescriptor = buildSerialDescriptor("ChordMarker", PolymorphicKind.SEALED) {
        element<ChordMarker.Note>("Note")
        element<ChordMarker.Bar>("Bar")
        element<ChordMarker.Open>("Open")
        element<ChordMarker.Muted>("Muted")
    }

    override fun serialize(encoder: Encoder, value: ChordMarker) =
        when (value) {
            is ChordMarker.Note -> encoder.encodeSerializableValue(ChordMarker.Note.serializer(), value)
            is ChordMarker.Bar -> encoder.encodeSerializableValue(ChordMarker.Bar.serializer(), value)
            is ChordMarker.Open -> encoder.encodeSerializableValue(ChordMarker.Open.serializer(), value)
            is ChordMarker.Muted -> encoder.encodeSerializableValue(ChordMarker.Muted.serializer(), value)
        }

    // TODO fix the deserialization of this because this probably won't work since Open and Muted are very similar and
    // this doesn't take into account the type name.
    override fun deserialize(decoder: Decoder): ChordMarker =
        decodeNote(decoder) ?: decodeBar(decoder) ?: decodeOpen(decoder) ?: decodeMuted(decoder)
        ?: throw SerializationException("Invalid ChordMarker Marker Type.")

    private fun decodeNote(decoder: Decoder): ChordMarker.Note? = try {
        decoder.decodeSerializableValue(ChordMarker.Note.serializer())
    } catch (e: SerializationException) {
        null
    }

    private fun decodeBar(decoder: Decoder): ChordMarker.Bar? = try {
        decoder.decodeSerializableValue(ChordMarker.Bar.serializer())
    } catch (e: SerializationException) {
        null
    }

    private fun decodeOpen(decoder: Decoder): ChordMarker.Open? = try {
        decoder.decodeSerializableValue(ChordMarker.Open.serializer())
    } catch (e: SerializationException) {
        null
    }

    private fun decodeMuted(decoder: Decoder): ChordMarker.Muted? = try {
        decoder.decodeSerializableValue(ChordMarker.Muted.serializer())
    } catch (e: SerializationException) {
        null
    }
}
