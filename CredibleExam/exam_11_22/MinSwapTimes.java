package CredibleExam.exam_11_22;

import java.util.*;
/**
 * @Classname MinSwapTimes
 * @Description TODO
 * @Date 2020/7/12 19:36
 * @Created by Administrator
 */
public class MinSwapTimes {
    public static void main(String[] args) {
        int[] array;
        Solution solution = new Solution();
        int num = 0;
        array = new int[] {2,0,1};
        num = solution.swap(array);
        System.out.println("num = " + num);
    }

    static class Solution {
        public int swap(int[] array) {
            if(array.equals(null)) {
                return 0;
            }
            int[] sortA = (int[]) array.clone();
            Arrays.sort(sortA);

            int num =0;
            for (int i = 0; i < array.length; i++) {
                if(array[i] == sortA[i] ) {
                    continue;
                }
                for (int j = i + 1; j < array.length; i++) {
                    if(array[j] == sortA[i]) {
                        int tmp = array[i];
                        array[i] = array[j];
                        array[j] = tmp;
                        num++;
                        break;
                    }
                }
            }
            return num;
        }
    }

//    public static void main(String[] args) {
//        int[] arr={2,0,1};
//        System.out.println(minSwapTimes(arr));
//
//    }
//    public static int minSwapTimes(int[] array){
//        int count=0;
//        for(int i=0;i<array.length;i++){
//            if(array[i]!=i){
//                swap(array);
//                count++;
//            }else{
//                return 0;
//            }
//        }
//        return count-1;
//    }
//    private static void swap(int[] arr){
//        for(int i=0;i<arr.length;i++){
//            int temp=arr[i];
//            arr[i]=arr[arr[i]];
//            arr[arr[i]]=temp;
//        }
//    }


}
