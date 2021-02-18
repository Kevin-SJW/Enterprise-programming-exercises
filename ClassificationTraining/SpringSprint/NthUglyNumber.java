package ClassificationTraining.SpringSprint;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @Classname NthUglyNumber
 * @Description TODO
 * @Date 2021/2/9 23:05
 * @Created by Administrator
 * 编写一个程序，找出第 n 个丑数,丑数就是质因数只包含 2, 3, 5 的正整数。
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 */
public class NthUglyNumber {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumber(n));

    }

    public static int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        //这里使用long，因为一个int*2或者3,5之后可能超出int
        SortedSet<Long> sortedSet = new TreeSet<>();
        sortedSet.add((long) 1);
        long res;

        for (int i = 0; i < n - 1; i++) {
            res = sortedSet.first();
            sortedSet.add(res * 2);
            sortedSet.add(res * 3);
            sortedSet.add(res * 5);
            sortedSet.remove(res);
        }
        return (int) ((long) sortedSet.first());

    }


}
