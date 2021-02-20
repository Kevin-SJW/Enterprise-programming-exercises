package HighConcurrency;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019/11/27 17:34
 * @Created by 14241
 */
public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
} /* Output:
#0(9), #0(8), #0(7), #0(6), #0(5), #0(4), #0(3), #0(2), #0(1), #0(Liftoff!),
*///:~
