package com.cout970.glutilities.window

import com.cout970.vector.api.IVector2
import com.cout970.vector.extensions.vec2Of
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.opengl.GL
import org.lwjgl.system.MemoryUtil

/**
 * Created by cout970 on 25/07/2016.
 */
class WindowBuilder {

    var title = "GLFW Window"
    var pos: IVector2? = null
    var size: IVector2 = vec2Of(200)
    var shared: Long = MemoryUtil.NULL
    var screen: Long = MemoryUtil.NULL
    var vSync: Boolean = false
    var initGL = true
    var properties = mutableMapOf<Int, Int>()

    fun create(): GLFWWindow {

        if (!GLFWLoader.loaded) throw IllegalStateException("GLFW has not been initialized yet")

        glfwDefaultWindowHints()
        for ((attr, value) in properties) {
            glfwWindowHint(attr, value)
        }

        val id = glfwCreateWindow(size.xi, size.yi, title, screen, shared)
        if (id == MemoryUtil.NULL) {
            throw RuntimeException("Failed to create a GLFW window")
        }

        if (initGL) {
            glfwMakeContextCurrent(id)
            GL.createCapabilities()
        }

        val window = GLFWWindow(id)

        pos?.let { window.setPos(it)  } ?: window.center()

        window.setVSync(vSync)

        return window
    }

    companion object {

        inline fun build(init: WindowBuilder.() -> Unit): GLFWWindow {
            val builder = WindowBuilder()
            builder.init()
            return builder.create()
        }
    }
}