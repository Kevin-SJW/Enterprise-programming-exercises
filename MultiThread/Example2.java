package MultiThread;

/**
 * @Classname Example2
 * @Description TODO
 * @Date 2019/9/22 16:21
 * @Created by 14241
 */
public class Example2 {


    public static void main(String[] args) {

        Counter counterA = new Counter();

        Counter counterB = new Counter();

        Thread threadA = new CounterThread(counterA);

        Thread threadB = new CounterThread(counterB);


        threadA.start();

        threadB.start();

    }

}
