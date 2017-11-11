package com.cout970.glutilities.memory

import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import java.nio.FloatBuffer
import java.nio.IntBuffer

inline fun <T> mallocInt(size: Int, block: (IntBuffer) -> T): T {
    val buff = MemoryUtil.memAllocInt(size)
    val res = block(buff)
    MemoryUtil.memFree(buff)
    return res
}

inline fun <T> mallocFloat(size: Int, block: (FloatBuffer) -> T): T {
    val buff = MemoryUtil.memAllocFloat(size)
    val res = block(buff)
    MemoryUtil.memFree(buff)
    return res
}

inline fun <T> stackAlloc(block: (MemoryStack)-> T): T{
    val base = MemoryStack.stackPush()
    val res = block(base)
    base.close()
    return res
}