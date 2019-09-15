package AutumnRecruitment;

/**
 * @Classname LongestPalidrome
 * @Description TODO
 * @Date 2019/9/15 15:13
 * @Created by 14241
 */

public class LongestPalidrome2 {
    public static void main(String[] args){
        String str="babad";
        System.out.println(longestPalindrome(str));

    }
    public static String longestPalindrome(String s) {
        if(s.equals("")&&s==null){
            return s;
        }
        int L=0,R=0,max=0;
        String ans="";
        for(float i=0;i<s.length();i=(float) (i+0.5)){
            if(i-(int)i==0){
                L=(int)i;
                R=(int)i;
            }
            else{
                L=(int)i;
                R=(int)i+1;
            }
            while(L>=0&&R<s.length()&&s.charAt(L)==s.charAt(R)){
                L--;
                R++;
            }
            L++;R--;
            String str=s.substring(L, R+1);
            if(str.length()>max){
                ans=str;
                max=str.length();
            }
        }
        return ans;
    }


}
