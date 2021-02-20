package coding;

/**
 * @Classname LongestCommonPrefix
 * @Description TODO
 * @Date 2019/4/19 21:24
 * @Created by 14241
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "" ;
        }

        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()){
                    return "";
                }
            }

        }
        return prefix;

    }
    public static void main(String[] args){
        String[] str={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(str));

    }
}
