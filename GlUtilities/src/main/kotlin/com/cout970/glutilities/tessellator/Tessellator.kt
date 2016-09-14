package com.cout970.glutilities.tessellator

import org.lwjgl.opengl.GL11
import java.nio.ByteBuffer
import java.nio.FloatBuffer
import java.nio.IntBuffer
import java.nio.ShortBuffer
import java.util.function.Consumer


/**
 * Created by cout970 on 30/07/2016.
 */

class Tessellator : ITessellator {

    private var format: IFormat? = null
    private val buffers = mutableListOf<Pair<IBuffer, Any>>()
    private val regions = mutableListOf<VaoRegion>()
    private var index = 0
    private var drawMode = -1

    override fun start(format: IFormat) {
        this.format = format
        format.reset()
        reset()
        buffers.addAll(format.getBuffers().map {
            it to when (it.getType()) {
                IBuffer.BufferType.BYTE -> it.getBase()
                IBuffer.BufferType.SHORT -> it.getBase().asShortBuffer()
                IBuffer.BufferType.INT -> it.getBase().asIntBuffer()
                IBuffer.BufferType.FLOAT -> it.getBase().asFloatBuffer()
            }
        })
    }

    override fun newSection(drawMode: Int) {
        if (this.drawMode != -1) {
            val last = if (regions.isEmpty()) 0 else regions.last().run { offset + vertexCount }
            regions.add(VaoRegion(index, index - last, drawMode))
        }
        this.drawMode = drawMode
    }

    override fun set(slot: Int, vararg data: Number): ITessellator {
        require(slot < buffers.size) { "Invalid Slot" }
        buffers[slot].run {
            val index = index * first.getElementsPerVertex()
            for (i in 0 until first.getElementsPerVertex()) {
                when (first.getType()) {
                    IBuffer.BufferType.BYTE -> {
                        (second as ByteBuffer).put(index + i, data[i].toByte())
                        first.getBase().position(index + first.getElementsPerVertex())
                    }
                    IBuffer.BufferType.SHORT -> {
                        (second as ShortBuffer).put(index + i, data[i].toShort())
                        first.getBase().position(2 * (index + first.getElementsPerVertex()))
                    }
                    IBuffer.BufferType.INT -> {
                        (second as IntBuffer).put(index + i, data[i].toInt())
                        first.getBase().position(4 * (index + first.getElementsPerVertex()))
                    }
                    IBuffer.BufferType.FLOAT -> {
                        (second as FloatBuffer).put(index + i, data[i].toFloat())
                        first.getBase().position(4 * (index + first.getElementsPerVertex()))
                    }
                }
            }
        }
        return this
    }

    override fun endVertex() {
        index++
    }

    override fun finish(builder: VaoBuilder) {
        val last = if (regions.isEmpty()) 0 else regions.last().run { offset + vertexCount }
        regions.add(VaoRegion(index, index - last, drawMode))

        format!!.injectData(builder)
        for ((offset, vertexCount, drawMode) in regions) {
            builder.addRegion(drawMode, vertexCount)
        }
    }

    private fun reset() {
        buffers.clear()
        regions.clear()
        drawMode = -1
        index = 0
    }

    fun compile(drawMode: Int = GL11.GL_TRIANGLES, format: IFormat, func: ITessellator.() -> Unit): VAO {
        start(format)
        newSection(drawMode)
        func()
        val builder = VaoBuilder(true)
        finish(builder)
        return builder.build()
    }

    fun draw(drawMode: Int = GL11.GL_TRIANGLES, format: IFormat, renderer: Consumer<VAO>, func: ITessellator.() -> Unit) {
        start(format)
        newSection(drawMode)
        func()
        val builder = VaoBuilder(false)
        finish(builder)
        val vao = builder.build()
        renderer.accept(vao)
        vao.close()
    }
}