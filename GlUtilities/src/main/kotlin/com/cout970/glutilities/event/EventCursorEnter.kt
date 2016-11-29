package com.cout970.glutilities.event

class EventCursorEnter(window: Long, val entered: Boolean) : Event(window) {
    override fun toString(): String {
        return "EventCursorEnter(entered=$entered)"
    }
}