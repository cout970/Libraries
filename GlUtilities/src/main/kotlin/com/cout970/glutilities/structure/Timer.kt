package com.cout970.glutilities.structure

import org.lwjgl.glfw.GLFW.glfwGetTime

open class Timer {

    private val fpsData = mutableListOf<Double>()
    private var time: Double = 0.0

    var fps: Int = 0
        private set

    var delta: Double = 0.0
        private set


    fun tick() {
        delta = glfwGetTime() - time
        time = glfwGetTime()

        fpsData.add(time)
        fpsData.removeAll { time - it >= 1 }
        fps = fpsData.count()
    }

    companion object {

        val secTime: Double
            get() = glfwGetTime()

        val miliTime: Double
            get() = glfwGetTime() * 1_000.0

        val microTime: Double
            get() = glfwGetTime() * 1_000_000.0

        val nanoTime: Double
            get() = glfwGetTime() * 1_000_000_000.0

    }
}
