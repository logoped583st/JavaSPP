import com.test.Stack
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class Test3 {

    lateinit var stack: Stack<String>


    @Before
    @Test
    fun testConstructor() {
        stack = Stack()
        Assert.assertNotEquals(stack, null)
        Assert.assertEquals(stack.size(), 0)
    }

    @Test
    fun testIsEmpty() {
        Assert.assertEquals(stack.isEmpty, true)
    }

    @Test(expected = NoSuchElementException::class)
    fun testPushAndPop() {
        Assert.assertNotNull(stack.push("Test"))
        Assert.assertEquals(stack.peek(), "Test")
        Assert.assertEquals(stack.toString(),"Test ")
        Assert.assertEquals(stack.pop(), "Test")
        Assert.assertEquals(stack.pop(),NoSuchElementException())
        Assert.assertEquals(stack.peek(),NoSuchElementException())

    }

}