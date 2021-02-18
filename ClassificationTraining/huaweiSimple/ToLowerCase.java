package ClassificationTraining.huaweiSimple;

/**
 * @Classname ToLowerCase
 * @Description TODO
 * @Date 2020/8/23 8:55
 * @Created by Administrator
 */
public class ToLowerCase {
    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(toLowerCase(s));

    }

    public static String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append((char)(c+32));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();

    }
}
