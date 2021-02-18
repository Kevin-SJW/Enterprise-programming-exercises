package ClassificationTraining.huaweiMiddle;

import java.util.Stack;

/**
 * @Classname RemoveDuplicateLetters
 * @Description TODO
 * @Date 2020/8/14 0:55
 * @Created by Administrator
 * 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，
 * 使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            Character c=s.charAt(i);
            if(stack.contains(c)){
                continue;
            }
            //遇到一个新字符 如果比栈顶小 并且在新字符后面还有和栈顶一样的 就把栈顶的字符抛弃了
            while(!stack.isEmpty()&&stack.peek()>c&&s.indexOf(stack.peek(),i)!=-1){
                stack.pop();
            }
            stack.push(c);
        }
        char[] ch=new char[stack.size()];
        for(int i=0;i<stack.size();i++){
            ch[i]=stack.get(i);
        }
        return new String(ch);

    }
}
