package ClassificationTraining.huaweiSimple;

import java.util.Arrays;

/**
 * @Classname CountBits
 * @Description TODO
 * @Date 2020/8/23 11:25
 * @Created by Administrator
 * medium
 */
public class CountBits {
    public static void main(String[] args) {
        int n=2;
        Arrays.stream(countBits(n)).forEach(t-> System.out.print(t+" "));

    }
    public static int[] countBits(int num) {
        int[] ans = new int[num+1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i & (i - 1)] + 1;
        return ans;
    }
}
