import java.util.Stack;

/**
 * @Classname LongestValidParentheses
 * @Description TODO
 * @Date 2019/4/21 16:50
 * 遇到左括号就把它的index压栈，遇到右括号先检查栈是否为空，为空就说明是())这种情形，
 * 所以把start右移一位，直到找到一个(为止；
 * 不为空就pop出一个元素，这时候要进行第二次判空，如果为空，说明是()了，
 * 判断i-start+1；如果不为空就说明是((),那么返回i-peak+1
 *
 * @Created by 14241
 */
public class LongestValidParentheses {
    public static void main(String[] args){
        String s="()()()(";
        System.out.println(longestValidParentheses(s));

    }

    private  static int longestValidParentheses(String s){
        int maxLen=0;
        Stack<Integer> stack =new Stack<>();
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    maxLen=Math.max(maxLen,i-stack.peek());
                }
            }

        }
        return maxLen;

    }
}
