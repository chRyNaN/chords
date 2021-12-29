//[chords-core](../../index.md)/[com.chrynan.chords.util](index.md)/[getTypeface](get-typeface.md)

# getTypeface

[android]\
fun [TypedArray](https://developer.android.com/reference/kotlin/android/content/res/TypedArray.html).[getTypeface](get-typeface.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), @[StyleableRes](https://developer.android.com/reference/kotlin/androidx/annotation/StyleableRes.html)fontFamilyResId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), defaultValue: [Typeface](https://developer.android.com/reference/kotlin/android/graphics/Typeface.html)? = null): [Typeface](https://developer.android.com/reference/kotlin/android/graphics/Typeface.html)?

Retrieves a [Typeface](https://developer.android.com/reference/kotlin/android/graphics/Typeface.html) from this [TypedArray](https://developer.android.com/reference/kotlin/android/content/res/TypedArray.html) for the provided [fontFamilyResId](get-typeface.md). If the provided [fontFamilyResId](get-typeface.md) is not found then the [defaultValue](get-typeface.md) will be returned. If no [defaultValue](get-typeface.md) is provided and no [fontFamilyResId](get-typeface.md) is found, then null will be returned.

#### Author

chRyNaN
