package com.test

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {

    companion object {

        var calculator: Calculator? = null

        @JvmStatic
        fun main(args: Array<String>) {
//            val triagle1 = Triagle()
//            val triagle2 = Triagle(1,3)
//
//            print(triagle1 == triagle2)
//            print(triagle2.isExist())
//            print(triagle2.perimeter())
            if (args.isEmpty()) {
                while (true) {


                    val bufferReader = BufferedReader(InputStreamReader(System.`in`))
                    val commands: List<String> = bufferReader.readLine().split(" ")

                    if (calculator == null) {
                        calculator = Calculator()
                    }

                    calculator!!.commandsFromConsole(commands)
                }
            } else {
                Calculator("./src/main/kotlin/TEST.txt")
            }
        }
    }
}