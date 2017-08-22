@file:Suppress("unused")

package com.cout970.vector.extensions

/**
 * Created by cout970 on 17/08/2016.
 */
object Vector2 {
    @JvmStatic val ORIGIN = vec2Of(0, 0)
    @JvmStatic val ZERO = vec2Of(0, 0)
    @JvmStatic val ONE = vec2Of(1, 1)

    @JvmStatic val X_AXIS = vec2Of(1, 0)
    @JvmStatic val Y_AXIS = vec2Of(0, 1)
    @JvmStatic val NEG_X_AXIS = vec2Of(-1, 0)
    @JvmStatic val NEG_Y_AXIS = vec2Of(0, -1)
}

object Vector3 {
    @JvmStatic val ORIGIN = vec3Of(0, 0, 0)
    @JvmStatic val ZERO = vec3Of(0, 0, 0)
    @JvmStatic val ONE = vec3Of(1, 1, 1)

    @JvmStatic val X_AXIS = vec3Of(1, 0, 0)
    @JvmStatic val Y_AXIS = vec3Of(0, 1, 0)
    @JvmStatic val Z_AXIS = vec3Of(0, 0, 1)
    @JvmStatic val NEG_X_AXIS = vec3Of(-1, 0, 0)
    @JvmStatic val NEG_Y_AXIS = vec3Of(0, -1, 0)
    @JvmStatic val NEG_Z_AXIS = vec3Of(0, 0, -1)
}

object Vector4 {
    @JvmStatic val ORIGIN = vec4Of(0, 0, 0, 0)
    @JvmStatic val ZERO = vec4Of(0, 0, 0, 0)
    @JvmStatic val ONE = vec4Of(1, 1, 1, 1)

    @JvmStatic val X_AXIS = vec4Of(1, 0, 0, 0)
    @JvmStatic val Y_AXIS = vec4Of(0, 1, 0, 0)
    @JvmStatic val Z_AXIS = vec4Of(0, 0, 1, 0)
    @JvmStatic val W_AXIS = vec4Of(0, 0, 0, 1)
    @JvmStatic val NEG_X_AXIS = vec4Of(-1, 0, 0, 0)
    @JvmStatic val NEG_Y_AXIS = vec4Of(0, -1, 0, 0)
    @JvmStatic val NEG_Z_AXIS = vec4Of(0, 0, -1, 0)
    @JvmStatic val NEG_W_AXIS = vec4Of(0, 0, 0, -1)
}

object Quaternion {
    @JvmStatic val IDENTITY = quatOf(0, 0, 0, 1)
}
