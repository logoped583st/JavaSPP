package com.test

import java.io.File
import java.io.FileNotFoundException
import java.util.*

class Calculator() {

    private val stack: Stack<Double> = Stack()
    private var counter: Int = 0

    fun commandsFromConsole(commands: List<String>) {
        while (counter < commands.size) {
            checkCommand(commands)
            counter++
        }
        counter = 0
    }


    constructor(fileName: String) : this() {
        val file = File(fileName)
        if (file.canRead()) {
            val lines = file.readText().split(System.getProperty("line.separator"))
            for (i in 0..lines.lastIndex) {
                if (!lines[i].contains("#")) {
                    val commands: List<String> = lines[i].split(" ")

                    while (counter < commands.size) {
                        checkCommand(commands)
                        counter++
                    }
                }
            }

        } else {
            val error = Throwable(FileNotFoundException())
            throw (error)
        }
    }

    private fun checkCommand(string: List<String>) {
        when (string[counter]) {
            "POP" -> {
                CommandUtils.pop(stack)
            }

            "PUSH" -> {
                counter++
                CommandUtils.push(stack, string[counter])
            }

            "PRINT" -> CommandUtils.print(stack)

            "DEFINE" -> {
                CommandUtils.define(string[counter], string[counter + 1], string[counter + 2].toDouble())
                counter += 2
            }

            "+" -> CommandUtils.plus(stack)

            "-" -> CommandUtils.minus(stack)

            "*" -> CommandUtils.multiply(stack)

            "/" -> CommandUtils.divide(stack)

            "SQRT" -> CommandUtils.sqrt(stack)

            else -> {
                try {
                    throw NotFoundCommandException()
                } catch (e: NotFoundCommandException) {
                    print("\nNot found command " + string[counter])
                }
            }
        }
    }

    inner class NotFoundCommandException : Exception("\nCommandNotFound")

}