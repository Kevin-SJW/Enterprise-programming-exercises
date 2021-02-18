package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;

/**
 * @Classname FindPermutation
 * @Description TODO
 * @Date 2021/1/12 0:38
 * @Created by Administrator
 * 现在给定一个只由字符 'D' 和 'I' 组成的 秘密签名。'D' 表示两个数字间的递减关系，'I'
 * 表示两个数字间的递增关系。并且 秘密签名 是由一个特定的整数数组生成的，
 * 该数组唯一地包含 1 到 n 中所有不同的数字（秘密签名的长度加 1 等于 n）。
 * 例如，秘密签名 "DI" 可以由数组 [2,1,3] 或 [3,1,2] 生成，
 * 但是不能由数组 [3,2,4] 或 [2,1,3,4] 生成，因为它们都不是合法的能代表 "DI" 秘密签名 的特定串。
 * <p>
 * 现在你的任务是找到具有最小字典序的 [1, 2, ... n] 的排列，使其能代表输入的 秘密签名。
 * 输入： "I"
 * 输出： [1,2]
 * 解释： [1,2] 是唯一合法的可以生成秘密签名 "I" 的特定串，数字 1 和 2 构成递增关系。
 */
public class FindPermutation {
    public static void main(String[] args) {
        String s = "I";
        Arrays.stream(findPermutation(s)).forEach(t -> System.out.print(t + " "));
    }

    public static int[] findPermutation(String s) {
        int[] res = new int[s.length() + 1];
        for (int i = 0; i < res.length; i++)
            res[i] = i + 1;
        int i = 1;  // i 为数字，作为索引的时候要减一，因为题目要求的 res 是从 1 到 n
        while (i <= s.length()) {
            int j = i;
            // i 没有超出索引，且当前字符为 D，于是 j-1 就是 start，i 为 end
            while (i <= s.length() && s.charAt(i - 1) == 'D')
                i++;
            reverse(res, j - 1, i);
            i++;
        }
        return res;
    }

    /**
     * 对数组 a 的 [start, end] 元素进行翻转
     */
    public static void reverse(int[] a, int start, int end) {
        for (int i = 0; i < (end - start) / 2; i++) {
            int temp = a[i + start];
            a[i + start] = a[end - i - 1];
            a[end - i - 1] = temp;
        }
    }
}
