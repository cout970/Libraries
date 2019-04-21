package api

import com.cout970.vector.extensions.*
import com.cout970.vector.impl.*
import org.junit.Assert
import org.junit.Test

class ConstructorTests {

    @Test
    fun `Tests basic constructors`() {
        val a1 = vec2Of(1, 2)
        val a2 = mutableVec2Of(3, 4)
        val a3 = vec3Of(5, 6, 7)
        val a4 = mutableVec3Of(8, 9, 10)
        val a5 = vec4Of(11, 12, 13, 14)
        val a6 = mutableVec4Of(15, 16, 17, 18)
        val a7 = quatOf(19, 20, 21, 22)
        val a8 = mutableQuatOf(23, 24, 25, 26)

        Assert.assertTrue(a1 is Vector2d)
        Assert.assertTrue(a2 is MutableVector2d)
        Assert.assertTrue(a3 is Vector3d)
        Assert.assertTrue(a4 is MutableVector3d)
        Assert.assertTrue(a5 is Vector4d)
        Assert.assertTrue(a6 is MutableVector4d)
        Assert.assertTrue(a7 is Quaterniond)
        Assert.assertTrue(a8 is MutableQuaterniond)

        Assert.assertEquals(1.0, a1.x)
        Assert.assertEquals(2.0, a1.y)
        Assert.assertEquals(3.0, a2.x)
        Assert.assertEquals(4.0, a2.y)
        Assert.assertEquals(5.0, a3.x)
        Assert.assertEquals(6.0, a3.y)
        Assert.assertEquals(7.0, a3.z)
        Assert.assertEquals(8.0, a4.x)
        Assert.assertEquals(9.0, a4.y)
        Assert.assertEquals(10.0, a4.z)
        Assert.assertEquals(11.0, a5.x)
        Assert.assertEquals(12.0, a5.y)
        Assert.assertEquals(13.0, a5.z)
        Assert.assertEquals(14.0, a5.w)
        Assert.assertEquals(15.0, a6.x)
        Assert.assertEquals(16.0, a6.y)
        Assert.assertEquals(17.0, a6.z)
        Assert.assertEquals(18.0, a6.w)
        Assert.assertEquals(19.0, a7.x)
        Assert.assertEquals(20.0, a7.y)
        Assert.assertEquals(21.0, a7.z)
        Assert.assertEquals(22.0, a7.w)
        Assert.assertEquals(23.0, a8.x)
        Assert.assertEquals(24.0, a8.y)
        Assert.assertEquals(25.0, a8.z)
        Assert.assertEquals(26.0, a8.w)
    }

    @Test
    fun `Test quatOfAxisAngled`(){
        val a1 = quatOfAxisAngledDeg(90, 1, 0,0)
        val a2 = quatOfAxisAngledDeg(90, 0, 1,0)
        val a3 = quatOfAxisAngledDeg(90, 0, 0,1)
        val a4 = quatOfAxisAngledDeg(90, 0, 0,0)

        val a5 = quatOfAxisAngledDeg(-90, 1, 0,0)
        val a6 = quatOfAxisAngledDeg(-90, 0, 1,0)
        val a7 = quatOfAxisAngledDeg(-90, 0, 0,1)

        val a8 = quatOfAxisAngledDeg(180, 1, 0,0)
        val a9 = quatOfAxisAngledDeg(-180, 1, 0,0)

        assertQuatEquals(Quaterniond(xd=0.7071067811865475, yd=0.0, zd=0.0, wd=0.7071067811865476), a1)
        assertQuatEquals(Quaterniond(xd=0.0, yd=0.7071067811865475, zd=0.0, wd=0.7071067811865476), a2)
        assertQuatEquals(Quaterniond(xd=0.0, yd=0.0, zd=0.7071067811865475, wd=0.7071067811865476), a3)
        assertQuatEquals(Quaterniond(xd=0.0, yd=0.0, zd=0.0, wd=0.7071067811865476), a4)

        assertQuatEquals(Quaterniond(xd=-0.7071067811865475, yd=-0.0, zd=-0.0, wd=0.7071067811865476), a5)
        assertQuatEquals(Quaterniond(xd=-0.0, yd=-0.7071067811865475, zd=-0.0, wd=0.7071067811865476), a6)
        assertQuatEquals(Quaterniond(xd=-0.0, yd=-0.0, zd=-0.7071067811865475, wd=0.7071067811865476), a7)

        assertQuatEquals(Quaterniond(xd=1.0, yd=0.0, zd=0.0, wd=-0.0), a8)
        assertQuatEquals(Quaterniond(xd=-1.0, yd=-0.0, zd=-0.0, wd=0.0), a9)
    }

    @Test
    fun `Test mutableQuatOfAxisAngled`(){
        val a1 = mutableQuatOfAxisAngled(90, 1, 0,0)
        val a2 = mutableQuatOfAxisAngled(90, 0, 1,0)
        val a3 = mutableQuatOfAxisAngled(90, 0, 0,1)
        val a4 = mutableQuatOfAxisAngled(90, 0, 0,0)

        val a5 = mutableQuatOfAxisAngled(-90, 1, 0,0)
        val a6 = mutableQuatOfAxisAngled(-90, 0, 1,0)
        val a7 = mutableQuatOfAxisAngled(-90, 0, 0,1)

        val a8 = mutableQuatOfAxisAngled(180, 1, 0,0)
        val a9 = mutableQuatOfAxisAngled(-180, 1, 0,0)

        assertQuatEquals(MutableQuaterniond(xd=0.7071067811865475, yd=0.0, zd=0.0, wd=0.7071067811865476), a1)
        assertQuatEquals(MutableQuaterniond(xd=0.0, yd=0.7071067811865475, zd=0.0, wd=0.7071067811865476), a2)
        assertQuatEquals(MutableQuaterniond(xd=0.0, yd=0.0, zd=0.7071067811865475, wd=0.7071067811865476), a3)
        assertQuatEquals(MutableQuaterniond(xd=0.0, yd=0.0, zd=0.0, wd=0.7071067811865476), a4)

        assertQuatEquals(MutableQuaterniond(xd=-0.7071067811865475, yd=-0.0, zd=-0.0, wd=0.7071067811865476), a5)
        assertQuatEquals(MutableQuaterniond(xd=-0.0, yd=-0.7071067811865475, zd=-0.0, wd=0.7071067811865476), a6)
        assertQuatEquals(MutableQuaterniond(xd=-0.0, yd=-0.0, zd=-0.7071067811865475, wd=0.7071067811865476), a7)

        assertQuatEquals(MutableQuaterniond(xd=1.0, yd=0.0, zd=0.0, wd=-0.0), a8)
        assertQuatEquals(MutableQuaterniond(xd=-1.0, yd=-0.0, zd=-0.0, wd=0.0), a9)
    }
}