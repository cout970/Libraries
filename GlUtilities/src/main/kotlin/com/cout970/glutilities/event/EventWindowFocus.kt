package com.cout970.glutilities.event

class EventWindowFocus(window: Long, val focused: Boolean) : Event(window) {
    override fun toString(): String {
        return "EventWindowFocus(focused=$focused)"
    }
}