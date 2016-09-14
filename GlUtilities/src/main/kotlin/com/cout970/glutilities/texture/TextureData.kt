package com.cout970.glutilities.texture

import com.cout970.vector.api.IVector2
import org.lwjgl.opengl.GL11
import java.nio.ByteBuffer

/**
 * Created by cout970 on 29/07/2016.
 */
/**
 * This class stores a bitmap of a texture, the size, the pixel format, the origin of the texture and the
 * output format used when this texture is uploaded to OpenGL
 */
data class TextureData(
        //The texture stored as a bitmap
        val bitMap: ByteBuffer,
        //The size of the texture, (width, height)
        val size: IVector2,
        //the format of the bitMap, for example GL11.GL_RGB or GL11.GL_RGBA
        val format: Int = GL11.GL_RGBA,
        //The format use to upload the texture to OpenGL, for example GL11.GL_RGB or GL11.GL_ALPHA
        val outputFormat: Int = GL11.GL_RGB
)