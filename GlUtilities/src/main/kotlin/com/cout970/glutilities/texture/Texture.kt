package com.cout970.glutilities.texture

import com.cout970.vector.api.IVector2
import org.lwjgl.opengl.*

/**
 * Created by cout970 on 29/07/2016.
 */
data class Texture(
        val id: Int,
        val size: IVector2,
        val type: Int
) {
    var magFilter: Int = -1
        set(value) {
            GL11.glBindTexture(type, id)
            GL11.glTexParameteri(type, GL11.GL_TEXTURE_MAG_FILTER, value)
        }
    var minFilter: Int = -1
        set(value) {
            GL11.glBindTexture(type, id)
            GL11.glTexParameteri(type, GL11.GL_TEXTURE_MIN_FILTER, value)
        }
    var wrapS: Int = -1
        set(value) {
            GL11.glBindTexture(type, id)
            GL11.glTexParameteri(type, GL11.GL_TEXTURE_WRAP_S, value)
        }
    var wrapT: Int = -1
        set(value) {
            GL11.glBindTexture(type, id)
            GL11.glTexParameteri(type, GL11.GL_TEXTURE_WRAP_T, value)
        }
    var wrapW: Int = -1
        set(value) {
            GL11.glBindTexture(type, id)
            GL11.glTexParameteri(type, GL12.GL_TEXTURE_WRAP_R, value)
        }

    init {
        magFilter = GL11.GL_LINEAR
        minFilter = GL11.GL_LINEAR

        wrapS = GL11.GL_REPEAT
        wrapT = GL11.GL_REPEAT
        wrapW = GL11.GL_REPEAT
    }

    fun bind(layer: Int = 0) {
        GL13.glActiveTexture(GL13.GL_TEXTURE0 + layer)
        GL11.glBindTexture(type, id)
    }

    fun unbind(layer: Int = 0) {
        GL13.glActiveTexture(GL13.GL_TEXTURE0 + layer)
        GL11.glBindTexture(type, 0)
    }

    fun close(){
        GL11.glDeleteTextures(id)
    }

    companion object {

        //mag and min filter values
        val PIXELATED = GL11.GL_NEAREST
        val SMOOTH = GL11.GL_LINEAR

        //wrap S/T/R values
        val REPEAT = GL11.GL_REPEAT
        val REPEAT_MIRROR = GL14.GL_MIRRORED_REPEAT

        val CLAMP_TO_EDGE = GL12.GL_CLAMP_TO_EDGE
        val CLAMP_TO_EDGE_MIRROR = GL44.GL_MIRROR_CLAMP_TO_EDGE

        val CLAMP_TO_BORDER = GL13.GL_CLAMP_TO_BORDER

        fun unbind(layer: Int = 0, type: Int = GL11.GL_TEXTURE_2D) {
            GL13.glActiveTexture(GL13.GL_TEXTURE0 + layer)
            GL11.glBindTexture(type, 0)
        }
    }
}