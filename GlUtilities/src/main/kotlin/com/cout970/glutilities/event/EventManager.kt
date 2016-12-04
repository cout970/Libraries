package com.cout970.glutilities.event

import org.lwjgl.glfw.*
import org.lwjgl.glfw.GLFW.*

/**
 * Created by cout970 on 26/07/2016.
 */
object EventManager : IEventHandler {

    private val listeners = mutableListOf<(Event) -> Unit>()
    private val callbacks = mutableListOf<Callback>()

    override fun registerWindow(windowId: Long) {
        callbacks.add(Callback(windowId))
    }

    override fun fireEvent(event: Event) {
        listeners.forEach { it(event) }
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
        val charModsCallback: GLFWCharModsCallback
        val cursorEnterCallback: GLFWCursorEnterCallback
        val dropCallback: GLFWDropCallback
        val framebufferSizeCallback: GLFWFramebufferSizeCallback
        val windowSizeCallback: GLFWWindowSizeCallback
        val windowPosCallback: GLFWWindowPosCallback
        val windowRefreshCallback: GLFWWindowRefreshCallback
        val windowIconifyCallback: GLFWWindowIconifyCallback
        val windowFocusCallback: GLFWWindowFocusCallback
        val windowCloseCallback: GLFWWindowCloseCallback

        init {
            charCallback = GLFWCharCallback.create { window, code -> fireEvent(EventCharTyped(window, code.toChar(), code)) }
            keyCallback = GLFWKeyCallback.create { window, key, scanCode, action, mods -> fireEvent(EventKeyUpdate(window, key, scanCode, EnumKeyState.fromID(action), mods)) }
            mouseButtonCallback = GLFWMouseButtonCallback.create { window, button, action, mods -> fireEvent(EventMouseClick(window, button, EnumKeyState.fromID(action), mods)) }
            scrollCallback = GLFWScrollCallback.create { window, xOffset, yOffset -> fireEvent(EventMouseScroll(window, xOffset, yOffset)) }
            cursorPosCallback = GLFWCursorPosCallback.create { window, x, y -> fireEvent(EventCursorPos(window, x, y)) }
            charModsCallback = GLFWCharModsCallback.create { window, codePoint, mods -> fireEvent(EventCharMods(window, codePoint, mods)) }
            cursorEnterCallback = GLFWCursorEnterCallback.create { window, entered -> fireEvent(EventCursorEnter(window, entered)) }
            dropCallback = GLFWDropCallback.create { window, count, names -> fireEvent(EventFileDrop(window, count, names)) }
            framebufferSizeCallback = GLFWFramebufferSizeCallback.create { window, width, height -> fireEvent(EventFrameBufferSize(window, width, height)) }
            windowSizeCallback = GLFWWindowSizeCallback.create { window, width, height -> fireEvent(EventWindowSize(window, width, height)) }
            windowPosCallback = GLFWWindowPosCallback.create { window, x, y -> fireEvent(EventWindowPos(window, x, y)) }
            windowRefreshCallback = GLFWWindowRefreshCallback.create { fireEvent(EventWindowRefresh(it)) }
            windowIconifyCallback = GLFWWindowIconifyCallback.create { window, iconified -> fireEvent(EventWindowIconify(window, iconified)) }
            windowFocusCallback = GLFWWindowFocusCallback.create { window, focused -> fireEvent(EventWindowFocus(window, focused)) }
            windowCloseCallback = GLFWWindowCloseCallback.create { fireEvent(EventWindowClose(it)) }

            glfwSetCharCallback(windowID, charCallback)
            glfwSetKeyCallback(windowID, keyCallback)
            glfwSetMouseButtonCallback(windowID, mouseButtonCallback)
            glfwSetScrollCallback(windowID, scrollCallback)
            glfwSetCursorPosCallback(windowID, cursorPosCallback)
            glfwSetCharModsCallback(windowID, charModsCallback)
            glfwSetCursorEnterCallback(windowID, cursorEnterCallback)
            glfwSetDropCallback(windowID, dropCallback)
            glfwSetFramebufferSizeCallback(windowID, framebufferSizeCallback)
            glfwSetWindowSizeCallback(windowID, windowSizeCallback)
            glfwSetWindowPosCallback(windowID, windowPosCallback)
            glfwSetWindowRefreshCallback(windowID, windowRefreshCallback)
            glfwSetWindowIconifyCallback(windowID, windowIconifyCallback)
            glfwSetWindowFocusCallback(windowID, windowFocusCallback)
            glfwSetWindowCloseCallback(windowID, windowCloseCallback)
        }

        override fun close() {
            charCallback.close()
            keyCallback.close()
            mouseButtonCallback.close()
            scrollCallback.close()
            cursorPosCallback.close()
            charModsCallback.close()
            cursorEnterCallback.close()
            dropCallback.close()
            framebufferSizeCallback.close()
            windowSizeCallback.close()
            windowPosCallback.close()
            windowRefreshCallback.close()
            windowIconifyCallback.close()
            windowFocusCallback.close()
            windowCloseCallback.close()
        }
    }
}
