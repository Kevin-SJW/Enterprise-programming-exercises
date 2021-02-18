package ClassificationTraining.huaweiMiddle;

/**
 * @Classname CustomSortString
 * @Description TODO
 * @Date 2020/10/2 9:47
 * @Created by Administrator
 * 示例:
 * 输入:
 * S = "cba"
 * T = "abcd"
 * 输出: "cbad"
 * 解释:
 * S中出现了字符 "a", "b", "c", 所以 "a", "b", "c" 的顺序应该是 "c", "b", "a".
 * 由于 "d" 没有在S中出现, 它可以放在T的任意位置. "dcba", "cdba", "cbda" 都是合法的输出。
 */
public class CustomSortString {
    public static void main(String[] args) {
        String s = "cba";
        String t = "abcd";
        System.out.println(customSortString(s, t));

    }

    public static String customSortString(String s, String t) {
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[t.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    nums[j] = 1;
                    sb.append(t.charAt(j));
                }
            }
        }
        for (int j = 0; j < t.length(); j++) {
            if (nums[j] != 1) {
                sb.append(t.charAt(j));
            }
        }
        return sb.toString();

    }
}
