package HighConcurrency;

import java.util.concurrent.*;


/**
 * @Classname NaiveExceptionHandling
 * @Description TODO
 * @Date 2019/11/27 17:42
 * @Created by 14241
 */
public class NaiveExceptionHandling {
    public static void main(String[] args) {
        try {
            ExecutorService exec =
                    Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        } catch(RuntimeException ue) {
            // This statement will NOT execute!
            System.out.println("Exception has been handled!");
        }
    }
} ///:~
