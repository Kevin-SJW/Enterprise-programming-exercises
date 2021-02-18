package ClassificationTraining.huaweiSimple;

import AutumnRecruitment.chap1_3.Stack;

/**
 * @Classname BalancedStringSplit
 * @Description TODO
 * @Date 2020/10/4 16:48
 * @Created by Administrator
 */
public class BalancedStringSplit {
    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        System.out.println(balancedStringSplit2(s));

    }

    public static int balancedStringSplit(String s) {
        int res = 0;
        int nums = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                nums++;
            } else {
                nums--;
            }
            if (nums == 0) {
                res++;
            }
        }
        return res;
    }

    public static int balancedStringSplit2(String s) {
        int count=0;
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(stack.isEmpty()||stack.peek()==c){
                stack.push(c);
            }else{
                stack.pop();
            }
            if(stack.isEmpty()){
                count++;
            }
        }
        return count;
    }
}
