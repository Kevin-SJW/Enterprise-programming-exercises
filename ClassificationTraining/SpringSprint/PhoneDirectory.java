package ClassificationTraining.SpringSprint;

import java.util.Arrays;

/**
 * 设计一个电话目录管理系统，让它支持以下功能：
 * <p>
 * get: 分配给用户一个未被使用的电话号码，获取失败请返回 -1
 * check: 检查指定的电话号码是否被使用
 * release: 释放掉一个电话号码，使其能够重新被分配
 */
public class PhoneDirectory {
    private boolean[] phone;
    private int size;

    public PhoneDirectory(int maxNumbers) {
        this.size = maxNumbers;
        phone = new boolean[maxNumbers];
        Arrays.fill(phone, true); // true 表示可以使用
    }

    /**
     * 分配给用户一个未被使用的电话号码，获取失败请返回 -1.
     */
    public int get() {
        for (int i = 0; i < size; i++) {
            if (phone[i]) {
                phone[i] = false;
                return i;
            }
        }
        return -1;
    }

    /**
     * 检查指定的电话号码是否被使用.
     */
    public boolean check(int number) {
        return phone[number];
    }

    /**
     * 释放掉一个电话号码，使其能够重新被分配.
     */
    public void release(int number) {
        phone[number] = true;
    }



    public static void main(String[] args) {
        // 初始化电话目录，包括 3 个电话号码：0，1 和 2。
        PhoneDirectory directory = new PhoneDirectory(3);
        // 可以返回任意未分配的号码，这里我们假设它返回 0。
        System.out.println(directory.get());
        // 假设，函数返回 1。
        System.out.println(directory.get());
        // 号码 2 未分配，所以返回为 true。
        System.out.println(directory.check(2));
        // 返回 2，分配后，只剩一个号码未被分配。
        System.out.println(directory.get());
        ;
        // 此时，号码 2 已经被分配，所以返回 false。
        System.out.println(directory.check(2));
        // 释放号码 2，将该号码变回未分配状态。
        directory.release(2);
        // 号码 2 现在是未分配状态，所以返回 true。
        System.out.println(directory.check(2));
    }
}
