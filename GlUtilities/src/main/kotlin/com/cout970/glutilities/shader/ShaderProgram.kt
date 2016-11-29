package com.cout970.glutilities.shader

import org.lwjgl.opengl.GL20
import java.io.Closeable

/**
 * Created by cout970 on 30/07/2016.
 */
/**
 * This class represents a shader program in OpenGL
 */
class ShaderProgram(
        val programID: Int,
        val ids: List<Int>
) : Closeable {

    /**
     * Starts the program, if other program is active, this will stop it
     */
    fun start() = GL20.glUseProgram(programID)

    /**
     * End the shader program
     */
    fun stop() = GL20.glUseProgram(0)

    /**
     * Creates an uniform variable representing a variable in the shader
     */
    fun createUniformVariable(name: String): UniformVariable {
        val id = GL20.glGetUniformLocation(programID, name)
        return UniformVariable(id)
    }

    /**
     * Creates an uniform variable representing an array
     */
    fun createUniformVariableArray(name: String): UniformVariable.UniformVariableArray {
        val id = GL20.glGetUniformLocation(programID, name)
        return UniformVariable.UniformVariableArray(id)
    }

    /**
     * Detaches the shader program and deletes the shaders
     */
    override fun close() {
        stop()
        for(i in ids){
            GL20.glDetachShader(programID, i)
        }
        GL20.glDeleteProgram(programID)
    }
}