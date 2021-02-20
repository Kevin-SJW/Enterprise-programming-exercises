package HighConcurrency;

/**
 * @Classname AtomicEvenGenerator
 * @Description TODO
 * @Date 2019/11/27 15:54
 * @Created by 14241
 */

import java.util.concurrent.atomic.*;

public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger currentEvenValue =
            new AtomicInteger(0);

    @Override
    public int next() {
        return currentEvenValue.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
} ///:~
