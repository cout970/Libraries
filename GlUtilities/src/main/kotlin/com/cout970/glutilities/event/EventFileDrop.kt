package com.cout970.glutilities.event

class EventFileDrop(window: Long, val count: Int, val names: Long) : Event(window) {
    override fun toString(): String {
        return "EventFileDrop(count=$count, names=$names)"
    }
}