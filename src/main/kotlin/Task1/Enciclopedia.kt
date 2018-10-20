package com.test.Task1

class Enciclopedia(override val crypt: String,
                   override val author: String,
                   override val name: String, override val year: Int,
                   override val izdatelstvo: String) : Book() {
}