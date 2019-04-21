package com.cout970.example.window

import com.cout970.glutilities.event.EventManager
import com.cout970.glutilities.structure.GLStateMachine
import com.cout970.glutilities.structure.Timer
import com.cout970.glutilities.window.GLFWLoader
import com.cout970.glutilities.window.WindowBuilder
import com.cout970.vector.extensions.vec2Of

/**
 * Created by cout970 on 2017/11/01.
 */
fun main(args: Array<String>) {

    GLFWLoader.init()

    val timer = Timer()
    val window = WindowBuilder.build {
        title = "Example title"
        size = vec2Of(800, 600)
        vSync = false
    }


    while (!window.shouldClose()) {

        timer.tick()
        GLStateMachine.clear()
        window.setTitle("${timer.fps} FPS")

        window.swapBuffers()
        window.setDefaultViewport()
        EventManager.pollEvents()
    }

    GLFWLoader.terminate()
}