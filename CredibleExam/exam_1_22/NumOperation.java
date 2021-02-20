package CredibleExam.exam_1_22;

import java.util.Arrays;

/**
 * 提供一堆数组，每次使用数组中的两个最小的数，计算出两个最小的数的最小公倍数，删除两个最小的数，
 * 插入该最小公倍数，直到数组中的值都大于目标；如果最终数组的值都大于目标值，则返回计算轮数，否则返回-1。
 */
public class NumOperation {
    public static int count;
    public static void main(String[] args) {
        int[] numbers={4,5,5,1};int target=3;
        System.out.println(operation(target,numbers));
    }
    public static int operation(int target,int[] numbers){
        count=0;
        return numOperation(target,numbers);
    }

    public static int numOperation(int target, int[] numbers) {
        Arrays.sort(numbers);
        if(numbers[0]>=target){
            return count;
        }
        if(numbers.length<2){
            return -1;
        }
        count++;
        int num0=numbers[0];
        int num1=numbers[1];
        numbers[1]=lcm(num0,num1);
        int[] tmp=new int[numbers.length-1];
        System.arraycopy(numbers,1,tmp,0,numbers.length-1);
        return numOperation(target,tmp);

    }
    //最小公倍数
    public static int lcm(int a, int b) {
        int m = a, n = b;
        int t = m % n;
        while (t != 0) {
            m = n;
            n = t;
            t = m % n;
        }
        return a * b / n;
    }
}
