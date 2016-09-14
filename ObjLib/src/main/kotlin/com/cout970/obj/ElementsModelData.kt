package com.cout970.obj

import com.cout970.vector.impl.Vector2f
import com.cout970.vector.impl.Vector3f
import java.util.*

/**
 * Created by cout970 on 02/09/2016.
 */
class ElementsModelData {

    val vertices: MutableList<Struct> = ArrayList()
    val indices: MutableList<Int> = ArrayList()


    data class Struct(val vertex: Vector3f, val texture: Vector2f, val normal: Vector3f)
}