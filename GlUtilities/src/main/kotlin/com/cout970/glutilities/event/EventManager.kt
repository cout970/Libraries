package com.cout970.glutilities.event

import org.lwjgl.glfw.*
import org.lwjgl.glfw.GLFW.*

/**
 * Created by cout970 on 26/07/2016.
 */
object EventManager : IEventHandler {

    private val listeners = mutableListOf<(Event) -> Unit>()
    private val callbacks = mutableListOf<Callback>()

    override fun registerWindow(windowID: Long) {
        callbacks.add(Callback(windowID))
    }

    override fun fireEvent(event: Event) {
        listeners.forEach { it.invoke(event) }
    }

    override fun registerListener(listener: (Event) -> Unit) {
        listeners.add(listener)
    }

    override fun pollEvents() {
        glfwPollEvents()
    }

    private class Callback(windowID: Long) : AutoCloseable {

        val charCallback: GLFWCharCallback
        val keyCallback: GLFWKeyCallback
        val mouseButtonCallback: GLFWMouseButtonCallback
        val scrollCallback: GLFWScrollCallback
        val cursorPosCallback: GLFWCursorPosCallback

        init {
            charCallback = GLFWCharCallback.create { window, code -> fireEvent(EventCharTyped(window, code.toChar(), code)) }
            keyCallback = GLFWKeyCallback.create { window, key, scancode, action, mods -> fireEvent(EventKeyUpdate(window, key, scancode, EnumKeyState.fromID(action), mods)) }
            mouseButtonCallback = GLFWMouseButtonCallback.create { window, button, action, mods -> fireEvent(EventMouseClick(window, button, EnumKeyState.fromID(action), mods)) }
            scrollCallback = GLFWScrollCallback.create { window, xoffset, yoffset -> fireEvent(EventMouseScroll(window, xoffset, yoffset)) }
            cursorPosCallback = GLFWCursorPosCallback.create { window, x, y -> fireEvent(EventCursorPos(window, x, y)) }

            glfwSetCharCallback(windowID, charCallback)
            glfwSetKeyCallback(windowID, keyCallback)
            glfwSetMouseButtonCallback(windowID, mouseButtonCallback)
            glfwSetScrollCallback(windowID, scrollCallback)
            glfwSetCursorPosCallback(windowID, cursorPosCallback)
        }

        override fun close() {
            charCallback.close()
            keyCallback.close()
            mouseButtonCallback.close()
            scrollCallback.close()
            cursorPosCallback.close()
        }
    }
}