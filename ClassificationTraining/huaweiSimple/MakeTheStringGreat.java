package ClassificationTraining.huaweiSimple;

import java.util.Stack;

/**
 * @Classname MakeTheStringGreat
 * @Description TODO
 * @Date 2020/10/1 11:03
 * @Created by Administrator
 */
public class MakeTheStringGreat {
    public static void main(String[] args) {
        String s = "leEeetcode";
        System.out.println(makeGood(s));

    }

    public static String makeGood(String s) {
        if (s.length() == 0||s.length()==1) {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(c);
                continue;
            }
            char temp=stack.peek();
            if(c-temp==32||temp-c==32){
                stack.pop();

            }else{
                stack.push(c);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
