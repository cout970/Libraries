package com.cout970.glutilities.tessellator.format

import com.cout970.glutilities.tessellator.Buffer
import com.cout970.glutilities.tessellator.IBuffer
import com.cout970.glutilities.tessellator.IFormat
import com.cout970.glutilities.tessellator.VaoBuilder

/**
 * Created by cout970 on 02/09/2016.
 *
 * This format is made of 2 components:
 * Position (3 elements), Color (3 elements)
 */
class FormatPC : IFormat {

    var bufferPos = Buffer(IBuffer.BufferType.FLOAT, 65536, 3)
    var bufferCol = Buffer(IBuffer.BufferType.FLOAT, 65536, 3)

    override fun getBuffers(): List<IBuffer> = listOf(bufferPos, bufferCol)

    override fun injectData(builder: VaoBuilder) {
        builder.bindAttribf(0, bufferPos.getBase().apply { flip() }, 3)
        builder.bindAttribf(1, bufferCol.getBase().apply { flip() }, 3)
    }

    override fun reset() {
        bufferPos.getBase().clear()
        bufferCol.getBase().clear()
    }
}