package com.chrynan.chords.model

enum class MarkerType(val typeName: String) {

    NOTE(typeName = "note"),
    BAR(typeName = "bar"),
    OPEN(typeName = "open"),
    MUTED(typeName = "muted");

    companion object {

        fun fromTypeName(name: String) = values().firstOrNull { it.typeName == name }
    }
}