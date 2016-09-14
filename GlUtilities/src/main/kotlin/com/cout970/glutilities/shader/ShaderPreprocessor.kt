package com.cout970.glutilities.shader

import java.io.InputStream

/**
 * Created by cout970 on 31/07/2016.
 *
 *
 * This object allow the user to have
 *  #include "file.glsl"
 * in a shader program
 */
object ShaderPreprocessor {

    val INCLUDE_PREFIX = "#include \""
    val INCLUDE_SUFFIX = "\""

    /**
     * Loads a shader from a resource
     */
    fun loadShader(resource: InputStream, dependencyResolver: (String) -> InputStream): String {
        return getLines(resource, dependencyResolver).joinToString("\n")
    }

    /**
     * Get all the lines of the shader
     */
    fun getLines(stream: InputStream, dependencyResolver: (String) -> InputStream): List<String> {
        val lines = mutableListOf<String>()

        stream.reader().forEachLine {
            if (it.startsWith(INCLUDE_PREFIX) && it.endsWith(INCLUDE_SUFFIX)) {
                val name = it.substring(INCLUDE_PREFIX.length, it.length - INCLUDE_SUFFIX.length)
                val code = getLines(dependencyResolver(name), dependencyResolver)
                lines.addAll(code)
            } else {
                lines.add(it)
            }
        }
        return lines
    }
}