import org.junit.runner.RunWith
import org.junit.runners.Suite

class Test {

    @RunWith(Suite::class)
    @Suite.SuiteClasses(
            Test1::class,
            Test2::class,
            Test3::class)
    class UnitTestsSuite


}