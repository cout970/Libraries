package com.example

import com.cout970.glutilities.device.Mouse
import com.cout970.glutilities.event.EventManager
import com.cout970.glutilities.shader.ShaderBuilder
import com.cout970.glutilities.structure.GLStateMachine
import com.cout970.glutilities.structure.Timer
import com.cout970.glutilities.tessellator.Tessellator
import com.cout970.glutilities.tessellator.VAO
import com.cout970.glutilities.tessellator.format.FormatPT
import com.cout970.glutilities.texture.Texture
import com.cout970.glutilities.texture.TextureLoader
import com.cout970.glutilities.window.GLFWLoader
import com.cout970.glutilities.window.WindowBuilder
import com.cout970.vector.extensions.vec2Of
import com.cout970.vector.extensions.xi
import com.cout970.vector.extensions.yi
import org.lwjgl.opengl.GL11
import org.lwjgl.opengl.GL20
import java.io.FileInputStream
import java.util.*

fun main(args: Array<String>) {
    System.setProperty("org.lwjgl.librarypath", "I:/newWorkspace/Proyectos/Java_Kotlin/XLM/xlm/libs/native")
    Game2.init()
}

object Game2 {

    lateinit var tessellator: Tessellator
    val tasks = Collections.synchronizedList(mutableListOf<() -> Unit>())
    val timer = Timer()

    fun init() {
        GLFWLoader.init()
        val window = WindowBuilder.build {
            size = vec2Of(600, 600)
            vSync = false
        }

        val mouse = Mouse(window.id)
        tessellator = Tessellator()

        val shader = ShaderBuilder.build {
            compile(GL20.GL_VERTEX_SHADER, shader_vertex)
            compile(GL20.GL_FRAGMENT_SHADER, shader_fragment)
            bindAttribute(0, "pos")
            bindAttribute(1, "tex")
        }

        val consumer = java.util.function.Consumer<VAO> {
            it.bind()
            it.bindAttrib()
            it.draw()
            it.unbindAttrib()
            VAO.unbind()
        }


        GLStateMachine.cullFace.disable()

        GL11.glEnable(GL11.GL_TEXTURE_2D)

        var data = TextureLoader.loadTexture(FileInputStream("tex.png"))
        val texture = TextureLoader.uploadTexture2D(data)
        data = TextureLoader.loadTexture(FileInputStream("tests.png"))
        val texture1 = TextureLoader.uploadTexture2D(data)

        texture.magFilter = Texture.PIXELATED
        texture.minFilter = Texture.PIXELATED
        texture.wrapS = Texture.REPEAT
        texture.wrapT = Texture.REPEAT

        texture1.magFilter = Texture.PIXELATED
        texture1.minFilter = Texture.PIXELATED
        texture1.wrapS = Texture.REPEAT
        texture1.wrapT = Texture.REPEAT

        while (!window.shouldClose()) {
            GLStateMachine.clear()

            while (true) {
                val str = GLStateMachine.pollErrors() ?: break
                println(str)
            }
            timer.tick()
            mouse.update()

//            GL11.glEnable(GL11.GL_DEPTH_TEST)
            GL11.glEnable(GL11.GL_BLEND)
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA)
//
            shader.start()
            //no transparency
            texture1.bind()
            tessellator.draw(GL11.GL_QUADS, FormatPT(), consumer) {
                set(0, -0.9, -0.9, 0).set(1, 1, 0).endVertex()
                set(0, 0.9, -0.9, 0).set(1, 1, 1).endVertex()
                set(0, 0.9, 0.9, 0).set(1, 0, 1).endVertex()
                set(0, -0.9, 0.9, 0).set(1, 0, 0).endVertex()
            }

//            GL11.glDisable(GL11.GL_DEPTH_TEST)
            //texture transparency

            texture.bind()
            tessellator.draw(GL11.GL_QUADS, FormatPT(), consumer) {
                set(0, -0.5, -0.5, 0).set(1, 1, 0).endVertex()
                set(0, 0.5, -0.5, 0).set(1, 1, 1).endVertex()
                set(0, 0.5, 0.5, 0).set(1, 0, 1).endVertex()
                set(0, -0.5, 0.5, 0).set(1, 0, 0).endVertex()
            }

//            GL11.glDepthMask(false)
            // transparent
            texture.bind()
            tessellator.draw(GL11.GL_QUADS, FormatPT(), consumer) {
                set(0, 0, 0, 0).set(1, 1, 0).endVertex()
                set(0, 0.8, 0, 0).set(1, 1, 1).endVertex()
                set(0, 0.8, 0.8, 0).set(1, 0, 1).endVertex()
                set(0, 0, 0.8, 0).set(1, 0, 0).endVertex()
            }
//            GL11.glDepthMask(true)

            shader.stop()
            window.setTitle("FPS: [${timer.fps}]")

            window.swapBuffers()
            val fbs = window.getFrameBufferSize()
            GL11.glViewport(0, 0, fbs.xi, fbs.yi)

            tasks.removeAll { it.invoke(); true }

            EventManager.pollEvents()
        }

        GLFWLoader.terminate()
    }

    internal val shader_vertex = """
#version 400 core

in vec3 pos;
in vec2 tex;

out vec2 pass_tex;

void main(){
    gl_Position = vec4(pos, 1.0);
    pass_tex = tex;
}
        """

    internal val shader_fragment = """
#version 400 core

in vec2 pass_tex;

out vec4 pixel;

uniform sampler2D sampler;

void main(){
    vec4 te = texture(sampler, pass_tex);
    //if(te.w < 0.1) discard;
    pixel = te;
}
        """
}
