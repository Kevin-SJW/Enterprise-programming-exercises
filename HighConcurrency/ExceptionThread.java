package HighConcurrency;

/**
 * @Classname ExceptionThread
 * @Description TODO
 * @Date 2019/11/27 16:51
 * @Created by 14241
 */
import java.util.concurrent.*;

public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
} ///:~
