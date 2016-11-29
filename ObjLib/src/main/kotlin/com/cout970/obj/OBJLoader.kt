package com.cout970.obj

import com.cout970.vector.impl.Vector2f
import com.cout970.vector.impl.Vector3f
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

/**
 * Created by cout970 on 29/02/2016.
 *
 */
object OBJLoader {

    internal val separator = "/"
    internal val sVertex = "v "
    internal val sNormal = "vn "
    internal val sTexture = "vt "
    internal val sFace = "f "
    internal val sComment = "#"
    internal val startIndex = 1 //index after label

    fun load(inputStream: InputStream): ObjModelData {

        val file = BufferedReader(InputStreamReader(inputStream))
        val model = ObjModelData()
        var hasNormals = false
        var hasTexture = false

        file.useLines {
            for (line in it) {
                val p = line.split(" ")

                if (line.startsWith(sVertex)) { //vertex

                    //reads a vertex
                    model.vertices.add(Vector3f(parseFloat(p[startIndex]),
                            parseFloat(p[startIndex + 1]),
                            parseFloat(p[startIndex + 2])))

                } else if (line.startsWith(sNormal)) { //normals

                    //reads a normal vector
                    hasNormals = true
                    model.normals.add(Vector3f(parseFloat(p[startIndex]),
                            parseFloat(p[startIndex + 1]),
                            parseFloat(p[startIndex + 2])))

                } else if (line.startsWith(sTexture)) { //textures

                    //reads a texture coords
                    hasTexture = true
                    model.texCoords.add(Vector2f(parseFloat(p[startIndex]),
                            parseFloat(p[startIndex + 1])))

                } else if (line.startsWith(sFace)) { //faces

                    val vertexList = Face()
                    for (i in 1 until p.size) {
                        val chunk = p[i]
                        val comp = chunk.split(separator)
                        val vertex: Vertex

                        if (hasNormals && hasTexture) {
                            vertex = Vertex(parseInt(comp[0]) - 1, parseInt(comp[1]) - 1, parseInt(comp[2]) - 1)
                        } else if (!hasTexture && hasNormals) {
                            vertex = Vertex(parseInt(comp[0]) - 1, -1, parseInt(comp[1]) - 1)
                        } else if (hasTexture && !hasNormals) {
                            vertex = Vertex(parseInt(comp[0]) - 1, parseInt(comp[1]) - 1, -1)
                        } else {
                            vertex = Vertex(parseInt(comp[0]) - 1, -1, -1)
                        }
                        vertexList.add(vertex)
                    }
                    model.faces.add(vertexList)
                } else if (!line.startsWith(sComment) && !line.isEmpty()) {
                    println("Ignoring line: '$line'\n")
                }
            }
        }
        return model
    }

    private fun parseFloat(str: String): Float = java.lang.Float.valueOf(str)
    private fun parseInt(str: String): Int = Integer.valueOf(str)
}
