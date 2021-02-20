package MultiThread;

/**
 * @Classname CounterThread
 * @Description TODO
 * @Date 2019/9/22 16:15
 * @Created by 14241
 */
public class CounterThread extends Thread {


    protected Counter counter = null;


    public CounterThread(Counter counter) {

        this.counter = counter;

    }


    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {

            counter.add(i);
            System.out.println("当前"+Thread.currentThread().getName()+" "+i+" is running!");

        }

    }

}
