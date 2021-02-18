package ClassificationTraining.huaweiMiddle;

/**
 * @Classname NumberTranslateIntoString
 * @Description TODO
 * @Date 2020/9/18 0:09
 * @Created by Administrator
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，
 * 11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。
 * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 开始深搜，分为三种情况，第一种：个位数；第二种：小于26的两位数；第三种：十位为0的两位数；然后没事了...
 */
public class NumberTranslateIntoString {
    static int ans = 0;

    public static void main(String[] args) {
        int num = 12258;
        System.out.println(translateNum(num));

    }

    public static int translateNum(int num) {
        dfs(num);
        return ans;

    }

    public static void dfs(int num) {
        if (num < 10) {
            ans++;
            return;
        }
        dfs(num / 10);
        if (num % 100 < 26 && num % 100 != num % 10) {
            dfs(num / 100);
        }
    }
}
