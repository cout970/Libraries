
import com.cout970.matrix.extensions.Matrix4
import com.cout970.matrix.extensions.mat4Of
import com.cout970.matrix.extensions.times
import com.cout970.vector.extensions.quatOfAxisAngledDeg
import com.cout970.vector.extensions.vec3Of
import com.cout970.vector.extensions.vec4Of
import org.joml.Matrix4d
import org.joml.Quaterniond
import org.joml.Vector3d
import org.joml.Vector4d
import org.junit.Assert
import org.junit.Test

/**
 * Created by cout970 on 2017/08/21.
 */


class TestProjection {

    @Test
    fun `Check otho projection matrix generation`() {
        val matrix = Matrix4.ortho(-1.0, 1.0, -2.0, 2.0, 0.1, 100.0)
        val correct = Matrix4d().setOrtho(-1.0, 1.0, -2.0, 2.0, 0.1, 100.0).toIMatrix()

        Assert.assertEquals(matrix, correct)
    }

    @Test
    fun `Check perspective projection matrix generation`() {
        val matrix = Matrix4.perspective(60.0, 1.0, 0.1, 100.0)
        val correct = Matrix4d().setPerspective(60.0, 1.0, 0.1, 100.0).toIMatrix()

        Assert.assertEquals(matrix, correct)
    }

    @Test
    fun `Check lookAt`() {
        val matrix = Matrix4.lookAt(vec3Of(1, 2, 3), vec3Of(4, 5, 6), vec3Of(0, 1, 0))
        val correct = Matrix4d().setLookAt(
            Vector3d(1.0, 2.0, 3.0), Vector3d(4.0, 5.0, 6.0), Vector3d(0.0, 1.0, 0.0)
        ).toIMatrix()

        Assert.assertEquals(matrix, correct)
    }

    @Test
    fun `Check otho projection matrix use`() {
        val matrix = Matrix4.ortho(-1.0, 1.0, -2.0, 2.0, 0.1, 100.0)
        val correct = Matrix4d().setOrtho(-1.0, 1.0, -2.0, 2.0, 0.1, 100.0)

        val pointA = vec4Of(1, 2, 3, 1)
        val pointB = Vector4d(1.0, 2.0, 3.0, 1.0)

        val ret1 = pointA * matrix
        val ret2 = correct.transform(pointB).toIVector()

        Assert.assertEquals(ret1, ret2)
    }

    @Test
    fun `Multiply two matrix`() {

        val matrix1 = mat4Of(
            1, 2, 3, 4,
            1, 2, 3, 4,
            1, 2, 3, 4,
            1, 2, 3, 4
        )

        val matrix2 = Matrix4d(
            1.0, 2.0, 3.0, 4.0,
            1.0, 2.0, 3.0, 4.0,
            1.0, 2.0, 3.0, 4.0,
            1.0, 2.0, 3.0, 4.0
        )

        val res1 = matrix1 * matrix1
        val res2 = matrix2.mul(matrix2, Matrix4d()).toIMatrix()

        Assert.assertEquals(res1, res2)
    }

    @Test
    fun `Create TRS matrix`() {

        val matrix1 = Matrix4.trs(
            vec3Of(1.0, 2.0, 3.0),
            quatOfAxisAngledDeg(40.0, 1.0, 1.0, 1.0),
            vec3Of(0.1, 0.2, 0.3)
        )

        val matrix2 = Matrix4d().apply {
            translate(1.0, 2.0, 3.0)
            rotate(Quaterniond().fromAxisAngleDeg(1.0, 1.0, 1.0, 40.0))
            scale(0.1, 0.2, 0.3)
        }.toIMatrix()

        Assert.assertEquals(matrix1, matrix2)
    }
}