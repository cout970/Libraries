package com.cout970.glutilities.event

/**
 * Created by cout970 on 30/08/2016.
 */
interface IEventHandler {

    fun registerWindow(windowId: Long)

    fun fireEvent(event: Event)

    fun registerListener(listener: (Event) -> Unit)

    fun pollEvents()
}