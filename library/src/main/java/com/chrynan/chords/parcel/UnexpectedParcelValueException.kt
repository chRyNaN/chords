package com.chrynan.chords.parcel

class UnexpectedParcelValueException(private val value: Any?) : RuntimeException("Unexpected parcel value. value = $value")