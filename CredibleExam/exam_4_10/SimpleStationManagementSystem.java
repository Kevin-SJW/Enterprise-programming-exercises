package CredibleExam.exam_4_10;

import java.util.LinkedList;
import java.util.List;

/**
 * @Classname SimpleStationManagementSystem
 * @Description TODO
 * @Date 2020/7/27 23:42
 * @Created by Administrator
 */
public class SimpleStationManagementSystem {

    private List<List<Integer>> pointStack;

    public SimpleStationManagementSystem() {
        pointStack = new LinkedList<>();
    }

    public void push(int x, int y) {
        pointStack.add(new LinkedList() {
            {
                add(x);
                add(y);
            }
        });
    }

    public int pop() {
        if (pointStack.size() == 0) {
            return -1;
        }
        pointStack.remove(0);
        return 0;
    }

    public int get() {
        if (pointStack.size() <= 1) {
            return -1;
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int up = Integer.MIN_VALUE;
        int down = Integer.MAX_VALUE;
        for (List<Integer> list : pointStack) {
            if (list.get(0) < left) {
                left = list.get(0);
            }
            if (list.get(0) > right) {
                right = list.get(0);
            }
            if (list.get(1) > up) {
                up = list.get(1);
            }
            if (list.get(1) < down) {
                down = list.get(1);
            }
        }
        if (up == down || left == right) {
            return -1;
        } else {
            return (up - down) * (right - left);
        }

    }
}

//class PointRectangle {
//    int x;
//    int y;
//
//    public PointRectangle(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
