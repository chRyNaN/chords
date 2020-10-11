@file:Suppress("unused")

package com.chrynan.chords.graphics

import org.w3c.dom.HTMLCanvasElement

/**
 * A model of two coordinates, x and y, that make up a point. This is useful for referencing a point with a
 * [HTMLCanvasElement].
 *
 * Note that these values are all [Double]s.
 *
 * @property [x] The x coordinate value.
 * @property [y] The y coordinate value.
 *
 * @author chRyNaN
 */
data class Point(
    val x: Double,
    val y: Double
) {

    /**
     * Retrieves a new [Point] by whose values are the negative of this [Point]'s values.
     *
     * @author chRyNaN
     */
    fun negate(): Point = Point(x = -x, y = -y)

    /**
     * Retrieves a new [Point] by offsetting this [Point]'s values by adding [dx] and [dy].
     *
     * @author chRyNaN
     */
    fun offset(dx: Double, dy: Double): Point = Point(x = x + dx, y = y + dy)

    /**
     * Retrieves a new [Point] by insetting this [Point]'s values by subtracting [dx] and [dy].
     *
     * @author chRyNaN
     */
    fun inset(dx: Double, dy: Double): Point = Point(x = x - dx, y = y - dy)

    /**
     * Retrieves a new [Point] by adding [value] to both [x] and [y].
     *
     * @author chRyNaN
     */
    operator fun plus(value: Double): Point = Point(x = x + value, y = y + value)
}