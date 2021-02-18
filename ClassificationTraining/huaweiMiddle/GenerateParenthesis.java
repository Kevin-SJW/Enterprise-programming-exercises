package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname GenerateParenthesis
 * @Description TODO
 * @Date 2020/9/20 17:33
 * @Created by Administrator
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));

    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            res.add("");
        } else {
            for (int i = 0; i < n; i++) {
                for (String left : generateParenthesis(i)) {
                    for (String right : generateParenthesis(n - 1 - i)) {
                        res.add("(" + left + ")" + right);
                    }
                }
            }

        }
        return res;
    }
}
