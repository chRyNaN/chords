package com.chrynan.chords.model.serializer

import com.chrynan.chords.model.*
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
import kotlinx.serialization.json.*

@OptIn(ExperimentalSerializationApi::class, InternalSerializationApi::class)
object ChordMarkerJsonSerializer : KSerializer<ChordMarker> {

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

    override fun deserialize(decoder: Decoder): ChordMarker {
        val jsonDecoder =
            decoder as? JsonDecoder ?: throw SerializationException("Expected Json Decoder for ${decoder}.")
        val jsonObject = jsonDecoder.decodeJsonElement().jsonObject

        val typeName = jsonObject.getValue("type").jsonPrimitive.content

        return when (MarkerType.fromTypeName(typeName, true)) {
            MarkerType.NOTE -> decodeNote(jsonObject)
            MarkerType.BAR -> decodeBar(jsonObject)
            MarkerType.OPEN -> decodeOpen(jsonObject)
            MarkerType.MUTED -> decodeMuted(jsonObject)
            null -> throw SerializationException("Invalid ChordMarker Marker Type.")
        }
    }

    private fun decodeNote(jsonObject: JsonObject): ChordMarker.Note {
        val fret = jsonObject.getFret("fret")
        val finger = jsonObject.getFinger("finger")
        val string = jsonObject.getString("string")

        return ChordMarker.Note(
            fret = fret,
            finger = finger,
            string = string
        )
    }

    private fun decodeBar(jsonObject: JsonObject): ChordMarker.Bar {
        val fret = jsonObject.getFret("fret")
        val finger = jsonObject.getFinger("finger")
        val startString = jsonObject.getString("start_string")
        val endString = jsonObject.getString("end_string")

        return ChordMarker.Bar(
            fret = fret,
            finger = finger,
            startString = startString,
            endString = endString
        )
    }

    private fun decodeOpen(jsonObject: JsonObject): ChordMarker.Open {
        val string =
            jsonObject["string"] ?: throw SerializationException("Expected 'string' property for ChordMarker.Open.")
        val stringNumber = StringNumber(string.jsonPrimitive.content.toInt())

        return ChordMarker.Open(string = stringNumber)
    }

    private fun decodeMuted(jsonObject: JsonObject): ChordMarker.Muted {
        val string =
            jsonObject["string"] ?: throw SerializationException("Expected 'string' property for ChordMarker.Muted.")
        val stringNumber = StringNumber(string.jsonPrimitive.content.toInt())

        return ChordMarker.Muted(string = stringNumber)
    }

    private fun JsonObject.getFret(propertyName: String): FretNumber {
        val property = get(propertyName)
            ?: throw SerializationException("Expected Fret property for ChordMarker with property name = $propertyName.")

        return when (property) {
            is JsonNull -> throw SerializationException("Invalid Fret for ChordMarker for property name = $propertyName. Fret must not be null.")
            is JsonPrimitive -> property.content.toIntOrNull()?.let { FretNumber(it) }
                ?: throw SerializationException("Invalid Fret for ChordMarker for property name = $propertyName. Fret must be a valid integer value.")
            is JsonObject -> {
                val number = property["number"]?.jsonPrimitive?.content?.toIntOrNull()
                    ?: throw SerializationException("Invalid Fret for ChordMarker for property name = $propertyName. Fret must be a valid integer value.")

                FretNumber(number = number)
            }
            else -> throw SerializationException("Invalid Fret type for ChordMarker for property name = $propertyName.")
        }
    }

    private fun JsonObject.getString(propertyName: String): StringNumber {
        val property = get(propertyName)
            ?: throw SerializationException("Expected String property for ChordMarker with property name = $propertyName.")

        return when (property) {
            is JsonNull -> throw SerializationException("Invalid String for ChordMarker for property name = $propertyName. String must not be null.")
            is JsonPrimitive -> property.content.toIntOrNull()?.let { StringNumber(it) }
                ?: throw SerializationException("Invalid String for ChordMarker for property name = $propertyName. String must be a valid integer value.")
            is JsonObject -> {
                val number = property["number"]?.jsonPrimitive?.content?.toIntOrNull()
                    ?: throw SerializationException("Invalid String for ChordMarker for property name = $propertyName. String must be a valid integer value.")

                StringNumber(number = number)
            }
            else -> throw SerializationException("Invalid String type for ChordMarker for property name = $propertyName.")
        }
    }

    private fun JsonObject.getFinger(propertyName: String): Finger {
        val property = get(propertyName)
            ?: throw SerializationException("Expected Finger property for ChordMarker with property name = $propertyName.")

        return when (property) {
            is JsonNull -> Finger.UNKNOWN
            is JsonPrimitive -> {
                val position = property.content.toIntOrNull()

                position?.let { Finger.fromPosition(position = it) } ?: Finger.fromFingerName(property.content, true)
            }
            is JsonObject -> {
                val position = property["position"]?.jsonPrimitive?.content?.toIntOrNull()
                val name = property["name"]?.jsonPrimitive?.content

                position?.let { Finger.fromPosition(position = it) } ?: name?.let { Finger.fromFingerName(it, true) }
                ?: Finger.UNKNOWN
            }
            else -> throw SerializationException("Unexpected Finger property for ChordMarker with property name = $propertyName and property = $property.")
        }
    }
}
