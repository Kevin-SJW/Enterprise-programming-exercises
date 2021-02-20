package HighConcurrency.ConcurrencyDemo;

/**
 * @Classname SerialNumberGenerator
 * @Description TODO
 * @Date 2019/11/28 21:46
 * @Created by 14241
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static int nextSerialNumber() {
        return serialNumber++; // Not thread-safe
    }
} ///:~
