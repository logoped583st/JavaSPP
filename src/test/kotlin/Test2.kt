import com.test.repeat
import org.junit.Assert
import org.junit.Test

class Test2 {

    @Test(expected = IllegalArgumentException::class)
    fun test() {
        Assert.assertEquals(String.repeat("e", 0), "")
        Assert.assertEquals(String.repeat("ABC", 2), "ABCABC")
        Assert.assertEquals(String.repeat("e", -2), IllegalArgumentException())
    }

    @Test(expected = IllegalArgumentException::class)
    fun test2() {
        Assert.assertEquals(String.repeat("e", " ", 0), "")
        Assert.assertEquals(String.repeat("ABC"," ", 2), "ABC ABC ")
        Assert.assertEquals(String.repeat("e"," ", -2), IllegalArgumentException())
    }
}