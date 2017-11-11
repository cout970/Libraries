package com.cout970.glutilities.memory

import com.cout970.vector.api.IVector2
import com.cout970.vector.api.IVector3
import com.cout970.vector.api.IVector4
import com.cout970.vector.extensions.vec2Of
import com.cout970.vector.extensions.vec3Of
import com.cout970.vector.extensions.vec4Of
import org.lwjgl.BufferUtils
import java.io.InputStream
import java.nio.ByteBuffer
import java.nio.channels.Channels

/**
 * Created by cout970 on 31/08/2016.
 */


/**
 * Expands the size of a buffer
 */
fun ByteBuffer.expand(newSize: Int): ByteBuffer {
    this.flip()
    return BufferUtils.createByteBuffer(newSize).put(this)
}

inline fun ByteBuffer.forEachVector4(func: (IVector4) -> Unit) {
    while (hasRemaining()) {
        func(vec4Of(double, double, double, double))
    }
}

inline fun ByteBuffer.forEachVector3(func: (IVector3) -> Unit) {
    while (hasRemaining()) {
        func(vec3Of(double, double, double))
    }
}

inline fun ByteBuffer.forEachVector2(func: (IVector2) -> Unit) {
    while (hasRemaining()) {
        func(vec2Of(double, double))
    }
}

/**
 * Reads a Vector4 from the buffer
 */
fun ByteBuffer.readVector4() = vec4Of(double, double, double, double)

/**
 * Writes a Vector4 from the buffer
 */
fun ByteBuffer.writeVector4(vec: IVector4) {
    putDouble(vec.xd); putDouble(vec.yd); putDouble(vec.zd); putDouble(vec.wd)
}

/**
 * Reads a Vector3 from the buffer
 */
fun ByteBuffer.readVector3() = vec3Of(double, double, double)

/**
 * Writes a Vector3 from the buffer
 */
fun ByteBuffer.writeVector3(vec: IVector3) {
    putDouble(vec.xd); putDouble(vec.yd); putDouble(vec.zd)
}

/**
 * Reads a Vector2 from the buffer
 */
fun ByteBuffer.readVector2() = vec2Of(double, double)

/**
 * Writes a Vector2 from the buffer
 */
fun ByteBuffer.writeVector2(vec: IVector2) {
    putDouble(vec.xd); putDouble(vec.yd)
}

/**
 * Writes all the data extracted from the input stream and stores it into the buffer
 */
fun InputStream.toByteBuffer(): ByteBuffer {

    var buffer = BufferUtils.createByteBuffer(1024)
    val rbc = Channels.newChannel(this)
    while (true) {
        val r = rbc.read(buffer)
        if (r == -1) break
        if (buffer.remaining() == 0) {
            buffer = buffer.expand(buffer.capacity() * 2)
        }
    }
    rbc.close()
    return buffer
}