package coding;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Classname ValidParentheses
 * @Description
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * @Date 2019/4/20 11:44
 * @Created by 14241
 */
public class ValidParentheses {
    public static void main(String[] args){
        String s="()()()(";
        System.out.println(isValid(s));

    }

        private  static boolean isValid(String s){
            HashMap<Character,Character> map = new HashMap<Character,Character>();
            map.put(')','(');
            map.put(']','[');
            map.put('}','{');
            Stack<Character> stack=new Stack<Character>();
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if(map.containsKey(c)){
                    if(stack.isEmpty()||!stack.pop().equals((map.get(c)))){
                        return false;

                    }
                }
                else {
                    stack.push(c);
                }

            }
            return stack.isEmpty();
        }
    }

