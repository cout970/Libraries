package com.cout970.glutilities.tessellator

import org.lwjgl.opengl.GL11.*

/**
 * Created by cout970 on 2017/11/01.
 */
enum class DrawMode(val glMode: Int) {
    POINTS(GL_POINTS),
    LINES(GL_LINES),
    LINE_LOOP(GL_LINE_LOOP),
    LINE_STRIP(GL_LINE_STRIP),
    TRIANGLES(GL_TRIANGLES),
    TRIANGLE_STRIP(GL_TRIANGLE_STRIP),
    TRIANGLE_FAN(GL_TRIANGLE_FAN),
    QUADS(GL_QUADS),
    QUAD_STRIP(GL_QUAD_STRIP),
    POLYGON(GL_POLYGON)
}