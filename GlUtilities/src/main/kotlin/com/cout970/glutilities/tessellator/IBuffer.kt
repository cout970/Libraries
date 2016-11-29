package com.cout970.glutilities.tessellator

import java.nio.ByteBuffer

/**
 * Created by cout970 on 02/09/2016.
 */
interface IBuffer {

    fun getBase(): ByteBuffer

    fun getType(): BufferType

    fun getElementsPerVertex(): Int

    enum class BufferType{
        BYTE,
        SHORT,
        INT,
        FLOAT
    }
}