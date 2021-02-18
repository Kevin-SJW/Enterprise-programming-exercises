package ClassificationTraining.huaweiSimple;


/**
 * @Classname ReverseLeftWords
 * @Description TODO
 * @Date 2020/10/4 15:15
 * @Created by Administrator
 * 输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class ReverseLeftWords {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseLeftWords(s, k));

    }

    public static String reverseLeftWords(String s, int n) {
        String res = "";
        for (int i = n; i < n + s.length(); i++) {
            res += s.charAt(i % s.length());
        }
        return res;

    }
}
