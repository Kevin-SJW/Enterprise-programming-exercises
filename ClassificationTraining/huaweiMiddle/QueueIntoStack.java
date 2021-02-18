package ClassificationTraining.huaweiMiddle;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname QueueIntoStack
 * @Description TODO
 * @Date 2020/8/14 0:08
 * @Created by Administrator
 */
public class QueueIntoStack {
    Queue<Integer> queue;

    public void QueueIntoStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
        return queue.poll();
    }

    public int top() {
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
        int res = queue.poll();
        queue.add(res);
        return res;
    }

    public boolean empty() {
        return queue.peek() == null;
    }


}
