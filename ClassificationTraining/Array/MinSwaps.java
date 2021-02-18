package ClassificationTraining.Array;

/**
 * @Classname MinSwaps
 * @Description TODO
 * @Date 2020/9/26 15:21
 * @Created by Administrator
 * 输入：[1,0,1,0,1]
 * 输出：1
 * 解释：
 * 有三种可能的方法可以把所有的 1 组合在一起：
 * [1,1,1,0,0]，交换 1 次；
 * [0,1,1,1,0]，交换 2 次；
 * [0,0,1,1,1]，交换 1 次。
 * 所以最少的交换次数为 1。
 */
public class MinSwaps {
    public static void main(String[] args) {
        int[] data = {1, 0, 1, 0, 1};
        System.out.println(minSwaps(data));

    }

    public static int minSwaps(int[] data) {
        int oneCount = 0;
        for (int i = 0; i < data.length; i++) {
            oneCount += data[i];
        }
        int[] prefixSum = new int[data.length + 1];
        for (int i = 1; i < data.length+1 ; i++) {
            prefixSum[i] = prefixSum[i - 1] + data[i - 1];
        }
        int maxSum = 0;
        for (int i = 0; i < data.length - oneCount + 1; i++) {
            int sum = prefixSum[i + oneCount] - prefixSum[i];
            maxSum = Math.max(maxSum, sum);
        }
        return oneCount - maxSum;
    }
}
