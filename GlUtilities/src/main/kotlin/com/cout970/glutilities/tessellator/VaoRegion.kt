package com.cout970.glutilities.tessellator

import org.lwjgl.opengl.GL11

/**
 * Created by cout970 on 02/09/2016.
 */
data class VaoRegion(
        val offset: Int,
        val vertexCount: Int,
        val drawMode: Int
) {

    fun draw(useElements: Boolean) {
        if (vertexCount <= 0) return
        if (useElements) {
            //TODO : test this i'm not sure if is going to work with the offset
            GL11.glDrawElements(drawMode, vertexCount, GL11.GL_UNSIGNED_INT, offset.toLong())
        } else {
            GL11.glDrawArrays(drawMode, offset, vertexCount)
        }
    }
}