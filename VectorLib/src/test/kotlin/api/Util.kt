package api

import com.cout970.vector.api.IQuaternion
import com.cout970.vector.api.IVector2
import com.cout970.vector.api.IVector3
import com.cout970.vector.api.IVector4
import com.cout970.vector.extensions.quatOf
import org.joml.Quaterniond
import org.junit.Assert

/**
 * Created by cout970 on 2017/07/14.
 */

val EPSILON = 1E-7

fun assertQuatEquals(a: IQuaternion, b: IQuaternion) {
    try {
        Assert.assertEquals(a.xd, b.xd, EPSILON)
        Assert.assertEquals(a.yd, b.yd, EPSILON)
        Assert.assertEquals(a.zd, b.zd, EPSILON)
        Assert.assertEquals(a.wd, b.wd, EPSILON)
    } catch (e: AssertionError) {
        Assert.fail("Quaternions are not the same: expected: $a, actual: $b")
    }
}


fun assertVecEquals(a: IVector2, b: IVector2) {
    try {
        Assert.assertEquals(a.xd, b.xd, EPSILON)
        Assert.assertEquals(a.yd, b.yd, EPSILON)
    } catch (e: AssertionError) {
        Assert.fail("IVector2 are not the same: expected: $a, actual: $b")
    }
}

fun assertVecEquals(a: IVector3, b: IVector3) {
    try {
        Assert.assertEquals(a.xd, b.xd, EPSILON)
        Assert.assertEquals(a.yd, b.yd, EPSILON)
        Assert.assertEquals(a.zd, b.zd, EPSILON)
    } catch (e: AssertionError) {
        Assert.fail("IVector2 are not the same: expected: $a, actual: $b")
    }
}

fun assertVecEquals(a: IVector4, b: IVector4) {
    try {
        Assert.assertEquals(a.xd, b.xd, EPSILON)
        Assert.assertEquals(a.yd, b.yd, EPSILON)
        Assert.assertEquals(a.zd, b.zd, EPSILON)
        Assert.assertEquals(a.wd, b.wd, EPSILON)
    } catch (e: AssertionError) {
        Assert.fail("IVector2 are not the same: expected: $a, actual: $b")
    }
}

fun Quaterniond.toIQuat() = quatOf(x, y, z, w)