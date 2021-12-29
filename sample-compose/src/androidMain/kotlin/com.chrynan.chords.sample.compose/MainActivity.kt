package com.chrynan.chords.sample.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.chrynan.chords.model.Chord
import com.chrynan.chords.util.getChord
import com.chrynan.chords.util.putChord
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement

class MainActivity : AppCompatActivity() {

    @OptIn(ExperimentalUnsignedTypes::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = Bundle().apply {
            putChord("keyChord", chord)
        }

        val chord = bundle.getChord("keyChord")

        val jsonChord = Json.Default.encodeToJsonElement(chord)

        Json.Default.decodeFromJsonElement<Chord>(jsonChord)

        setContent {
            MainLayout()
        }
    }
}
