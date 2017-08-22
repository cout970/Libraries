package com.cout970.glutilities.texture

import com.cout970.glutilities.util.toByteBuffer
import com.cout970.vector.extensions.vec2Of
import org.lwjgl.BufferUtils
import org.lwjgl.opengl.GL11.*
import org.lwjgl.opengl.GL13.GL_TEXTURE_CUBE_MAP
import org.lwjgl.opengl.GL13.GL_TEXTURE_CUBE_MAP_POSITIVE_X
import org.lwjgl.stb.STBImage
import org.lwjgl.stb.STBTTBakedChar
import org.lwjgl.stb.STBTruetype
import java.io.InputStream

/**
 * Created by cout970 on 29/07/2016.
 *
 * Basic class to Load texture files and upload the textures to OpenGL
 */
object TextureLoader {


    /**
     * Loads a Texture from a InputStream, resource is used to store the location of the image
     */
    fun loadTexture(data: InputStream): TextureData {
        val image = data.toByteBuffer().apply { flip() }

        if (!STBImage.stbi_info_from_memory(image, IntArray(1), IntArray(1), IntArray(1))) {
            throw IllegalStateException("Failed to load image information, Error: " + STBImage.stbi_failure_reason())
        }

        val width = BufferUtils.createIntBuffer(1)
        val height = BufferUtils.createIntBuffer(1)
        val byteDepth = BufferUtils.createIntBuffer(1)

        val bitmap = STBImage.stbi_load_from_memory(image, width, height, byteDepth, 4) ?:
                throw IllegalStateException("Failed to load image, Error: " + STBImage.stbi_failure_reason())

        return TextureData(bitmap, vec2Of(width[0], height[0]), GL_RGBA, GL_RGBA)
    }

    /**
     * Loads a True Type Font (.ttf) from a resource
     */
    fun loadTrueType(inputStream: InputStream, texSize: Int = 512, charHeight: Float = 8f, cdata: STBTTBakedChar.Buffer): TextureData {
        val ttf = inputStream.toByteBuffer().apply { flip() }
        val bitmap = BufferUtils.createByteBuffer(texSize * texSize)

        STBTruetype.stbtt_BakeFontBitmap(ttf, charHeight, bitmap, texSize, texSize, 32, cdata)
        return TextureData(bitmap, vec2Of(texSize.toDouble()), GL_ALPHA, GL_ALPHA)
    }

    /**
     * Uploads the texture bitmap to OpenGL as a 1D texture
     */
    fun uploadTexture1D(data: TextureData, mipMaps: Int = 1): Texture {
        val id = glGenTextures()
        glBindTexture(GL_TEXTURE_1D, id)
//        GL42.glTexStorage1D(GL_TEXTURE_1D, mipMaps, data.outputFormat, 600)
        glTexImage1D(GL_TEXTURE_1D, 0, data.format, data.size.xi, 0, data.outputFormat, GL_UNSIGNED_BYTE, data.bitMap)
//        GL30.glGenerateMipmap(GL_TEXTURE_1D)

        return Texture(id, data.size, GL_TEXTURE_1D)
    }

    /**
     * Uploads the texture bitmap to OpenGL as a 2D texture
     */
    fun uploadTexture2D(data: TextureData, mipMaps: Int = 1): Texture {
        val id = glGenTextures()
        glBindTexture(GL_TEXTURE_2D, id)
        glTexImage2D(GL_TEXTURE_2D, 0, data.format, data.size.xi, data.size.yi, 0, data.outputFormat, GL_UNSIGNED_BYTE, data.bitMap)
//        GL30.glGenerateMipmap(GL_TEXTURE_2D)
        return Texture(id, data.size, GL_TEXTURE_2D)
    }

    /**
     * Uploads 6 textures to OpenGL to create a Texture Cube Map
     */
    fun uploadTextureCubeMap(datas: List<TextureData>): Texture {
        val id = glGenTextures()
        glBindTexture(GL_TEXTURE_CUBE_MAP, id)
        for (i in 0..5) {
            val data = datas[i]
            glTexImage2D(GL_TEXTURE_CUBE_MAP_POSITIVE_X + i, 0, data.format, data.size.xi, data.size.yi, 0, data.outputFormat, GL_UNSIGNED_BYTE, data.bitMap)
        }
//        GL30.glGenerateMipmap(GL13.GL_TEXTURE_CUBE_MAP)

        return Texture(id, datas[0].size, GL_TEXTURE_CUBE_MAP)
    }
}