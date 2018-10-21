package com.test

class Sum {

    companion object {
        fun accum(vararg values: Int): Long {
            var result: Long = 0
            for (i in values.indices) {
                result += values[i]
            }
            return result
        }
    }
}