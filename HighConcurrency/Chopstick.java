package HighConcurrency;

/**
 * @Classname ChopStick
 * @Description TODO
 * @Date 2019/11/27 16:11
 * @Created by 14241
 */
public class Chopstick {
    private boolean taken = false;

    public synchronized void take() throws InterruptedException {
        while (taken) {
            wait();
        }
        taken = true;
    }

    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
} ///:~

