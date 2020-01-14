# chords

![Screenshot](https://github.com/chRyNaN/GuitarChords/blob/master/app/src/main/res/drawable/screenshot.png)

An easily extensible and customizable native Android View to display guitar (and other stringed instruments) chords. 
Simple to use and beautifully designed.


**Defining `ChordWidget` in XML:**
```xml
<!-- Specify an exact size (MATCH_PARENT, MATCH_CONSTRAINTS, DP value) -->
<com.chrynan.guitarchords.widget.ChordWidget
    android:id="@+id/chordWidget"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```

**Creating a Chord using the DSL:**
```kotlin
val chord = chord(name = "G") {
    +ChordMarker.Note(
            finger = Finger.MIDDLE,
            fretNumber = FretNumber(number = 3),
            string = ChordString(number = 6, label = "E"))

    +ChordMarker.Note(
            finger = Finger.INDEX,
            fretNumber = FretNumber(number = 2),
            string = ChordString(number = 5, label = "A"))

    +ChordMarker.Open(string = ChordString(number = 4, label = "D"))

    +ChordMarker.Open(string = ChordString(number = 3, label = "G"))

    +ChordMarker.Note(
            finger = Finger.RING,
            fretNumber = FretNumber(number = 3),
            string = ChordString(number = 2, label = "B"))

    +ChordMarker.Note(
            finger = Finger.PINKY,
            fretNumber = FretNumber(number = 3),
            string = ChordString(number = 1, label = "e"))
}
```

**Applying a `Chord` to a `ChordWidget`:**
```kotlin
chordWidget?.chord = chord
```

**Parse ASCII Chord Diagrams:**
```
val chordDiagram = """
            C
    e |-----0------|
    B |-----1------|
    G |-----0------|
    D |-----2------|
    A |-----3------|
    E |------------|
""".trimIndent()

val parser = AsciiChordParser()

launch {
    // Parse is a suspending function and needs to be called from another suspending
    // function or a coroutine
    val chord = parser.parse(chordDiagram)
}
```
