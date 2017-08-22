package api

import com.cout970.vector.api.IQuaternion
import com.cout970.vector.extensions.quatOf
import org.joml.Quaterniond
import org.junit.Assert

/**
 * Created by cout970 on 2017/07/14.
 */

val EPSILON = 1E-7

fun assertEquals(a: IQuaternion, b: IQuaternion) {
    try {
        Assert.assertEquals(a.xd, b.xd, EPSILON)
        Assert.assertEquals(a.yd, b.yd, EPSILON)
        Assert.assertEquals(a.zd, b.zd, EPSILON)
        Assert.assertEquals(a.wd, b.wd, EPSILON)
    } catch (e: AssertionError) {
        Assert.fail("Quaternions are not the same: expected: $a, actual: $b")
    }
}

fun Quaterniond.toIQuat() = quatOf(x, y, z, w)