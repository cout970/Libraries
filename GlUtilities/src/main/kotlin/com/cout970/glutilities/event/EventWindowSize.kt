package com.cout970.glutilities.event

class EventWindowSize(window: Long, val width: Int, val height: Int) : Event(window) {
    override fun toString(): String {
        return "EventWindowSize(width=$width, height=$height)"
    }
}