package com.chrynan.chords.model.serializer

import com.chrynan.chords.model.FretNumber
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object FretNumberSerializer : KSerializer<FretNumber> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("number", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: FretNumber) {
        encoder.encodeInt(value.number)
    }

    override fun deserialize(decoder: Decoder): FretNumber {
        val number = decoder.decodeInt()

        return FretNumber(number = number)
    }
}
