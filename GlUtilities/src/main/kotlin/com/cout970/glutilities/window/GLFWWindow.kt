package com.cout970.glutilities.window

import com.cout970.vector.api.IVector2
import com.cout970.vector.extensions.vec2Of
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.opengl.GL11
import java.io.Closeable

/**
 * Created by cout970 on 25/07/2016.
 */
class GLFWWindow(
        val id: Long
) : Closeable {

    var pos: IVector2
        get() = getPos()
        set(i) = setPos(i)

    var size: IVector2
        get() = getSize()
        set(i) = setSize(i)

    fun getMonitor() = glfwGetWindowMonitor(id)

    fun getAttibute(attr: Int) = glfwGetWindowAttrib(id, attr)

    fun setSizeLimits(min: IVector2, max: IVector2) = glfwSetWindowSizeLimits(id, min.xi, min.yi, max.xi, max.yi)

    fun setSouldClose(bool: Boolean) = glfwSetWindowShouldClose(id, bool)

    fun setAspectRatio(ratio: IVector2) = glfwSetWindowAspectRatio(id, ratio.xi, ratio.yi)

    fun setTitle(title: String) = glfwSetWindowTitle(id, title)

    fun shouldClose(): Boolean = glfwWindowShouldClose(id)

    fun show() = glfwShowWindow(id)

    fun hide() = glfwHideWindow(id)

    fun minimize() = glfwIconifyWindow(id)

    fun maximize() = glfwMaximizeWindow(id)

    fun restore() = glfwRestoreWindow(id)

    fun center() {
        val monitor = glfwGetWindowMonitor(id)
        val vidmode = glfwGetVideoMode(if(monitor == 0L) glfwGetPrimaryMonitor() else monitor)
        glfwSetWindowPos(id, (vidmode.width() - getSize().xi) / 2, (vidmode.height() - getSize().yi) / 2)
    }

    fun focus() = glfwFocusWindow(id)

    fun hasFocus() = glfwGetWindowAttrib(id, GLFW_FOCUSED) == GLFW_TRUE

    fun setVSync(active: Boolean) = glfwSwapInterval(if (active) GLFW_TRUE else GLFW_FALSE)

    fun swapBuffers() = glfwSwapBuffers(id)

    fun setDefaultViewport(){
        val fbs = getFrameBufferSize()
        GL11.glViewport(0, 0, fbs.xi, fbs.yi)
    }

    fun getFrameBufferSize(): IVector2 {
        val x = intArrayOf(0)
        val y = intArrayOf(0)
        glfwGetFramebufferSize(id, x, y)
        return vec2Of(x[0], y[0])
    }

    internal fun setPos(pos: IVector2) {
        glfwSetWindowPos(id, pos.xi, pos.yi)
    }

    internal fun setSize(size: IVector2) {
        glfwSetWindowSize(id, size.xi, size.yi)
    }

    internal fun getPos(): IVector2 {
        val x = intArrayOf(0)
        val y = intArrayOf(0)
        glfwGetWindowPos(id, x, y)
        return vec2Of(x[0], y[0])
    }

    internal fun getSize(): IVector2 {
        val x = intArrayOf(0)
        val y = intArrayOf(0)
        glfwGetWindowSize(id, x, y)
        return vec2Of(x[0], y[0])
    }

    override fun close() {
        glfwDestroyWindow(id)
    }
}