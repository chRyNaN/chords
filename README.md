# chords

An easily customizable native Android View to display guitar (and other stringed instruments) chords. 
Simple to use and beautifully designed.

<img alt="Sample Screenshot" src="https://github.com/chRyNaN/chords/blob/master/sample/screenshots/device-2020-01-18-180759.png" width="300"></img>
<img alt="Sample Screenshot" src="https://github.com/chRyNaN/chords/blob/master/sample/screenshots/device-2020-01-18-183742.png" width="300"></img>

This library has been updated significantly from it's original version and the process is detailed in this [blog post](https://chrynan.codes/converting-an-old-java-library-to-kotlin/).

## Building the library
The library is provided through [Bintray](https://bintray.com/). Checkout the [releases](https://github.com/chRyNaN/chords/releases) page to get the latest version.

### Repository
```kotlin
repositories {
    maven {
        url = uri("https://dl.bintray.com/chrynan/chrynan")
    }
}
```

### Dependencies
**Core Kotlin Common:**
```kotlin
implementation("com.chrynan.chords:chords-core:VERSION")
```

**Core Kotlin JVM:**
```kotlin
implementation("com.chrynan.chords:chords-core-jvm:VERSION")
```

**Android Library:**
```kotlin
implementation("com.chrynan.chords:chords-android:VERSION")
```

## Using the library
There are a few main components to using the library:

* `ChordWidget` is the Android View that displays the chord.
* `ChordChart` is a class that represents information about the chord chart that will be displayed.
* `Chord` is a class that represents the markers on a chord that will be displayed.

**Defining `ChordWidget` in XML:**
```xml
<!-- Specify an exact size (MATCH_PARENT, MATCH_CONSTRAINTS, DP value). -->
<com.chrynan.chords.widget.ChordWidget
    android:id="@+id/chordWidget"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```

**Assigning a `ChordChart` to a `ChordWidget`:**
```kotlin
chordWidget?.chart = ChordChart(
                         fretStart = 1,
                         fretEnd = 2,
                         stringCount = 6,
                         stringLabels = setOf(
                             StringLabel(string = 1, label = "e"),
                             StringLabel(string = 2, label = "B"),
                             StringLabel(string = 3, label = "G"),
                             StringLabel(string = 4, label = "D"),
                             StringLabel(string = 5, label = "A"),
                             StringLabel(string = 6, label = "E")))
```

**Creating a Chord using the DSL:**
```kotlin
val chord = chord("G") {
            +ChordMarker.Note(
                    fret = FretNumber(3),
                    finger = Finger.MIDDLE,
                    string = StringNumber(6)
            )
            +ChordMarker.Note(
                    fret = FretNumber(2),
                    finger = Finger.INDEX,
                    string = StringNumber(5)
            )
            +ChordMarker.Open(string = StringNumber(4))
            +ChordMarker.Open(string = StringNumber(3))
            +ChordMarker.Note(
                    fret = FretNumber(3),
                    finger = Finger.RING,
                    string = StringNumber(2)
            )
            +ChordMarker.Note(
                    fret = FretNumber(3),
                    finger = Finger.PINKY,
                    string = StringNumber(1)
            )
        }
```

**Assigning a `Chord` to a `ChordWidget`:**
```kotlin
chordWidget?.chord = chord
```

**Note:** This library doesn't try to coerce values to fit into a chart or exclude values that exceed the chart bounds. If the `ChordChart` and `Chord` have inconsistent values, the `ChordWidget` may look peculiar.
It's important for the user of the library to properly handle coordinating the different components.

### Parsing Chords from other formats
The `ChordParser` interface takes in an input type and outputs a `ChordParseResult`. This interface can be implemented for different format input types. There are a couple provided `ChordParser` implementations.

**AsciiChordParser:**

`AsciiChordParser` parses a `String` input of an ASCII Chord Diagram and outputs a `ChordParseResult` containing a `Chord`.

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
    // parse() is a suspending function and needs to be called from another suspending
    // function or a coroutine
    val result = parser.parse(chordDiagram)
    val chord = result.chord
    val stringLabels = result.stringLabels
}
```

### Customizing the appearance
`ChordWidget` implements the `ChordView` interface which contains properties to alter the appearance of the view.

**ChordView:**
```kotlin
interface ChordView {

    ...

    var fitToHeight: Boolean

    var showFretNumbers: Boolean

    var showFingerNumbers: Boolean

    var stringLabelState: StringLabelState

    var mutedStringText: String

    var openStringText: String

    var fretColor: ColorInt

    var fretLabelTextColor: ColorInt

    var stringColor: ColorInt

    var stringLabelTextColor: ColorInt

    var noteColor: ColorInt

    var noteLabelTextColor: ColorInt

    ...
}
```

**Updating properties directly on ChordWidget:**
```kotlin
chordWidget?.noteColor = Color.BLUE
chordWidget?.openStringText = "o"
```

**Updating properties using a ViewModel and Binder:**
```kotlin
val binder = ChordViewBinder(chordWidget)
        
val viewModel = ChordViewModel(
                    fretColor = Color.BLACK,
                    fretLabelTextColor = Color.WHITE,
                    stringLabelTextColor = Color.BLACK,
                    stringColor = Color.BLACK,
                    noteColor = Color.BLACK,
                    noteLabelTextColor = Color.WHITE)

binder.bind(viewModel)
```

**Updating properties in XML:**
```xml
<com.chrynan.chords.widget.ChordWidget
        android:id="@+id/chordWidget"
        android:layout_width="200dp"
        android:layout_height="300dp"
        app:stringLabelState="label"
        app:showFretNumbers="false"/>
```

**Available XML Attributes:**
```xml
<attr name="fretColor" format="color"/>
<attr name="fretLabelTextColor" format="color"/>
<attr name="stringColor" format="color"/>
<attr name="stringLabelTextColor" format="color"/>
<attr name="noteColor" format="color"/>
<attr name="noteLabelTextColor" format="color"/>
<attr name="mutedStringText" format="string"/>
<attr name="openStringText" format="string"/>
<attr name="showFingerNumbers" format="boolean"/>
<attr name="showFretNumbers" format="boolean"/>
<attr name="stringLabelState" format="enum">
    <enum name="number" value="0"/>
    <enum name="label" value="1"/>
    <enum name="hide" value="2"/>
</attr>
<attr name="fitToHeight" format="boolean"/>
<attr name="typeface" format="reference"/>
```

### Selectable Chord names in Text
The library comes with a `ChordSpan` which allows the pairing of text with a `Chord`. And when the `ChordSpan` is selected, a listener is alerted with the `Chord`.

**Adding a `ChordSpan` to a `TextView`:**
```kotlin
val text = SpannableString("G")
val span = ChordSpan(chord, this) // "this" refers to the listener

text.setSpan(span, 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

textView?.text = text
// Need to specify LinkTouchMovementMethod as the movement method for clicks to work
textView?.movementMethod = LinkTouchMovementMethod()
```

**Listening to `Chord` selected events:**
```kotlin
class MainActivity : AppCompatActivity(),
    ChordSpan.SelectedListener {

    override fun onChordSpanSelected(chord: Chord) {
        // Perform action with chord
    }
}
```

**Customizing the `ChordSpan` appearance:**

`ChordSpan` extends from `TouchableSpan` which has the following customizable properties:
```kotlin
var backgroundColor = Color.TRANSPARENT
var pressedBackgroundColor = Color.TRANSPARENT
var textColor = Color.BLUE
var pressedTextColor = Color.BLUE
var isUnderlined = false
var isUnderlinedWhenPressed = false
```

These properties can be changed on the span:
```kotlin
span.textColor = Color.RED
```

### Passing Chords between components
The model classes are not `Parcelable` because they are in a Kotlin multi-platform module and don't have access to Android Framework classes. But the Android library module does have wrapper classes that handle the serialization and de-serialization of the `Chord` and `ChordChart` models.

These classes are `ParcelableChordWrapper` and `ParcelableChartWrapper`. To pass `Chord` and `ChordChart` between components, such as, in a Bundle, just wrap them with their respective wrapper models.
```kotlin
arguments = 
    Bundle().apply {
        putParcelable(KEY_CHORD, ParcelableChordWrapper(chord))
        putParcelable(KEY_CHART, ParcelableChartWrapper(chart))
    }
```

Then retrieve the wrappers just as you would with any other Parcelable object.
```kotlin
arguments?.getParcelable<ParcelableChordWrapper>(KEY_CHORD)
arguments?.getParcelable<ParcelableChartWrapper>(KEY_CHART)
```

For convenience, there are extension functions on the `Bundle` and `Intent` objects which handle the wrapping and unwrapping of the `Chord` and `ChordChart` objects.

**Bundle:**
```kotlin
arguments =
    Bundle().apply {
        putChord(KEY_CHORD, chord)
        putChordChart(KEY_CHART, chart)
    }

val chord = arguments?.getChord(KEY_CHORD)
val chart = arguments?.getChordChart(KEY_CHART)
```

**Intent:**
```kotlin
intent.putChord(KEY_CHORD, chord)
intent.putChordChart(KEY_CHART, chart)

val chord = intent.getChordExtra(KEY_CHORD)
val chart = intent.getChordChartExtra(KEY_CHART)
```

### Sample
Checkout the `sample` module for a full example on using the library.

## License
```
Copyright 2020 chRyNaN

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```