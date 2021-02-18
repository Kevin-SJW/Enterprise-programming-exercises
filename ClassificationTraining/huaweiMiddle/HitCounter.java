package ClassificationTraining.huaweiMiddle;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname HitCounter
 * @Description TODO
 * @Date 2020/10/3 18:24
 * @Created by Administrator
 * 设计一个敲击计数器，使它可以统计在过去5分钟内被敲击次数。
 * 每个函数会接收一个时间戳参数（以秒为单位），你可以假设最早的时间戳从1开始，
 * 且都是按照时间顺序对系统进行调用（即时间戳是单调递增）。
 * 在同一时刻有可能会有多次敲击。
 */
public class HitCounter {
    Queue<Integer> queue;
    int startIndex = -1;    // 五分钟内的第一次敲击的时间戳，-1 表示没有元素

    /**
     * Initialize your data structure here.
     */
    public HitCounter() {
        queue = new LinkedList<>();

    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        if (startIndex == -1) {
            startIndex = timestamp;
        }
        queue.offer(timestamp);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        while (timestamp - startIndex >= 300 && !queue.isEmpty()) {
            queue.poll();
            if (!queue.isEmpty()) {
                startIndex = queue.peek();
            } else {
                startIndex = -1;
            }
        }

        return queue.size();

    }

    public int getHits2(int timeStamp) {
        while (timeStamp - startIndex >= 300 & !queue.isEmpty()) {
            queue.poll();
            if (!queue.isEmpty()) {
                startIndex = queue.peek();
            } else {
                startIndex = -1;
            }
        }
        return queue.size();

    }


}
