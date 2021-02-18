package ClassificationTraining.String;

/**
 * @Classname CheckValidString
 * @Description TODO
 * @Date 2020/9/26 18:04
 * @Created by Administrator
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。
 * 有效字符串具有如下规则：
 * <p>
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 */
public class CheckValidString {
    public static void main(String[] args) {
        String s = "(*))";
        System.out.println(checkValidString(s));

    }

    public static boolean checkValidString(String s) {
        if (s == null) {
            return true;
        }
        int max = 0;
        int min = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                max++;
                min++;
            } else if (c == ')') {
                max--;
                min = Math.max(0, min - 1);
            } else {
                max++;
                min = Math.max(0, min - 1);
            }
            // 剪枝
            if (max < 0) {
                return false;
            }

        }
        return min == 0;

    }

    public static boolean checkValidString2(String s) {
        if (s == null) {
            return true;
        }
        int max = 0;
        int min = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                max++;
                min++;
            } else if (c == ')') {
                max--;
                min = Math.max(0, min - 1);
            } else {
                max++;
                min = Math.max(0, min - 1);
            }
            if (max < 0) {
                return false;
            }
        }

        return min == 0;
    }
}
