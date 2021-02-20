package CredibleExam.exam_4_24;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname MaxDepthParentheseProduct
 * @Description TODO
 * @Date 2020/8/1 0:27
 * @Created by Administrator
 */
public class MaxDepthParentheseProduct {
    public static void main(String[] args) {
        String seq = "(3,(1,(5,2),(4)))";
        System.out.println(maxDepthParentheseProduct(seq));
    }
    public static int maxDepthParentheseProduct(String seq) {
        if (seq == null || seq.length() == 0) {
            return 0;
        }
        int temp = 0;
        List<Integer> number = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seq.length() - 1; i++) {
            String present = seq.substring(i, i + 1);
            String next = seq.substring(i + 1, i + 2);
            //对当前数字判断，更新level
            if (present.equals("(")) {
                temp++;
                continue;
            } else if (present.equals(")")) {
                temp--;
                continue;
            } else if (present.equals(",")) {
                continue;
            } else {
                sb.append(present);
            }
            //下一个非数字，对当前数字和level值保存
            if (next.equals("(") || next.equals(")") || next.equals(",")) {
                number.add(Integer.parseInt(sb.toString()));
                level.add(temp);
                sb = new StringBuilder();
            }
        }
        int sum = 0;
        for (int i = 0; i < number.size(); i++) {

            sum += number.get(i) * level.get(i);
        }
        return sum;
    }
}
