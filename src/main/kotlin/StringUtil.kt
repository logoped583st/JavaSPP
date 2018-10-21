package com.test

fun String.Companion.repeat(string: String, count: Int): String {

    if (count < 0) {
        throw  IllegalArgumentException()
    }

    val stringBuilder = StringBuilder()
    var counter = 0
    while (counter < count) {
        stringBuilder.append(string)
        counter++
    }
    return stringBuilder.toString()
}

fun String.Companion.repeat(string: String, separatort: String, count: Int): String {

    if (count < 0) {
        throw  IllegalArgumentException()
    }

    val stringBuilder = StringBuilder()
    var counter = 0
    while (counter < count) {
        stringBuilder.append(string)
        stringBuilder.append(separatort)
        counter++
    }
    return stringBuilder.toString()

}