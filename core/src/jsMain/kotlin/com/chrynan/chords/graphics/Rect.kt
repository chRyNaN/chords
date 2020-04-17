package com.chrynan.chords.graphics

import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement

/**
 * A model of a rectangle for a Javascript [HTMLCanvasElement].
 *
 * Note that this model considers the origin of the
 * quadrant to be in the top left. So, on the x-axis, the values start at zero at the furthest left point and increase
 * positively when moving to the right. And on the y-axis, the values start at zero at the highest top point and
 * increase positively when moving to the bottom. So the Canvas quadrant that this [Rect] supports would look like the
 * following:
 *
 * (0, 0)                (x, 0)
 *        +------------------>
 *        |
 *        |
 *        |
 *        |
 * (0, y) |
 *
 * This is important to consider because some of the properties depend on it. For instance, the [isEmpty] property will
 * return true if the top is greater than or equal to the bottom).
 *
 * Also note that this [Rect] uses values of [Double] for the four values. This is consistent with what the
 * [CanvasRenderingContext2D.rect] function expects.
 *
 * @property [left] The left coordinate of this [Rect].
 * @property [top] The top coordinate of this [Rect].
 * @property [right] The right coordinate of this [Rect].
 * @property [bottom] The bottom coordinate of this [Rect].
 *
 * @author chRyNaN
 */
data class Rect(
        var left: Double,
        var top: Double,
        var right: Double,
        var bottom: Double
) {

    companion object {

        /**
         * An empty [Rect] containing all values of 0.0 for it's properties.
         *
         * @author chRyNaN
         */
        val EMPTY: Rect = Rect(left = 0.0, top = 0.0, right = 0.0, bottom = 0.0)
    }

    /**
     * Indicates whether this [Rect] is empty or not. A [Rect] is considered empty if either of it's sides have a size
     * of zero or a negative number.
     *
     * @author chRyNaN
     */
    val isEmpty: Boolean
        get() = left >= right || top >= bottom

    /**
     * A convenience property that returns the opposite of [isEmpty].
     *
     * @author chRyNaN
     */
    val isNotEmpty: Boolean
        get() = !isEmpty

    /**
     * The width of this [Rect]. This is equivalent to [right] minus [left].
     *
     * Note that this will return a negative value if [left] is greater than [right].
     *
     * @author chRyNaN
     */
    val width: Double
        get() = right - left

    /**
     * The height of this [Rect]. This is equivalent to [bottom] - [top].
     *
     * Note that this will return a negative value if [top] is greater than [bottom].
     *
     * @author chRyNaN
     */
    val height: Double
        get() = bottom - top

    /**
     * The center x value of this [Rect]. This is equivalent to ([left] + [right]) * 0.5.
     *
     * Note that this does not verify that this [Rect] is not empty.
     *
     * @author chRyNaN
     */
    val centerX: Double
        get() = (left + right) * 0.5

    /**
     * The center y value of this [Rect]. This is equivalent to ([top] + [bottom]) * 0.5.
     *
     * Note that this does not verify that this [Rect] is not empty.
     *
     * @author chRyNaN
     */
    val centerY: Double
        get() = (top + bottom) * 0.5f

    /**
     * Sets this [Rect]'s values as the provided values.
     *
     * @author chRyNaN
     */
    fun set(left: Double, top: Double, right: Double, bottom: Double) {
        this.left = left
        this.top = top
        this.right = right
        this.bottom = bottom
    }

    /**
     * Returns a new [Rect] by offsetting this [Rect] by adding [dx] to its [left] and [right] coordinates, and
     * adding [dy] to its [top] and [bottom] coordinates.
     *
     * @param [dx] The amount to add to this [Rect]'s [left] and [right] coordinates.
     * @param [dy] The amount to add to the [Rect]'s [top] and [bottom] coordinates.
     */
    fun offset(dx: Double, dy: Double): Rect =
            Rect(
                    left = left + dx,
                    top = top + dy,
                    right = right + dx,
                    bottom = bottom + dy)

    /**
     * Returns a new [Rect] by insetting this [Rect] by subtracting [dx] to its [left] and [right] coordinates, and
     * adding [dy] to its [top] and [bottom] coordinates.
     *
     * @param [dx] The amount to subtract to this [Rect]'s [left] and [right] coordinates.
     * @param [dy] The amount to subtract to the [Rect]'s [top] and [bottom] coordinates.
     */
    fun inset(dx: Double, dy: Double): Rect =
            Rect(
                    left = left - dx,
                    top = top - dy,
                    right = right - dx,
                    bottom = bottom - dy)

    /**
     * Retrieves a [Boolean] indicating whether the provided [x] and [y] coordinates are within this [Rect]'s bounds.
     *
     * @author chRyNaN
     */
    fun contains(x: Float, y: Float): Boolean = isNotEmpty && x >= left && x < right && y >= top && y < bottom

    /**
     * Retrieves a [Boolean] indicating whether the provided [other] [Rect] is within this [Rect]'s bounds.
     *
     * @author chRyNaN
     */
    operator fun contains(other: Rect): Boolean = isNotEmpty && left <= other.left && top <= other.top
            && right >= other.right && bottom >= other.bottom

    /**
     * Retrieves a new [Rect] by adding the provided [other] [Rect]'s values with this [Rect].
     *
     * @author chRyNaN
     */
    operator fun plus(other: Rect): Rect =
            Rect(
                    left = left + other.left,
                    top = top + other.top,
                    right = right + other.right,
                    bottom = bottom + other.bottom)
}