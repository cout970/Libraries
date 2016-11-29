package com.example

import com.cout970.glutilities.event.EventManager
import com.cout970.glutilities.structure.GLStateMachine
import com.cout970.glutilities.window.GLFWLoader
import com.cout970.glutilities.window.WindowBuilder
import com.cout970.vector.extensions.vec2Of

/**
 * Created by cout970 on 30/08/2016.
 */

fun main(args: Array<String>) {

    GLFWLoader.init()
    val window = WindowBuilder.build {
        size = vec2Of(800, 600)
    }

    while (!window.shouldClose()) {

        GLStateMachine.clear()

        window.swapBuffers()
        EventManager.pollEvents()
    }

    GLFWLoader.terminate()
}