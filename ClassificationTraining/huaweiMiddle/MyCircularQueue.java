package ClassificationTraining.huaweiMiddle;

/**
 * @Classname MyCircularQueue
 * @Description TODO
 * @Date 2020/8/30 11:16
 * @Created by Administrator
 */
public class MyCircularQueue {
    private int[] arr;
    private int head, tail;
    private int size = 0;

    public MyCircularQueue(int k) {
        arr = new int[k];
        tail = -1;
        head = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        size++;
        tail = (tail + 1) % arr.length;
        arr[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        size--;
        head = (head + 1) % arr.length;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return arr[head];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return arr[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }
}
