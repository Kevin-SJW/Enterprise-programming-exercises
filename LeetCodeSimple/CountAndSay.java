package LeetCodeSimple;

/**
 * @Classname CountAndSay
 * @Description TODO
 * @Date 2020/6/26 15:15
 * @Created by Administrator
 * Input: 4
 * Output: "1211"
 */
public class CountAndSay {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(countAndSay(n));

    }

    public static String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }
        int i = 1;
        String result = "1";
        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;

        }
        return result;
    }
}
