package com.cout970.glutilities.event

/**
 * Created by cout970 on 2016/11/29.
 */
class EventCharMods(
        id: Long,
        val codePoint: Int,
        val mods: Int
) : Event(id) {

    override fun toString(): String {
        return "EventCharMods(codepoint=$codePoint, mods=$mods)"
    }
}