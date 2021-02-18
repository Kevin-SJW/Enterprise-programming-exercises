package ClassificationTraining.huaweiSimple;

/**
 * @Classname RepeatedSubStringPattern
 * @Description TODO
 * @Date 2020/10/3 19:30
 * @Created by Administrator
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
 * 给定的字符串只含有小写英文字母，并且长度不超过10000。
 */
public class RepeatedSubStringPattern {
    public static void main(String[] args) {
        String s = "abab";
        System.out.println(repeatedSubstringPattern(s));
        System.out.println(test32(857));

    }

    public static boolean repeatedSubstringPattern(String s) {
        if (s.length() == 0) {
            return false;
        }
        String plus = s + s;

        return plus.substring(1, plus.length() - 1).contains(s);
    }

    public static String test32(int a){
        return Integer.toString(a,32);
    }
}
