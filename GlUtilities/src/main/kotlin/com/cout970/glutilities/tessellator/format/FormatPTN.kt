package com.cout970.glutilities.tessellator.format

import com.cout970.glutilities.tessellator.Buffer
import com.cout970.glutilities.tessellator.IBuffer
import com.cout970.glutilities.tessellator.IFormat
import com.cout970.glutilities.tessellator.VaoBuilder

/**
 * Created by cout970 on 02/09/2016.
 *
 * This format is made of 3 components:
 * Position (3 elements), Texture (2 elements), Normal (3 elements)
 */
class FormatPTN : IFormat {

    var bufferPos = Buffer(IBuffer.BufferType.FLOAT, 65536, 3)
    var bufferTex = Buffer(IBuffer.BufferType.FLOAT, 65536, 2)
    var bufferNorm = Buffer(IBuffer.BufferType.FLOAT, 65536, 3)

    override fun getBuffers(): List<IBuffer> = listOf(bufferPos, bufferTex, bufferNorm)

    override fun injectData(builder: VaoBuilder) {
        builder.bindAttribf(0, bufferPos.getBase().apply { flip() }, 3)
        builder.bindAttribf(1, bufferTex.getBase().apply { flip() }, 2)
        builder.bindAttribf(2, bufferNorm.getBase().apply { flip() }, 3)
    }

    override fun reset() {
        bufferPos.getBase().clear()
        bufferTex.getBase().clear()
        bufferNorm.getBase().clear()
    }
}