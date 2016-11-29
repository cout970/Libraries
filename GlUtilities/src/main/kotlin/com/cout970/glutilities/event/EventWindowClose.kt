package com.cout970.glutilities.event

class EventWindowClose(window: Long) : Event(window) {
    override fun toString(): String {
        return "EventWindowClose()"
    }
}