package HighConcurrency.NotifyVsNotifyAll;

import java.util.concurrent.*;

import static Container.Countries.print;


/**
 * @Classname NotifyVsNotifyAll
 * @Description TODO
 * @Date 2019/11/27 17:45
 * @Created by 14241
 */
class Daemon implements Runnable {
    private Thread[] t = new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            print("DaemonSpawn " + i + " started, ");
        }
        for (int i = 0; i < t.length; i++) {
            print("t[" + i + "].isDaemon() = " +
                    t[i].isDaemon() + ", ");
        }
        while (true) {
            Thread.yield();
        }
    }
}

class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}

