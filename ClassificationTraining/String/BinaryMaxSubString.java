package ClassificationTraining.String;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname BinaryMaxSubString
 * @Description TODO
 * @Date 2020/9/29 0:29
 * @Created by Administrator
 */
public class BinaryMaxSubString {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(binaryMaxSubString(n));

    }

    public static int binaryMaxSubString(int n) {
        String bi = Integer.toBinaryString(n);
        return longestSubString(bi);

    }

    public static int longestSubString(String s) {
        Set<Character> set = new HashSet<>();
        int n=s.length();
        int max = 0;
        int i=0, j=0;
        while (i <n && j <n) {
            set.add(s.charAt(i));
            if (set.contains(s.charAt(j++))) {
                max=Math.max(max,j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
}



