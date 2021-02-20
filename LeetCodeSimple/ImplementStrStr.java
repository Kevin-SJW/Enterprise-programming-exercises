package LeetCodeSimple;

/**
 * @Classname ImplementStrStr
 * @Description TODO
 * @Date 2020/6/26 8:54
 * @Created by Administrator
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        System.out.println(strStr(haystack,needle));

    }
    public static int strStr(String haystack, String needle) {
        char[] a1=haystack.toCharArray();
        char[] a2=needle.toCharArray();
        if(a2.length==0){
            return 0;
        }
        for(int i=0;i<a1.length;i++){
            boolean flag=true;
            for(int j=0;j<a2.length;j++){
                if(i+j>=a1.length||a1[i+j]!=a2[j]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                return i;
            }
        }
        return -1;

    }
}
