package ClassificationTraining.huaweiMiddle;

/**
 * @Classname NextGreatElement3
 * @Description TODO
 * @Date 2020/11/29 9:46
 * @Created by Administrator
 * 给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，
 * 并且其值大于n。如果不存在这样的32位整数，则返回-1。
 * 输入: 12
 * 输出: 21
 * 题意不太好理解，加黑强调32位正整数，让我把int n处理成无符型，提交后输入 Integer.MAX_VALUE 报错了，
 * 我知道官方题解就是正常整型输入了。
 * 从右往左遍历，找当前位数右边的最小的最大值，关键就是这个最小的最大值
 * 找到后进行交换，交换后，要对当前位的下一位的所有位数进行升序排序
 * 处理大于 Integer.Max_VALUE 的情况
 * 时间复杂度 O(n)，空间复杂度 O(n)
 */
public class NextGreatElement3 {
    public static void main(String[] args) {
        int n=12;
        System.out.println(nextGreaterElement(n));
    }

    public static int nextGreaterElement(int n) {
        char[] chars = (n + "").toCharArray();
        char[] cs = new char[chars.length];
        int j = 0;
        int index = chars.length - 1;
        cs[j] = chars[index--];
        while (index >= 0 && chars[index] >= cs[j]) {
            j++;
            cs[j] = chars[index--];
        }
        if (index < 0) {
            return -1;
        }
        for (int i = 0; i < cs.length; i++) {
            if (chars[index] < cs[i]) {
                char temp = chars[index];
                chars[index] = cs[i];
                cs[i] = temp;
                break;
            }
        }
        j = 0;
        for (int i = index + 1; i < chars.length; i++) {
            chars[i] = cs[j++];
        }

        long ans = Long.parseLong(new String(chars));
        if (ans > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) ans;

    }
}
