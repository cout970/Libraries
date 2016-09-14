package com.cout970.glutilities.window

import org.lwjgl.glfw.GLFW

/**
 * Created by cout970 on 30/08/2016.
 */
object GLFWLoader {

    var init = false
        private set

    fun init() {
        if (!init) {
            init = true
            if (!GLFW.glfwInit()) {
                throw IllegalStateException("Error trying to initialize GLFW")
            }
        }
    }

    fun terminate() {
        GLFW.glfwTerminate()
    }
}