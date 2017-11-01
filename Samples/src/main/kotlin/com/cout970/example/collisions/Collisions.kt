package com.cout970.example.collisions

import com.cout970.collision.internal.Frustum
import com.cout970.collision.internal.MutableBox3
import com.cout970.glutilities.device.Mouse
import com.cout970.glutilities.event.EventManager
import com.cout970.glutilities.shader.ShaderBuilder
import com.cout970.glutilities.shader.ShaderProgram
import com.cout970.glutilities.structure.GLStateMachine
import com.cout970.glutilities.structure.Timer
import com.cout970.glutilities.tessellator.VaoConsumer
import com.cout970.glutilities.window.GLFWLoader
import com.cout970.glutilities.window.WindowBuilder
import com.cout970.vector.extensions.*
import org.lwjgl.opengl.GL20

/**
 * Created by cout970 on 2017/11/01.
 */

data class State(var rot: Double = 0.0)

fun main(args: Array<String>) {

    GLFWLoader.init()
    val window = WindowBuilder.build {
        size = vec2Of(800, 600)
    }

    val mouse = Mouse(window.id)

    val shader = ShaderBuilder.build {
        compile(GL20.GL_VERTEX_SHADER, shader_vertex)
        compile(GL20.GL_FRAGMENT_SHADER, shader_fragment)
        bindAttribute(0, "pos")
        bindAttribute(1, "color")
    }

    val consumer = VaoConsumer()

    val frustum = Frustum(Math.toRadians(20.0), 800.0 / 600.0, 0.1, 0.3)

    val boxes = (0..512).map {
        val pos = vec3Of(
                x = ((it % 16) - 8) * 1 / 20.0,
                y = ((it / 16) - 8) * 1 / 20.0,
                z = 0
        )
        MutableBox3(pos, vec3Of(0.05), Quaternion.IDENTITY)
    }
    val timer = Timer()
    val state = State()

    GLStateMachine.clearColor = vec4Of(0,1,1,1)
    GLStateMachine.cullFace.disable()

    while (!window.shouldClose()) {
        GLStateMachine.clear()

        timer.tick()
        window.setTitle("FPS: [${timer.fps}]")

        update(state, mouse, frustum)

        render(state, shader, boxes, consumer)

        window.swapBuffers()
        EventManager.pollEvents()
    }

    GLFWLoader.terminate()
}

private fun update(state: State, mouse: Mouse, frustum: Frustum){
    mouse.update()
    state.rot += 0.25

    val baseRotation = vec4Of(0, 1, 0, Math.toRadians(90.0)).fromAxisAngToQuat()
    val currentRotation = vec4Of(1, 0, 0, Math.toRadians(state.rot)).fromAxisAngToQuat()
    frustum.rotation = baseRotation * currentRotation
}

private fun render(state: State, shader: ShaderProgram, boxes: List<MutableBox3>, consumer: VaoConsumer){
    shader.start()
//    var c = vec3Of(0)
//
//    t.draw(GL11.GL_LINES, FormatPC(), consumer) {
//        //+x
//        set(0, 0, 0, 0).set(1, 1, 0, 0).endVertex()
//        set(0, 1, 0, 0).set(1, 1, 0, 0).endVertex()
//        //+y
//        set(0, 0, 0, 0).set(1, 0, 1, 0).endVertex()
//        set(0, 0, 1, 0).set(1, 0, 1, 0).endVertex()
//        //+z
//        set(0, 0, 0, 0).set(1, 0, 0, 1).endVertex()
//        set(0, 0, 0, 1).set(1, 0, 0, 1).endVertex()
//
//        var time = System.nanoTime()
//        for (box in boxes) {
//            if (frustum.collide(box)) {
//                c = vec3Of(1, 0, 0)
//            } else {
//                c = vec3Of(1)
//            }
//
//            for (i in box.getEdges()) {
//                set(0, i.first.x, i.first.y, i.first.z).set(1, c.x, c.y, c.z).endVertex()
//                set(0, i.second.x, i.second.y, i.second.z).set(1, c.x, c.y, c.z).endVertex()
//            }
//        }
//        time = System.nanoTime() - time
//        println("time: ${time / (1000 * 1000 * 1000.0)}")
//        c = vec3Of(0, 1, 0)
//
//        for (i in frustum.getEdges()) {
//            set(0, i.first.x, i.first.y, i.first.z).set(1, c.x, c.y, c.z).endVertex()
//            set(0, i.second.x, i.second.y, i.second.z).set(1, c.x, c.y, c.z).endVertex()
//        }
//
//    }
    shader.stop()
}

private val shader_vertex = """
#version 400 core

in vec3 pos;
in vec3 color;

out vec3 pass_color;

void main(){
    gl_Position = vec4(pos, 1.0);
    pass_color = color;
}
"""

private val shader_fragment = """
#version 400 core

in vec3 pass_color;

out vec4 pixel;

void main(){
    pixel = vec4(pass_color, 1.0);
}
"""