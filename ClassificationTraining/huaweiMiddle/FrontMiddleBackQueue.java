package ClassificationTraining.huaweiMiddle;


import java.util.ArrayList;
import java.util.List;

/**
 * @Classname FrontMiddleBackQueue
 * @Description TODO
 * @Date 2020/12/5 10:35
 * @Created by Administrator
 * 请你设计一个队列，支持在前，中，后三个位置的 push 和 pop 操作。
 * <p>
 * 请你完成 FrontMiddleBack 类：
 * <p>
 * FrontMiddleBack() 初始化队列。
 * void pushFront(int val) 将 val 添加到队列的 最前面 。
 * void pushMiddle(int val) 将 val 添加到队列的 正中间 。
 * void pushBack(int val) 将 val 添加到队里的 最后面 。
 * int popFront() 将 最前面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * int popMiddle() 将 正中间 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * int popBack() 将 最后面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * 请注意当有 两个 中间位置的时候，选择靠前面的位置进行操作。比方说：
 * <p>
 * 将 6 添加到 [1, 2, 3, 4, 5] 的中间位置，结果数组为 [1, 2, 6, 3, 4, 5] 。
 * 从 [1, 2, 3, 4, 5, 6] 的中间位置弹出元素，返回 3 ，数组变为 [1, 2, 4, 5, 6] 。
 */
public class FrontMiddleBackQueue {
    List<Integer> list;

    public FrontMiddleBackQueue() {
        list = new ArrayList<>();
    }

    public void pushFront(int val) {
        if (list.size() == 0) {
            list.add(val);
        } else {
            list.add(0, val);
        }
    }

    public void pushMiddle(int val) {
        if (list.size() == 0) {
            list.add(val);
        } else {
            int mid = list.size() / 2;
            list.add(mid, val);
        }
    }

    public void pushBack(int val) {
        if (list.size() == 0) {
            list.add(val);
        } else {
            list.add(val);
        }
    }

    public int popFront() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.remove(0);
    }

    public int popMiddle() {
        if (list.size() == 0) {
            return -1;
        }
        int mid = list.size() / 2;
        // 若长度为偶数
        if (list.size() % 2 == 0) {
            return list.remove(mid - 1);
        }
        return list.remove(mid);


    }

    public int popBack() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.remove(list.size() - 1);
    }
}
