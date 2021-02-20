package HighConcurrency;

import java.util.concurrent.ThreadFactory;

/**
 * @Classname DaemonThreadFactory
 * @Description TODO
 * @Date 2019/11/27 16:18
 * @Created by 14241
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
} ///:~

