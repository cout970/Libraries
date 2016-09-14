package com.cout970.glutilities.shader

import org.lwjgl.opengl.GL11
import org.lwjgl.opengl.GL20
import org.lwjgl.opengl.GL32
import java.util.*

/**
 * Created by cout970 on 31/08/2016.
 */
class ShaderBuilder {

    private val programId = GL20.glCreateProgram()
    private val ids = mutableListOf<Int>()
    private val attributes = mutableMapOf<Int, String>()

    fun bindAttribute(slot: Int, name: String){
        attributes.put(slot, name)
    }

    fun compile(type: Int, code: String) {
        val shader = GL20.glCreateShader(type)
        GL20.glShaderSource(shader, code)
        GL20.glCompileShader(shader)
        if (GL20.glGetShaderi(shader, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
            val name = when (type) {
                GL20.GL_VERTEX_SHADER -> "Vertex"
                GL20.GL_FRAGMENT_SHADER -> "Fragment"
                GL32.GL_GEOMETRY_SHADER -> "Geometry"
                else -> "Unkknown"
            }
            val lines = code.split("\n")
            val finalCode = mutableListOf<String>()

            for (i in 0 until lines.size) {
                finalCode.add("%2d | ${lines[i]}\n".format(i))
            }
            throw IllegalStateException("Error trying to compile " + name + " shader: " + GL20.glGetShaderInfoLog(shader, 1000)+"CODE: \n" + finalCode.joinToString("") { it })
        }
        ids.add(shader)
    }

    fun build(): ShaderProgram {
        for (id in ids) {
            GL20.glAttachShader(programId, id)
        }
        for ((slot, name) in attributes) {
            GL20.glBindAttribLocation(programId, slot, name)
        }
        GL20.glLinkProgram(programId)
        GL20.glValidateProgram(programId)

        for (id in ids) {
            GL20.glDeleteShader(id)
        }
        return ShaderProgram(programId, ArrayList(ids))
    }

    companion object {
        fun build(func: ShaderBuilder.() -> Unit): ShaderProgram {
            val builder = ShaderBuilder()
            builder.func()
            return builder.build()
        }
    }
}