package ClassificationTraining.huaweiMiddle;

/**
 * @Classname MinSteps
 * @Description TODO
 * @Date 2020/12/6 11:15
 * @Created by Administrator
 * 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 * Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 * Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 * 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。
 * 输出能够打印出 n 个 'A' 的最少操作次数。
 * 输入: 3
 * 输出: 3
 * 解释:
 * 最初, 我们只有一个字符 'A'。
 * 第 1 步, 我们使用 Copy All 操作。
 * 第 2 步, 我们使用 Paste 操作来获得 'AA'。
 * 第 3 步, 我们使用 Paste 操作来获得 'AAA'。
 */
public class MinSteps {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(minSteps(n));
    }

    public static int minSteps(int n) {
        int res = 0, d = 2;
        while (n > 1) {
            //能被素数整除，就一直执行循环
            while (n % d == 0) {
                res += d;
                n /= d;
            }
            //2和3遍历完,n基本无法被偶数整除
            d++;
        }
        return res;
    }
}
