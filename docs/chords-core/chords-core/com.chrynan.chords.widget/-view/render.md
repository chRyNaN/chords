//[chords-core](../../../index.md)/[com.chrynan.chords.widget](../index.md)/[View](index.md)/[render](render.md)

# render

[js]\
fun [render](render.md)()

This function invokes a layout pass to occur. This will invoke the [onMeasure](../../../../chords-core/com.chrynan.chords.widget/-view/on-measure.md) and [onDraw](../../../../chords-core/com.chrynan.chords.widget/-view/on-draw.md) functions.

Call this function after creating an instance of a [View](index.md), when you are ready for the [View](index.md) to be rendered.

Note that this function is invoked on the calling thread and coroutine.

#### Author

chRyNaN
