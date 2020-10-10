package com.chrynan.chords.model.serializer

import com.chrynan.chords.model.StringNumber
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object StringNumberSerializer : KSerializer<StringNumber> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("number", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: StringNumber) {
        encoder.encodeInt(value.number)
    }

    override fun deserialize(decoder: Decoder): StringNumber {
        val number = decoder.decodeInt()

        return StringNumber(number = number)
    }
}
