package Container;

import java.util.Random;

/**
 * @Classname Prediction
 * @Description TODO
 * @Date 2019/10/10 19:32
 * @Created by 14241
 */
public class Prediction {
    private static Random rand = new Random(47);
    private boolean shadow = rand.nextDouble() > 0.5;

    @Override
    public String toString() {
        if (shadow) {
            return "Six more weeks of Winter!";
        } else {
            return "Early Spring!";
        }
    }
} ///:~
