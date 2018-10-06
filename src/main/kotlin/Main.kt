package com.test

import java.io.IOException
import java.io.File

class Main {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            try {
                var isToConsole = true
                args.forEach {
                    if (it == ">") {
                        isToConsole = false
                        return@forEach
                    }
                }
                if (isToConsole) {
                    for (i in 0..args.lastIndex) {
                        val file = File(args[i])
                        if (File(args[i]).isFile) {
                            print(file.readText() + "\n")
                        } else {
                            print(args[i] + " is not exist" + "\n")
                        }
                    }
                } else {
                    val newFile = File(args[args.lastIndex])
                    for (i in 0..args.lastIndex) {
                        val file = File(args[i])
                        if (File(args[i]).canRead()) {
                            newFile.writeText(file.readText() + "\n")
                        } else if (args[i] != ">") {
                            newFile.writeText(args[i] + "\n")
                        }
                    }
                }

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}