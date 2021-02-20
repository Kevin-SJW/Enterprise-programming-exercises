package LeetCodeSimple;

import java.util.Arrays;

/**
 * @Classname PlusOne
 * @Description TODO
 * @Date 2020/6/26 16:22
 * @Created by Administrator
 * Input: [1,2,3]
 * Output: [1,2,4]
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits={1,2,9};
        Arrays.stream(plusOne(digits)).forEach(t-> System.out.print(t+" "));

    }
    public static int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[0]!=9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;

        }
        //跳出for循环，说明数字全部是9
        int[] newDigits=new int[digits.length+1];
        newDigits[0]=1;
        return newDigits;
    }
}
