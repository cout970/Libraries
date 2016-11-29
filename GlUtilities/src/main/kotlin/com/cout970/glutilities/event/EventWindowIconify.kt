package com.cout970.glutilities.event

class EventWindowIconify(window: Long, val iconified: Boolean) : Event(window) {
    override fun toString(): String {
        return "EventWindowIconify(iconified=$iconified)"
    }
}