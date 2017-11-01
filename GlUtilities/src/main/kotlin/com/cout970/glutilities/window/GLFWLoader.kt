package com.cout970.glutilities.window

import org.lwjgl.glfw.GLFW

/**
 * Created by cout970 on 30/08/2016.
 */
object GLFWLoader {

    var loaded = false
        private set

    fun init() {
        if (!loaded) {
            loaded = true
            if (!GLFW.glfwInit()) {
                throw IllegalStateException("Error trying to initialize GLFW")
            }
        } else throw IllegalStateException("GLFW already initialized")
    }

    fun terminate() {
        if (loaded) {
            loaded = false
            GLFW.glfwTerminate()
        } else throw IllegalStateException("GLFW already terminated")
    }
}