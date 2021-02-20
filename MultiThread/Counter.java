package MultiThread;

/**
 * @Classname Counter
 * @Description TODO
 * @Date 2019/9/22 16:14
 * @Created by 14241
 */
public class Counter{

    long count = 0;

    public synchronized void add(long value){

        this.count += value;

    }

}
