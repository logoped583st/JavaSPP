package com.test


class Triagle() {

    constructor(side: Int, bottom: Int) : this() {
        this.side = side
        this.bottom = bottom
    }

    var side: Int = 0

    var bottom: Int = 0

    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        if (other !is Triagle) return false

        return other.side == side && other.bottom == bottom
    }

    override fun hashCode(): Int {
        var result = 17
        result = 31 * result + side
        result = 31 * result + bottom
        return result
    }

    override fun toString(): String {
        return "side = $side and bottom = $bottom \n"
    }

    fun perimeter(): Int = side * 2 + bottom

    fun square(): Double = bottom * kotlin.math.sqrt((side * side - bottom * bottom - 4).toDouble()) / 2

    fun isExist(): Boolean = (2 * side) > bottom
}