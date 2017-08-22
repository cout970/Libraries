package api

import com.cout970.vector.extensions.quatOf
import com.cout970.vector.extensions.times
import org.joml.Quaterniond
import org.junit.Test

/**
 * Created by cout970 on 2017/07/14.
 */
class FunctionTests {

    @Test
    fun `Test Quaternion Multiplication`(){
        val a = quatOf(0.1, 0.2, 0.3, 0.4)
        val b = quatOf(0.5, 0.6, 0.7, 0.8)

        val c = a * b

        val expected = Quaterniond(0.1, 0.2, 0.3, 0.4).mul(Quaterniond(0.5, 0.6, 0.7, 0.8)).toIQuat()
        assertEquals(expected, c)
    }
}