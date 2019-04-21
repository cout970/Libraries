package api

import com.cout970.vector.extensions.*
import org.junit.Assert
import org.junit.Test

class UtilitiesTests {

    @Test
    fun `Test dot product`() {

        Assert.assertEquals(0.0, vec2Of(0, 0).dot(vec2Of(0, 0)), 0.001)
        Assert.assertEquals(0.0, vec2Of(1, 1).dot(vec2Of(-1, 1)), 0.001)
        Assert.assertEquals(2.0, vec2Of(1, 1).dot(vec2Of(1, 1)), 0.001)
        Assert.assertEquals(9.0, vec2Of(3, 0).dot(vec2Of(3, 0)), 0.001)
        Assert.assertEquals(9.0, vec2Of(0, 3).dot(vec2Of(0, 3)), 0.001)

        Assert.assertEquals(0.0, vec3Of(0, 0, 0).dot(vec3Of(0, 0, 0)), 0.001)
        Assert.assertEquals(0.0, vec3Of(1, 0, 1).dot(vec3Of(-1, 0, 1)), 0.001)
        Assert.assertEquals(2.0, vec3Of(1, 0, 1).dot(vec3Of(1, 0, 1)), 0.001)
        Assert.assertEquals(9.0, vec3Of(3, 0, 0).dot(vec3Of(3, 0, 0)), 0.001)
        Assert.assertEquals(9.0, vec3Of(0, 0, 3).dot(vec3Of(0, 0, 3)), 0.001)

        Assert.assertEquals(0.0, vec4Of(0, 0, 0, 0).dot(vec4Of(0, 0, 0, 0)), 0.001)
        Assert.assertEquals(0.0, vec4Of(1, 0, 0, 1).dot(vec4Of(-1, 0, 0, 1)), 0.001)
        Assert.assertEquals(2.0, vec4Of(1, 0, 0, 1).dot(vec4Of(1, 0, 0, 1)), 0.001)
        Assert.assertEquals(9.0, vec4Of(3, 0, 0, 0).dot(vec4Of(3, 0, 0, 0)), 0.001)
        Assert.assertEquals(9.0, vec4Of(0, 0, 0, 3).dot(vec4Of(0, 0, 0, 3)), 0.001)
    }

    @Test
    fun `Test cross product`() {
        Assert.assertEquals(vec3Of(0, 0, 1), vec3Of(1, 0, 0).cross(vec3Of(0, 1, 0)))
        Assert.assertEquals(vec3Of(1, -1, 1), vec3Of(1, 1, 0).cross(vec3Of(0, 1, 1)))
        Assert.assertEquals(vec3Of(0, 0, 0), vec3Of(1, 1, 1).cross(vec3Of(1, 1, 1)))
        Assert.assertEquals(vec3Of(2, 0, -2), vec3Of(1, 1, 1).cross(vec3Of(1, -1, 1)))
        Assert.assertEquals(vec3Of(0, 0, 0), vec3Of(1, 0, 0).cross(vec3Of(1, 0, 0)))
    }

    @Test
    fun `Test reflect vec2`() {
        Assert.assertEquals(vec2Of(1, 0), vec2Of(1, 0).reflect(vec2Of(0, 1)))
        Assert.assertEquals(vec2Of(0, 1), vec2Of(0, 1).reflect(vec2Of(1, 0)))

        Assert.assertEquals(vec2Of(-1, 1), vec2Of(1, 1).reflect(vec2Of(1, 0)))
        Assert.assertEquals(vec2Of(-1, 1), vec2Of(1, 1).reflect(vec2Of(-1, 0)))

        Assert.assertEquals(vec2Of(-1, -2), vec2Of(1, 0).reflect(vec2Of(1, 1)))
        Assert.assertEquals(vec2Of(-2, -1), vec2Of(0, 1).reflect(vec2Of(1, 1)))

        Assert.assertEquals(vec2Of(1, -1), vec2Of(1, 1).reflect(vec2Of(0, 1)))
        Assert.assertEquals(vec2Of(0, 0), vec2Of(0, 0).reflect(vec2Of(0, 0)))
    }

    @Test
    fun `Test reflect vec3`() {
        Assert.assertEquals(vec3Of(1, 0, 0), vec3Of(1, 0, 0).reflect(vec3Of(0, 1, 0)))
        Assert.assertEquals(vec3Of(0, 1, 0), vec3Of(0, 1, 0).reflect(vec3Of(1, 0, 0)))

        Assert.assertEquals(vec3Of(-1, 1, 0), vec3Of(1, 1, 0).reflect(vec3Of(1, 0, 0)))
        Assert.assertEquals(vec3Of(-1, 1, 0), vec3Of(1, 1, 0).reflect(vec3Of(-1, 0, 0)))

        Assert.assertEquals(vec3Of(-1, -2, 0), vec3Of(1, 0, 0).reflect(vec3Of(1, 1, 0)))
        Assert.assertEquals(vec3Of(-2, -1, 0), vec3Of(0, 1, 0).reflect(vec3Of(1, 1, 0)))

        Assert.assertEquals(vec3Of(1, -1, 0), vec3Of(1, 1, 0).reflect(vec3Of(0, 1, 0)))
        Assert.assertEquals(vec3Of(0, 0, 0), vec3Of(0, 0, 0).reflect(vec3Of(0, 0, 0)))
    }

    @Test
    fun `Test angle`() {
        Assert.assertEquals(Math.toRadians(90.0), vec2Of(1, 0).angle(vec2Of(0, 1)), 0.001)
        Assert.assertEquals(Math.toRadians(45.0), vec2Of(1, 1).angle(vec2Of(0, 1)), 0.001)
        Assert.assertEquals(Math.toRadians(45.0), vec2Of(1, 0).angle(vec2Of(1, 1)), 0.001)
        Assert.assertEquals(Math.toRadians(0.0), vec2Of(1, 0).angle(vec2Of(1, 0)), 0.001)

        Assert.assertEquals(Math.toRadians(90.0), vec3Of(1, 0, 0).angle(vec3Of(0, 1, 0)), 0.001)
        Assert.assertEquals(Math.toRadians(45.0), vec3Of(1, 1, 0).angle(vec3Of(0, 1, 0)), 0.001)
        Assert.assertEquals(Math.toRadians(45.0), vec3Of(1, 0, 0).angle(vec3Of(1, 1, 0)), 0.001)
        Assert.assertEquals(Math.toRadians(0.0), vec3Of(1, 0, 0).angle(vec3Of(1, 0, 0)), 0.001)
    }

    @Test
    fun `Test interpolate`() {
        Assert.assertEquals(vec2Of(1, 0), vec2Of(1, 0).interpolate(vec2Of(0, 1), 0.0))
        Assert.assertEquals(vec2Of(0.5, 0.5), vec2Of(1, 0).interpolate(vec2Of(0, 1), 0.5))
        Assert.assertEquals(vec2Of(0, 1), vec2Of(1, 0).interpolate(vec2Of(0, 1), 1.0))

        Assert.assertEquals(vec2Of(1, 1), vec2Of(1, 1).interpolate(vec2Of(0, 0), 0.0))
        Assert.assertEquals(vec2Of(0.5, 0.5), vec2Of(1, 1).interpolate(vec2Of(0, 0), 0.5))
        Assert.assertEquals(vec2Of(0, 0), vec2Of(1, 1).interpolate(vec2Of(0, 0), 1.0))


        Assert.assertEquals(vec3Of(1, 0, 0), vec3Of(1, 0, 0).interpolate(vec3Of(0, 1, 0), 0.0))
        Assert.assertEquals(vec3Of(0.5, 0.5, 0), vec3Of(1, 0, 0).interpolate(vec3Of(0, 1, 0), 0.5))
        Assert.assertEquals(vec3Of(0, 1, 0), vec3Of(1, 0, 0).interpolate(vec3Of(0, 1, 0), 1.0))

        Assert.assertEquals(vec3Of(1, 1, 0), vec3Of(1, 1, 0).interpolate(vec3Of(0, 0, 0), 0.0))
        Assert.assertEquals(vec3Of(0.5, 0.5, 0), vec3Of(1, 1, 0).interpolate(vec3Of(0, 0, 0), 0.5))
        Assert.assertEquals(vec3Of(0, 0, 0), vec3Of(1, 1, 0).interpolate(vec3Of(0, 0, 0), 1.0))


        Assert.assertEquals(vec4Of(1, 0, 0, 0), vec4Of(1, 0, 0, 0).interpolate(vec4Of(0, 1, 0, 0), 0.0))
        Assert.assertEquals(vec4Of(0.5, 0.5, 0, 0), vec4Of(1, 0, 0, 0).interpolate(vec4Of(0, 1, 0, 0), 0.5))
        Assert.assertEquals(vec4Of(0, 1, 0, 0), vec4Of(1, 0, 0, 0).interpolate(vec4Of(0, 1, 0, 0), 1.0))

        Assert.assertEquals(vec4Of(1, 1, 0, 0), vec4Of(1, 1, 0, 0).interpolate(vec4Of(0, 0, 0, 0), 0.0))
        Assert.assertEquals(vec4Of(0.5, 0.5, 0, 0), vec4Of(1, 1, 0, 0).interpolate(vec4Of(0, 0, 0, 0), 0.5))
        Assert.assertEquals(vec4Of(0, 0, 0, 0), vec4Of(1, 1, 0, 0).interpolate(vec4Of(0, 0, 0, 0), 1.0))
    }

    @Test
    fun `Test rotate CW and CCW`(){
        assertVecEquals(vec2Of(0,0), vec2Of(0,0).rotateCCW(Math.toRadians(90.0)))
        assertVecEquals(vec2Of(0,1), vec2Of(1,0).rotateCCW(Math.toRadians(90.0)))
        assertVecEquals(vec2Of(-1,0), vec2Of(0,1).rotateCCW(Math.toRadians(90.0)))
        assertVecEquals(vec2Of(-1,1), vec2Of(1,1).rotateCCW(Math.toRadians(90.0)))

        assertVecEquals(vec2Of(0,0), vec2Of(0,0).rotateCW(Math.toRadians(90.0)))
        assertVecEquals(vec2Of(0,-1), vec2Of(1,0).rotateCW(Math.toRadians(90.0)))
        assertVecEquals(vec2Of(1,0), vec2Of(0,1).rotateCW(Math.toRadians(90.0)))
        assertVecEquals(vec2Of(1,-1), vec2Of(1,1).rotateCW(Math.toRadians(90.0)))
    }


}