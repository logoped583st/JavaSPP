import com.test.Sum
import org.junit.Assert
import org.junit.Test

class Test1 {

    @Test
    fun test() {
        Assert.assertEquals(Sum.accum(1, 1, 1, 1, 1, 1, 1, 1), 8)
        Assert.assertEquals(Sum.accum(0),0)
    }
}