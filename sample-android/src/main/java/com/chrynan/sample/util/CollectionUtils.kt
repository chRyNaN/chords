package com.chrynan.sample.util

/**
 * Starts with the [initialValue] and maps to the result of applying the [evaluator] function on
 * each element in this [Collection].
 *
 * @author chRyNaN
 */
fun <T, R> Collection<T>.mapEvaluate(initialValue: T, evaluator: (T, T) -> R): List<R> {
    var previousValue = initialValue

    return map {
        val value = evaluator(previousValue, it)
        previousValue = it
        value
    }
}