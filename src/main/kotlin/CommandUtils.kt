package com.test

import java.util.*
import kotlin.collections.HashMap

object CommandUtils {

    private val defined: HashMap<String, Double> = HashMap()

    fun print(stack: Stack<Double>) {
        try {
            print("\n" + stack.lastElement().toString())
        } catch (e: NoSuchElementException) {
            print("\nNo elements in stack")
        }
    }

    fun push(stack: Stack<Double>, value: String) {
        if (defined.containsKey(value)) {
            stack.push(defined[value])
        } else {
            stack.push(value.toDouble())
        }
    }

    fun pop(stack: Stack<Double>) {
        try {
            stack.pop()
        } catch (e: EmptyStackException) {
            print("\nNo elements in stack")
        }
    }

    fun sqrt(stack: Stack<Double>) {
        try {
            val element = stack.lastElement()
            stack.pop()
            stack.push(Math.sqrt(element))
        } catch (e: EmptyStackException) {
            print("\nNo elements in stack")
        }
    }

    fun plus(stack: Stack<Double>) {
        try {
            val value1 = stack[stack.lastIndex - 1]
            val value2 = stack.lastElement()
            stack.pop()
            stack.pop()
            stack.push(value1 + value2)
        } catch (e: ArrayIndexOutOfBoundsException) {
            print("\nNo elements in stack")
        }
    }

    fun minus(stack: Stack<Double>) {
        try {
            val value1 = stack[stack.lastIndex - 1]
            val value2 = stack.lastElement()
            stack.pop()
            stack.pop()
            stack.push(value1 - value2)
        } catch (e: ArrayIndexOutOfBoundsException) {
            print("\nNo elements in stack")
        }
    }

    fun multiply(stack: Stack<Double>) {
        try {
            val value1 = stack[stack.lastIndex - 1]
            val value2 = stack.lastElement()
            stack.pop()
            stack.pop()
            stack.push(value1 * value2)
        } catch (e: ArrayIndexOutOfBoundsException) {
            print("\nNo elements in stack")
        }
    }

    fun divide(stack: Stack<Double>) {
        try {
            val value1 = stack[stack.lastIndex - 1]
            val value2 = stack.lastElement()
            stack.pop()
            stack.pop()
            stack.push(value1 / value2)
        } catch (e: ArrayIndexOutOfBoundsException) {
            print("\nNo elements in stack")
        }
    }

    fun define(key: String, value: Double) {
        defined[key] = value
    }
}