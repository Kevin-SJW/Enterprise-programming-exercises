package ClassificationTraining.huaweiMiddle;

/**
 * @Classname LongestWPI
 * @Description TODO
 * @Date 2020/10/4 10:26
 * @Created by Administrator
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * 请你返回「表现良好时间段」的最大长度。
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 */
public class LongestWPI {
    public static void main(String[] args) {
        int[] hours = {9, 9, 6, 0, 6, 6, 9};
        System.out.println(longestWPI(hours));
    }

    public static int longestWPI(int[] hours) {
        int[] res = new int[hours.length];
        for (int i = 0; i < hours.length; i++) {
            res[i] = hours[i] > 8 ? 1 : -1;
        }
        int ans = 0;
        for (int i = 0; i < res.length; i++) {
            int count = 0;
            for (int j = i; j < res.length; j++) {
                count += res[j];
                if (count > 0) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;

    }

    public static int longestWPI2(int[] hours) {
        int[] res = new int[hours.length];
        for (int i = 0; i < hours.length; i++) {
            res[i] = hours[i] > 8 ? 1 : -1;
        }
        int ans = 0;
        for (int i = 0; i < res.length; i++) {
            int count = 0;
            for (int j = i; j < res.length; j++) {
                count+=res[j];
                if (count > 0) {
                    ans = Math.max(ans, j - i+1);
                }
            }
        }
        return ans;

    }
}
