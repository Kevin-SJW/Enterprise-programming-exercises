package HighConcurrency;

/**
 * @Classname SynchronizedEvenGenerator
 * @Description TODO
 * @Date 2019/11/28 21:59
 * @Created by 14241
 */
public class
SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield(); // Cause failure faster
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
} ///:~
