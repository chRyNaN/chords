//[chords-core](../../../index.md)/[com.chrynan.chords.parser](../index.md)/[AsciiChordParser](index.md)



# AsciiChordParser  
 [common] class [AsciiChordParser](index.md)(**tabDelimiters**: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)>) : [ChordParser](../-chord-parser/index.md)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)> 

Parses a simple ASCII Chord Diagram String into a [Chord](../../com.chrynan.chords.model/-chord/index.md). This [ChordParser](../-chord-parser/index.md) handles String inputs in the following format:

    C

e |-----0------| B |-----1------| G |-----0------| D |-----2------| A |-----3------| E |------------|

<ul><li>Whitespace will be trimmed.</li><li>The first line may contain an optional chord name. ---- If there is a chord name present, the whole line will be used as the chord name. ---- If there are any [tabDelimiters](../../../../chords-core/com.chrynan.chords.parser/-ascii-chord-parser/tab-delimiters.md) on the chord name line, it will be considered a 'normal'     line.</li><li>Each following line will be processed as a [StringNumber](../../com.chrynan.chords.model/-string-number/index.md). ---- The first line will be the first [StringNumber](../../com.chrynan.chords.model/-string-number/index.md) (1) and the numbers will increase for     subsequent lines. ---- Lines may begin with an optional label before any [tabDelimiters](../../../../chords-core/com.chrynan.chords.parser/-ascii-chord-parser/tab-delimiters.md) or Frets. ---- All [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)s on a line after the first [tabDelimiters](../../../../chords-core/com.chrynan.chords.parser/-ascii-chord-parser/tab-delimiters.md), and separated by [tabDelimiters](../../../../chords-core/com.chrynan.chords.parser/-ascii-chord-parser/tab-delimiters.md),     will be considered the FretNumbers for [ChordMarker.Note](../../com.chrynan.chords.model/-chord-marker/-note/index.md)s. ---- The absence of an [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) on a line, will be considered a muted line or a line that should     not be played. ---- If an [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) value of zero is found on a line, then that String is considered "open". -- If the input [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) is blank, null will be returned. -- If the [tabDelimiters](../../../../chords-core/com.chrynan.chords.parser/-ascii-chord-parser/tab-delimiters.md) is empty, null will be returned.</li></ul>

#### Author  


chRyNaN

   


## Parameters  
  
common  
  
| | |
|---|---|
| <a name="com.chrynan.chords.parser/AsciiChordParser///PointingToDeclaration/"></a>tabDelimiters| <a name="com.chrynan.chords.parser/AsciiChordParser///PointingToDeclaration/"></a><br><br>The [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html) of [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) delimiters used to separate the optional label and     fret numbers (Ex: "|" and "-"). This set cannot be empty.<br><br>|
  


## Constructors  
  
| | |
|---|---|
| <a name="com.chrynan.chords.parser/AsciiChordParser/AsciiChordParser/#kotlin.collections.Set[kotlin.Char]/PointingToDeclaration/"></a>[AsciiChordParser](-ascii-chord-parser.md)| <a name="com.chrynan.chords.parser/AsciiChordParser/AsciiChordParser/#kotlin.collections.Set[kotlin.Char]/PointingToDeclaration/"></a> [common] fun [AsciiChordParser](-ascii-chord-parser.md)(tabDelimiters: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)> = setOf('|', '-'))The [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html) of [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) delimiters used to separate the optional label and     fret numbers (Ex: "|" and "-").   <br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.chords.parser/AsciiChordParser/parse/#kotlin.String/PointingToDeclaration/"></a>[parse](parse.md)| <a name="com.chrynan.chords.parser/AsciiChordParser/parse/#kotlin.String/PointingToDeclaration/"></a>[common]  <br>Content  <br>open suspend override fun [parse](parse.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md)  <br>More info  <br>Parses the provided input IN and returns the output OUT.  <br><br><br>|
| <a name="com.chrynan.chords.parser/Parser/parseOrNull/#kotlin.String/PointingToDeclaration/"></a>[parseOrNull](../-json-string-chord-parser/index.md#%5Bcom.chrynan.chords.parser%2FParser%2FparseOrNull%2F%23kotlin.String%2FPointingToDeclaration%2F%5D%2FFunctions%2F2144227643)| <a name="com.chrynan.chords.parser/Parser/parseOrNull/#kotlin.String/PointingToDeclaration/"></a>[common]  <br>Content  <br>open suspend fun [parseOrNull](../-json-string-chord-parser/index.md#%5Bcom.chrynan.chords.parser%2FParser%2FparseOrNull%2F%23kotlin.String%2FPointingToDeclaration%2F%5D%2FFunctions%2F2144227643)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ChordParseResult](../../com.chrynan.chords.model/-chord-parse-result/index.md)?  <br>More info  <br>Parses the provided input [IN](../-parser/index.md) and returns the output [OUT](../-parser/index.md).  <br><br><br>|

