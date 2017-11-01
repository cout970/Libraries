package com.cout970.glutilities.tessellator

import org.lwjgl.opengl.GL11
import org.lwjgl.opengl.GL15
import org.lwjgl.opengl.GL20
import org.lwjgl.opengl.GL30
import java.nio.ByteBuffer
import java.nio.FloatBuffer
import java.nio.IntBuffer

/**
 * Created by cout970 on 30/07/2016.
 */
class VaoBuilder(private val longUse: Boolean = true) {

    private var id: Int = GL30.glGenVertexArrays()
    private val buffers = mutableListOf<Int>()
    private val regions = mutableListOf<VaoRegion>()
    private var useElements: Boolean = false
    private var lastIndex = 0

    init {
        GL30.glBindVertexArray(id)
    }

    fun addRegion(drawMode: DrawMode, count: Int){
        val reg = VaoRegion(lastIndex, count, drawMode)
        lastIndex += count
        regions.add(reg)
    }

    fun bindIndices(indices: IntBuffer): VaoBuilder {
        val vbo = GL15.glGenBuffers()
        useElements = true

        buffers.add(vbo)

        GL30.glBindVertexArray(id)

        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vbo)
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, indices, if (longUse) GL15.GL_STATIC_DRAW else GL15.GL_STREAM_DRAW)

        GL30.glBindVertexArray(0)
        return this
    }

    fun bindAttrib(slot: Int, buffer: FloatBuffer, elementsPerVertex: Int): VaoBuilder {
        val vbo = GL15.glGenBuffers()
        buffers.add(vbo)

        GL30.glBindVertexArray(id)

        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo)

        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, if (longUse) GL15.GL_STATIC_DRAW else GL15.GL_STREAM_DRAW)
        GL20.glVertexAttribPointer(slot, elementsPerVertex, GL11.GL_FLOAT, false, 0, 0)

        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0)

        GL30.glBindVertexArray(0)
        return this
    }

    fun bindAttrib(slot: Int, buffer: IntBuffer, elementsPerVertex: Int): VaoBuilder {
        val vbo = GL15.glGenBuffers()
        buffers.add(vbo)

        GL30.glBindVertexArray(id)

        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo)

        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, if (longUse) GL15.GL_STATIC_DRAW else GL15.GL_STREAM_DRAW)
        GL20.glVertexAttribPointer(slot, elementsPerVertex, GL11.GL_INT, false, 0, 0)

        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0)

        GL30.glBindVertexArray(0)
        return this
    }

    fun bindAttribf(slot: Int, buffer: ByteBuffer, elementsPerVertex: Int): VaoBuilder {
        val vbo = GL15.glGenBuffers()
        buffers.add(vbo)

        GL30.glBindVertexArray(id)

        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo)

        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, if (longUse) GL15.GL_STATIC_DRAW else GL15.GL_STREAM_DRAW)
        GL20.glVertexAttribPointer(slot, elementsPerVertex, GL11.GL_FLOAT, false, 0, 0)

        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0)

        GL30.glBindVertexArray(0)
        return this
    }

    fun bindAttribi(slot: Int, buffer: ByteBuffer, elementsPerVertex: Int): VaoBuilder {
        val vbo = GL15.glGenBuffers()
        buffers.add(vbo)

        GL30.glBindVertexArray(id)

        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo)

        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, if (longUse) GL15.GL_STATIC_DRAW else GL15.GL_STREAM_DRAW)
        GL20.glVertexAttribPointer(slot, elementsPerVertex, GL11.GL_INT, false, 0, 0)

        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0)

        GL30.glBindVertexArray(0)
        return this
    }

    fun build(): VAO = VAO(id, buffers.size, buffers, useElements, regions)
}