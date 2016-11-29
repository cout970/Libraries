package com.example

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.lwjgl.glfw.GLFW
import kotlin.test.assertEquals

/**
 * Created by cout970 on 2016/09/03.
 */
//Doesn't work ):
//I will wait for kobalt to support Spek
class LibraryTest() : Spek({

    describe("Initializing GLFW") {
        it("Inits") {
            assertEquals(GLFW.glfwInit(), true)
        }
    }
})

