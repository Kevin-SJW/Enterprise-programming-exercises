package Container;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2019/10/6 16:40
 * @Created by 14241
 */
public abstract class Test<C> {
    String name;
    public Test(String name) { this.name = name; }
    // Override this method for different tests.
    // Returns actual number of repetitions of test.
    abstract int test(C container, TestParam tp);
} ///:~
