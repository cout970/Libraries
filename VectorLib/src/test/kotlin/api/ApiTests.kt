package api

import com.cout970.vector.extensions.*
import org.joml.Quaterniond
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by cout970 on 2017/07/14.
 */

class ApiTests {

    @Test
    fun `Tests getters of Vector2`() {
        val vec2 = vec2Of(1, 2)

        assertEquals(1, vec2.x.toInt())
        assertEquals(2, vec2.y.toInt())

        assertEquals(1, vec2.xi)
        assertEquals(2, vec2.yi)

        assertEquals(1.0f, vec2.xf)
        assertEquals(2.0f, vec2.yf)

        assertEquals(1.0, vec2.xd, EPSILON)
        assertEquals(2.0, vec2.yd, EPSILON)
    }

    @Test
    fun `Tests getters of Vector3`() {
        val vec3 = vec3Of(1, 2, 3)

        assertEquals(1, vec3.x.toInt())
        assertEquals(2, vec3.y.toInt())
        assertEquals(3, vec3.z.toInt())

        assertEquals(1, vec3.xi)
        assertEquals(2, vec3.yi)
        assertEquals(3, vec3.zi)

        assertEquals(1.0f, vec3.xf)
        assertEquals(2.0f, vec3.yf)
        assertEquals(3.0f, vec3.zf)

        assertEquals(1.0, vec3.xd, EPSILON)
        assertEquals(2.0, vec3.yd, EPSILON)
        assertEquals(3.0, vec3.zd, EPSILON)
    }

    @Test
    fun `Tests getters of Vector4`() {
        val vec4 = vec4Of(1, 2, 3, 4)

        assertEquals(1, vec4.x.toInt())
        assertEquals(2, vec4.y.toInt())
        assertEquals(3, vec4.z.toInt())
        assertEquals(4, vec4.w.toInt())

        assertEquals(1, vec4.xi)
        assertEquals(2, vec4.yi)
        assertEquals(3, vec4.zi)
        assertEquals(4, vec4.wi)

        assertEquals(1.0f, vec4.xf)
        assertEquals(2.0f, vec4.yf)
        assertEquals(3.0f, vec4.zf)
        assertEquals(4.0f, vec4.wf)

        assertEquals(1.0, vec4.xd, EPSILON)
        assertEquals(2.0, vec4.yd, EPSILON)
        assertEquals(3.0, vec4.zd, EPSILON)
        assertEquals(4.0, vec4.wd, EPSILON)
    }

    @Test
    fun `Tests getters of Quaternion`() {
        val vec4 = quatOf(1, 2, 3, 4)

        assertEquals(1, vec4.x.toInt())
        assertEquals(2, vec4.y.toInt())
        assertEquals(3, vec4.z.toInt())
        assertEquals(4, vec4.w.toInt())

        assertEquals(1, vec4.xi)
        assertEquals(2, vec4.yi)
        assertEquals(3, vec4.zi)
        assertEquals(4, vec4.wi)

        assertEquals(1.0f, vec4.xf)
        assertEquals(2.0f, vec4.yf)
        assertEquals(3.0f, vec4.zf)
        assertEquals(4.0f, vec4.wf)

        assertEquals(1.0, vec4.xd, EPSILON)
        assertEquals(2.0, vec4.yd, EPSILON)
        assertEquals(3.0, vec4.zd, EPSILON)
        assertEquals(4.0, vec4.wd, EPSILON)
    }

    @Test
    fun `Tests setters of MutableVector2`() {
        val vec2 = mutableVec2Of(1, 2)

        vec2.x = 5
        vec2.y = 6

        assertEquals(5, vec2.x.toInt())
        assertEquals(6, vec2.y.toInt())

        assertEquals(5, vec2.xi)
        assertEquals(6, vec2.yi)

        assertEquals(5.0f, vec2.xf)
        assertEquals(6.0f, vec2.yf)

        assertEquals(5.0, vec2.xd, EPSILON)
        assertEquals(6.0, vec2.yd, EPSILON)
    }

    @Test
    fun `Tests setters of MutableVector3`() {
        val vec3 = mutableVec3Of(1, 2, 3)

        vec3.x = 5
        vec3.y = 6
        vec3.z = 7

        assertEquals(5, vec3.x.toInt())
        assertEquals(6, vec3.y.toInt())
        assertEquals(7, vec3.z.toInt())

        assertEquals(5, vec3.xi)
        assertEquals(6, vec3.yi)
        assertEquals(7, vec3.zi)

        assertEquals(5.0f, vec3.xf)
        assertEquals(6.0f, vec3.yf)
        assertEquals(7.0f, vec3.zf)

        assertEquals(5.0, vec3.xd, EPSILON)
        assertEquals(6.0, vec3.yd, EPSILON)
        assertEquals(7.0, vec3.zd, EPSILON)
    }

    @Test
    fun `Tests setters of MutableVector4`() {
        val vec4 = mutableVec4Of(1, 2, 3, 4)

        vec4.x = 5
        vec4.y = 6
        vec4.z = 7
        vec4.w = 8

        assertEquals(5, vec4.x.toInt())
        assertEquals(6, vec4.y.toInt())
        assertEquals(7, vec4.z.toInt())
        assertEquals(8, vec4.w.toInt())

        assertEquals(5, vec4.xi)
        assertEquals(6, vec4.yi)
        assertEquals(7, vec4.zi)
        assertEquals(8, vec4.wi)

        assertEquals(5.0f, vec4.xf)
        assertEquals(6.0f, vec4.yf)
        assertEquals(7.0f, vec4.zf)
        assertEquals(8.0f, vec4.wf)

        assertEquals(5.0, vec4.xd, EPSILON)
        assertEquals(6.0, vec4.yd, EPSILON)
        assertEquals(7.0, vec4.zd, EPSILON)
        assertEquals(8.0, vec4.wd, EPSILON)
    }

    @Test
    fun `Tests setters of MutableQuaternion`() {
        val vec4 = mutableQuatOf(1, 2, 3, 4)

        vec4.x = 5
        vec4.y = 6
        vec4.z = 7
        vec4.w = 8

        assertEquals(5, vec4.x.toInt())
        assertEquals(6, vec4.y.toInt())
        assertEquals(7, vec4.z.toInt())
        assertEquals(8, vec4.w.toInt())

        assertEquals(5, vec4.xi)
        assertEquals(6, vec4.yi)
        assertEquals(7, vec4.zi)
        assertEquals(8, vec4.wi)

        assertEquals(5.0f, vec4.xf)
        assertEquals(6.0f, vec4.yf)
        assertEquals(7.0f, vec4.zf)
        assertEquals(8.0f, vec4.wf)

        assertEquals(5.0, vec4.xd, EPSILON)
        assertEquals(6.0, vec4.yd, EPSILON)
        assertEquals(7.0, vec4.zd, EPSILON)
        assertEquals(8.0, vec4.wd, EPSILON)
    }

    @Test
    fun `Test Quaternion constructor from AxisAngled`() {
        val identity = quatOfAxisAngled(0, 0, 0, 0)

        //@formatter:off
        val y90  = quatOfAxisAngled( 90, 0, 1, 0)
        val y45  = quatOfAxisAngled( 45, 0, 1, 0)
        val y180 = quatOfAxisAngled(180, 0, 1, 0)
        val y270 = quatOfAxisAngled(270, 0, 1, 0)
        
        val x90  = quatOfAxisAngled( 90, 1, 0, 0)
        val x45  = quatOfAxisAngled( 45, 1, 0, 0)
        val x180 = quatOfAxisAngled(180, 1, 0, 0)
        val x270 = quatOfAxisAngled(270, 1, 0, 0)

        val xy90  = quatOfAxisAngled( 90, 1, 1, 0)
        val xy45  = quatOfAxisAngled( 45, 1, 1, 0)
        val xy180 = quatOfAxisAngled(180, 1, 1, 0)
        val xy270 = quatOfAxisAngled(270, 1, 1, 0)
        
        assertQuatEquals(identity, Quaternion.IDENTITY)

        assertQuatEquals(Quaterniond().fromAxisAngleDeg(0.0, 1.0, 0.0, 90.0 ).toIQuat(), y90)
        assertQuatEquals(Quaterniond().fromAxisAngleDeg(0.0, 1.0, 0.0, 45.0 ).toIQuat(), y45)
        assertQuatEquals(Quaterniond().fromAxisAngleDeg(0.0, 1.0, 0.0, 180.0).toIQuat(), y180)
        assertQuatEquals(Quaterniond().fromAxisAngleDeg(0.0, 1.0, 0.0, 270.0).toIQuat(), y270)

        assertQuatEquals(Quaterniond().fromAxisAngleDeg(1.0, 0.0, 0.0, 90.0 ).toIQuat(), x90)
        assertQuatEquals(Quaterniond().fromAxisAngleDeg(1.0, 0.0, 0.0, 45.0 ).toIQuat(), x45)
        assertQuatEquals(Quaterniond().fromAxisAngleDeg(1.0, 0.0, 0.0, 180.0).toIQuat(), x180)
        assertQuatEquals(Quaterniond().fromAxisAngleDeg(1.0, 0.0, 0.0, 270.0).toIQuat(), x270)

        assertQuatEquals(Quaterniond().fromAxisAngleDeg(1.0, 1.0, 0.0, 90.0 ).toIQuat(), xy90)
        assertQuatEquals(Quaterniond().fromAxisAngleDeg(1.0, 1.0, 0.0, 45.0 ).toIQuat(), xy45)
        assertQuatEquals(Quaterniond().fromAxisAngleDeg(1.0, 1.0, 0.0, 180.0).toIQuat(), xy180)
        assertQuatEquals(Quaterniond().fromAxisAngleDeg(1.0, 1.0, 0.0, 270.0).toIQuat(), xy270)
        //@formatter:on
    }
}