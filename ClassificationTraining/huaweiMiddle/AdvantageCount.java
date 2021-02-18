package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname AdvantageCount
 * @Description TODO
 * @Date 2021/1/10 10:59
 * @Created by Administrator
 * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
 * <p>
 * 返回 A 的任意排列，使其相对于 B 的优势最大化。
 * 示例 1：
 * <p>
 * 先排序，通过比较大小，确定需要替换的B数组索引的值，最后返回B 。
 */
public class AdvantageCount {
    public static void main(String[] args) {
        int[] A = {2, 7, 11, 15}, B = {1, 10, 4, 11};
        Arrays.stream(advantageCount(A, B)).forEach(t -> System.out.print(t + " "));
    }

    public static int[] advantageCount(int[] A, int[] B) {
        if (A == null || B == null) {
            return A;
        }
        int n = B.length;
        Arrays.sort(A);
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            //存下标
            pair[i] = new int[]{B[i], i};
        }
        Arrays.sort(pair, Comparator.comparingInt(o -> o[0]));

        int[] res = new int[n];
        //r最大值，l标明最小值；
        for (int i = 0, r = n - 1, l = 0; i < n; i++) {
            //要放到原数组对应的位置上
            if (A[i] <= pair[l][0]) {
                res[pair[r--][1]] = A[i];
            }
            //要放到原数组对应的位置上
            else {
                res[pair[l++][1]] = A[i];
            }
        }
        return res;

    }
}
