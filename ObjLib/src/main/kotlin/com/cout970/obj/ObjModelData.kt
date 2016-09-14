package com.cout970.obj

import com.cout970.vector.impl.Vector2f
import com.cout970.vector.impl.Vector3f
import java.util.*

/**
 * Created by cout970 on 29/02/2016.
 */

class ObjModelData {

    val vertices: MutableList<Vector3f> = ArrayList()
    val normals: MutableList<Vector3f> = ArrayList()
    val texCoords: MutableList<Vector2f> = ArrayList()
    val faces: MutableList<Face> = ArrayList()

    fun toElementsModelData(): ElementsModelData {
        val model = ElementsModelData()
        val map = HashMap<ElementsModelData.Struct, Int>()
        var count = 0
        val nullTexture = Vector2f(0f, 0f)
        val nullNormal = Vector3f(0f, 1f, 0f)

        for (vertexList in faces) {
            for ((vertex, texture, normal) in vertexList) {
                val struct = ElementsModelData.Struct(vertices[vertex], texCoords.getOrElse(texture) { nullTexture }, normals.getOrElse(normal) { nullNormal })
                val index: Int
                if(struct in map){
                    index = map[struct]!!
                }else{
                    index = count++
                    map.put(struct, index)
                    model.vertices.add(struct)
                }
                model.indices.add(index)
            }
        }

        return model
    }
}
