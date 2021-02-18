package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname FindLeastNumOfUniqueInts
 * @Description TODO
 * @Date 2020/10/2 17:32
 * @Created by Administrator
 * 给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，
 * 请找出移除后数组中不同整数的最少数目。
 * <p>
 * 输入：arr = [5,5,4], k = 1
 * 输出：1
 * 解释：移除 1 个 4 ，数组中只剩下 5 一种整数。
 */
public class FindLeastNumOfUniqueInts {
    public static void main(String[] args) {
        int[] arr = {5, 5, 4};
        int k = 1;
        System.out.println(findLeastNumOfUniqueInts(arr, k));

    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int m = 0;

        int size = map.size();
        int[] value = new int[size];
        for (int cnt : map.keySet()) {
            value[m++] = map.get(cnt);
        }
        Arrays.sort(value);
        for (int c : value) {
            if (k >= c) {
                k -= c;
                size--;
            } else {
                break;
            }
        }
        return size;
    }
}
