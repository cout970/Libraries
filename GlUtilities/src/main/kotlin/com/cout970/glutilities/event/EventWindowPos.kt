package com.cout970.glutilities.event

/**
 * Created by cout970 on 2016/12/02.
 */
class EventWindowPos(window: Long, val x: Int, val y: Int) : Event(window) {
    override fun toString(): String {
        return "EventWindowPos(x=$x, y=$y)"
    }
}