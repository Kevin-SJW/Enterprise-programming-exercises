package MultiThread;

/**
 * @Classname Example
 * @Description TODO
 * @Date 2019/9/22 16:16
 * @Created by 14241
 */
public class Example {


    public static void main(String[] args) {

        Counter counter = new Counter();

        Thread threadA = new CounterThread(counter);

        Thread threadB = new CounterThread(counter);


        threadA.start();
        try {
            threadA.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadB.start();

    }

}
