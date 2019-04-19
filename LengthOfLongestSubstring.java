import java.util.*;

/**
 * @Classname LengthOfLongestSubstring
 * @Description TODO
 * @Date 2019/4/19 13:47
 * @Created by 14241
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        String line=sc.nextLine();
        System.out.println(lengthOfLongestSubstring(line));

    }
    public static int lengthOfLongestSubstring(String s){
        int ans=0,i=0,j=0;
        int n=s.length();
        HashSet<Character> set=new HashSet<>();
        while(i<n&&j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans=Math.max(ans,j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
