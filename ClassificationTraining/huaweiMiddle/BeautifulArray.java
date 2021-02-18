package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname BeautifulArray
 * @Description TODO
 * @Date 2020/10/2 15:09
 * @Created by Administrator
 * 对于某些固定的 N，如果数组 A 是整数 1, 2, ..., N 组成的排列，使得：
 * <p>
 * 对于每个 i < j，都不存在 k 满足 i < k < j 使得 A[k] * 2 = A[i] + A[j]。
 * <p>
 * 那么数组 A 是漂亮数组。
 * <p>
 * 给定 N，返回任意漂亮数组 A（保证存在一个）。
 */
public class BeautifulArray {

    private static Map<Integer, int[]> memo;

    public static void main(String[] args) {
        int n = 4;
        Arrays.stream(beautifulArray(n)).forEach(t -> System.out.print(t + " "));
    }

    public static int[] beautifulArray(int N) {
        memo = new HashMap<>();
        return f(N);
    }

    public static int[] f(int N) {
        if (memo.containsKey(N)) {
            return memo.get(N);
        }
        int[] ans = new int[N];
        if (N == 1) {
            ans[0] = 1;
        } else {
            int t = 0;

            for (int x : f((N + 1) / 2)) {
                ans[t++] = 2 * x - 1;
            }

            for (int x : f(N / 2)) {
                ans[t++] = 2 * x;
            }

            memo.put(N, ans);
        }
        return ans;
    }
}
