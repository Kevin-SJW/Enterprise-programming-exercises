package ClassificationTraining.huaweiMiddle;

import java.util.*;

/**
 * @Classname MostCompetitive
 * @Description TODO
 * @Date 2020/12/3 0:22
 * @Created by Administrator
 * 给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列
 * 数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。
 * 在子序列 a 和子序列 b 第一个不相同的位置上，如果 a 中的数字小于 b 中对应的数字，
 * 那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 。 例如，[1,3,4] 比 [1,3,5] 更具竞争力，
 * 在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。
 * 输入：nums = [3,5,2,6], k = 2
 * 输出：[2,6]
 * 解释：在所有可能的子序列集合 {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 最具竞争力。
 */
public class MostCompetitive {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 6};
        int k = 2;
        Arrays.stream(mostCompetitive(nums, k)).forEach(t -> System.out.print(t + " "));

    }

    public static int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < nums.length; i++) {
            // 剩余的空位必须大于装在k的位置
            while(nums.length - i > k - stack.size() + 1 && stack.peek() > nums[i]) {
                stack.pop();
            }
            stack.push(nums[i]);
        }
        while(stack.size() > k + 1) {
            stack.pop();
        }
        int [] res = new int[k];
        for (int i = k-1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static List<List<Integer>> getSubSets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> copyItem = new ArrayList<>(res.get(i));
                copyItem.add(num);
                res.add(copyItem);
            }
        }
        return res;
    }
}
