package MultiThread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Classname CreateThreadDemo5
 * @Description 定时器timer
 * @Date 2019/4/21 20:54
 * @Created by 14241
 */
public class CreateThreadDemo5 {

    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时器线程执行了..."+scheduledExecutionTime());
            }
        },0,1000);   //延迟0，周期1s

    }
}
