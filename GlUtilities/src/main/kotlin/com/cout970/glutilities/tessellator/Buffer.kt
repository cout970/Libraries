package com.cout970.glutilities.tessellator

import org.lwjgl.BufferUtils
import java.nio.ByteBuffer

/**
 * Created by cout970 on 02/09/2016.
 */
class Buffer(private val type: IBuffer.BufferType, maxElements: Int, private val elementsPerVertex : Int) : IBuffer {

    private val base = BufferUtils.createByteBuffer(maxElements * elementsPerVertex)

    override fun getBase(): ByteBuffer = base

    override fun getType(): IBuffer.BufferType = type

    override fun getElementsPerVertex(): Int = elementsPerVertex
}