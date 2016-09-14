package com.cout970.glutilities.tessellator

import org.lwjgl.opengl.GL15
import org.lwjgl.opengl.GL20
import org.lwjgl.opengl.GL30
import java.io.Closeable

/**
 * Created by cout970 on 30/07/2016.
 */
//TODO add an object to store data about several calls to glDrawArrays
data class VAO(
        val id: Int,
        val vboCount: Int,
        val vbos: List<Int>,
        val useElements: Boolean,
        val regions: List<VaoRegion>
) : Closeable {

    companion object {
        fun unbind(){
            GL30.glBindVertexArray(0)
        }
    }

    fun bind(){
        GL30.glBindVertexArray(id)
    }

    fun bindAttrib(){
        for(i in 0 until vbos.size) {
            GL20.glEnableVertexAttribArray(i)
        }
    }

    fun unbindAttrib(){
        for(i in 0 until vbos.size) {
            GL20.glDisableVertexAttribArray(i)
        }
    }

    fun draw(){
        for(i in regions){
            i.draw(useElements)
        }
    }

    override fun close() {
        GL30.glDeleteVertexArrays(id)
        for (aVbo in vbos) {
            GL15.glDeleteBuffers(aVbo)
        }
    }
}