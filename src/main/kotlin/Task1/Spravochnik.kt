package com.test.Task1

class Spravochnik(override val crypt: String,
                  override val author: String,
                  override val name: String,
                  override val year: Int,
                  override val izdatelstvo: String) : Book() {
}