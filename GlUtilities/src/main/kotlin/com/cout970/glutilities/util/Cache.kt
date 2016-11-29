package com.cout970.glutilities.util

/**
 * Created by cout970 on 30/08/2016.
 */
class Cache<out T>(val getter: () -> T) : Lazy<T> {

    var dirty = false

    override val value: T = getter()
        get() {
            if (dirty) {
                field = getter()
            }
            return field
        }

    override fun isInitialized(): Boolean = !dirty
}