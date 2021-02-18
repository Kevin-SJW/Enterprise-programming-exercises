package ClassificationTraining.huaweiMiddle;


import java.util.*;

/**
 * @Classname FindLongestChain
 * @Description TODO
 * @Date 2020/11/29 16:24
 * @Created by Administrator
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * <p>
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。
 * 我们用这种形式来构造一个数对链。
 * <p>
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，
 * 你可以以任何顺序选择其中的一些数对来构造。
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 */
public class FindLongestChain {
    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(findLongestChain(pairs));

    }

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int cur = Integer.MIN_VALUE, ans = 0;
        for (int[] pair : pairs) {
            if (cur < pair[0]) {
                cur = pair[1];
                ans++;
            }
        }
        return ans;
    }

    public static int findLongestChain2(int[][] pairs) {
        Deque<int[]> stack = new LinkedList<>();
        Arrays.sort(pairs, (o1, o2) -> o1[0] - o2[0]);
        for (int[] i : pairs) {
            int[] j = stack.peek();
            if (stack.isEmpty() || i[0] > j[1]) {
                stack.push(i);
            } else {
                j[1] = Math.max(i[1], j[1]);
            }
        }
        int[][] res = new int[stack.size()][2];
        for (int i = stack.size() - 1; i > 0; i--) {
            res[i] = stack.pop();
        }
        return res.length;

    }
}
