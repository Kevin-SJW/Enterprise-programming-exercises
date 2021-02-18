package ClassificationTraining.huaweiSimple;

/**
 * @Classname RemoveOutermostParenthese
 * @Description TODO
 * @Date 2020/9/13 10:32
 * @Created by Administrator
 */
public class RemoveOutermostParenthese {
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }

    public static String removeOuterParentheses(String S) {
        int level = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (c == ')') {
                level--;
            }

            if (level >= 1) {
                sb.append(c);
            }
            if (c == '(') {
                level++;
            }
        }
        return sb.toString();
    }
}

