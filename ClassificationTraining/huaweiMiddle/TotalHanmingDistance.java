package ClassificationTraining.huaweiMiddle;

/**
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 * 输入: 4, 14, 2
 * 输出: 6
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 *
 * 求数组汉明距离，我们可以每次遍历数组的一位上有多少0和多少1，
 * 该位的汉明距离的和就是0的个数×1的个数，因为0和0，1和1的汉明距离都是0。然后遍历32位，
 * 全部加起来即可。O(n)*32
 */
public class TotalHanmingDistance {
    public static void main(String[] args) {
        int[] nums = {4, 14, 2};
        System.out.println(totalHammingDistance(nums));
    }
    public static int totalHammingDistance(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int one = 0;
            for (int j = 0; j < len; j++) {
                one += (nums[j] & 1);
                nums[j] >>= 1;
            }
            ans += one * (len - one);

        }
        return ans;
    }
}
