package com.cout970.glutilities.shader

import com.cout970.matrix.api.IMatrix4
import com.cout970.vector.api.IVector2
import com.cout970.vector.api.IVector3
import org.lwjgl.opengl.GL20.*
import org.lwjgl.system.MemoryUtil

/**
 * Created by cout970 on 30/07/2016.
 */
/**
 * This class represents a variable inside a shader
 */
open class UniformVariable(val uniformID: Int) {

    /**
     * Stores a float in the variable
     */
    fun setFloat(f: Float) = glUniform1f(uniformID, f)

    /**
     * Stores a int in the variable
     */
    fun setInt(i: Int) = glUniform1i(uniformID, i)

    /**
     * Stores a Vector2 in the variable
     */
    fun setVector2(f: IVector2) = glUniform2f(uniformID, f.xf, f.yf)

    /**
     * Stores a Vector3 in the variable
     */
    fun setVector3(f: IVector3) = glUniform3f(uniformID, f.xf, f.yf, f.zf)

    /**
     * Stores a 1 or 0 in the variable
     */
    fun setBoolean(bool: Boolean) = glUniform1f(uniformID, if (bool) 1f else 0f)

    /**
     * Stores a Matrix4d in the variable
     */
    fun setMatrix4(m: IMatrix4) {
        val buffer = MemoryUtil.memAllocFloat(16)
        buffer.put(m.m00f)
        buffer.put(m.m01f)
        buffer.put(m.m02f)
        buffer.put(m.m03f)
        buffer.put(m.m10f)
        buffer.put(m.m11f)
        buffer.put(m.m12f)
        buffer.put(m.m13f)
        buffer.put(m.m20f)
        buffer.put(m.m21f)
        buffer.put(m.m22f)
        buffer.put(m.m23f)
        buffer.put(m.m30f)
        buffer.put(m.m31f)
        buffer.put(m.m32f)
        buffer.put(m.m33f)
        buffer.flip()
        glUniformMatrix4fv(uniformID, false, buffer)
        MemoryUtil.memFree(buffer)
    }

    class UniformVariableArray(uniformID: Int) : UniformVariable(uniformID) {

        fun setFloat(index: Int, f: Float) = glUniform1f(uniformID + index, f)

        fun setInt(index: Int, i: Int) = glUniform1i(uniformID + index, i)

        fun setVector2(index: Int, f: IVector2) = glUniform2f(uniformID + index, f.xf, f.yf)

        fun setVector3(index: Int, f: IVector3) = glUniform3f(uniformID + index, f.xf, f.yf, f.zf)

        fun setBoolean(index: Int, bool: Boolean) = glUniform1f(uniformID + index, (if (bool) 1 else 0).toFloat())

        fun setMatrix4(index: Int, m: IMatrix4) {
            val buffer = MemoryUtil.memAllocFloat(16)
            buffer.put(m.m00f)
            buffer.put(m.m01f)
            buffer.put(m.m02f)
            buffer.put(m.m03f)
            buffer.put(m.m10f)
            buffer.put(m.m11f)
            buffer.put(m.m12f)
            buffer.put(m.m13f)
            buffer.put(m.m20f)
            buffer.put(m.m21f)
            buffer.put(m.m22f)
            buffer.put(m.m23f)
            buffer.put(m.m30f)
            buffer.put(m.m31f)
            buffer.put(m.m32f)
            buffer.put(m.m33f)
            buffer.flip()
            glUniformMatrix4fv(uniformID + index, false, buffer)
            MemoryUtil.memFree(buffer)
        }
    }
}