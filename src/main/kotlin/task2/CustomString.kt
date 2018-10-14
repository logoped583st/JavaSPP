package com.test.task2

class CustomString() {

    private lateinit var string: String

    constructor(word: Word, symbol: Symbol) : this() {
        this.string = StringBuilder(word.word).append(symbol.char).toString()
    }

}