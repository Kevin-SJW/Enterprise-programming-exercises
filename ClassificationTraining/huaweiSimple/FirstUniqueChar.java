package ClassificationTraining.huaweiSimple;

/**
 * @Classname FirstUniqueChar
 * @Description TODO
 * @Date 2020/10/5 17:10
 * @Created by Administrator
 */
public class FirstUniqueChar {
    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(firstUniqChar(s));

    }

    public static char firstUniqChar(String s) {
        for (char c : s.toCharArray()) {
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                return c;
            }
        }
        return ' ';


    }

    public static char firstUniqChar2(String s) {
        int[] count = new int[256];
        char[] chars = s.toCharArray();
        for (char c : chars)
            count[c]++;
        for (char c : chars) {
            if (count[c] == 1)
                return c;
        }
        return ' ';
    }
}
