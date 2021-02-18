package ClassificationTraining.huaweiSimple;

import java.util.*;

/**
 * 输入：nums = [1,2,3,4]
 * 输出：[2,4,4,4]
 * 解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
 * 第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
 * 最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。
 */
public class DecompressRLEList {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] nums2 = {55, 11, 70, 26, 62, 64};
        int[] nums3 = {39, 86, 8, 96, 5, 25, 64, 10, 39, 15, 69, 40, 92, 22, 64, 31, 98, 4};
        Arrays.stream(decompressRLElist2(nums)).forEach(t -> System.out.print(t + "　"));

    }

    public static int[] decompressRLElist(int[] nums) {
        Map<Integer, Integer> map = new LinkedHashMap<>(100);
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 1; i += 2) {
            map.put(nums[i], nums[i + 1]);
        }
        for (int key : map.keySet()) {
            for (int i = 0; i < key; i++) {
                res.add(map.get(key));
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static int[] decompressRLElist2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            int k = nums[i];
            for (int j = 0; j < k; j++) {
                ans.add(nums[i + 1]);
            }
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
}
