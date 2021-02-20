package CredibleExam.exam_3_27;

import java.util.LinkedList;

/**
 * @Classname AvgLoadWindow
 * @Description TODO
 * @Date 2020/7/24 0:18
 * @Created by Administrator
 */
public class AvgLoadWindow {

    public static void main(String[] args) {
        AvgLoadWindow window = new AvgLoadWindow(3);
        System.out.println(window.next(1));
        System.out.println(window.next(2));
        System.out.println(window.next(3));
        System.out.println(window.next(4));
        System.out.println(window.next(5));
    }

    /**
     * Initialize your data structure here.
     */
    private double sum;
    private int size;
    private LinkedList<Integer> list;

    /**
     * Initialize your data structure here.
     */
    public AvgLoadWindow(int size) {
        this.list = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        sum += val;
        list.offer(val);

        if (list.size() <= size) {
            return sum / list.size();
        }

        sum -= list.poll();

        return sum / size;
    }
}
