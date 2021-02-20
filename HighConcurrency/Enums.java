package HighConcurrency;

import java.util.Random;

/**
 * @Classname Enums
 * @Description TODO
 * @Date 2019/11/27 15:44
 * @Created by 14241
 */
public class Enums {
    private static Random rand = new Random(47);
    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }
    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
} ///
