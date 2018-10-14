package com.test

import java.text.SimpleDateFormat
import java.util.*


class NotePad(name: String, description: String) {

    val notePads: ArrayList<OneNodePadClass> = ArrayList()

    val oneNodePadClass = OneNodePadClass(name, description)

    inner class OneNodePadClass() {
        lateinit var name: String
        lateinit var description: String
        lateinit var updateOn: String

        constructor(name: String, description: String) : this() {
            this.name = name
            this.description = description
            setUpdate()
            notePads.add(this)
        }

        private fun setUpdate() {
            val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
            val date = Date()
            this.updateOn = dateFormat.format(date)
        }

        fun capsDescription(position: Int) {
            notePads[position].description = notePads[position].description.toUpperCase()
        }
    }
}