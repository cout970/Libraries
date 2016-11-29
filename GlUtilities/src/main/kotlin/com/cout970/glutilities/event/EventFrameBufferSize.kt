package com.cout970.glutilities.event

class EventFrameBufferSize(window: Long, val width: Int, val height: Int) : Event(window) {
    override fun toString(): String {
        return "EventFrameBufferSize(width=$width, height=$height)"
    }
}