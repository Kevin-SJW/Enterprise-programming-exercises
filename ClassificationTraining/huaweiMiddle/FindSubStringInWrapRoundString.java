package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname FindSubStringInWrapRoundString
 * @Description TODO
 * @Date 2020/11/11 0:00
 * @Created by Administrator
 * 把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以 s 看起来是这样的：
 * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....". 
 * <p>
 * 现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，尤其是当你的输入是字符串 p ，
 * 你需要输出字符串 s 中 p 的不同的非空子串的数目。 
 * <p>
 * 注意: p 仅由小写的英文字母组成，p 的大小可能超过 10000。
 */
public class FindSubStringInWrapRoundString {
    public static void main(String[] args) {
        String p = "cac";
        System.out.println(findSubstringInWraproundString(p));
        getSubString(p).stream().forEach(t -> System.out.print(t + " "));

    }

    public static int findSubstringInWraproundString(String p) {
        int[] record = new int[26];
        int last = 0;
        int res = 0;
        for (int i = 0; i < p.length(); i++) {
            int index = p.charAt(i) - 'a';
            int temp = 1;
            if (i >= 1 && (p.charAt(i - 1) - 'a' + 1) % 26 == index) {
                temp += last;
            }
            if (record[index] < temp) {
                res += temp - record[index];
                record[index] = temp;
            }
            last = temp;
        }
        return res;
    }

    public static List<String> getSubString(String p) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            for (int j = i + 1; j < p.length(); j++) {
                res.add(p.substring(i, j));
            }
        }
        return res;
    }
}
