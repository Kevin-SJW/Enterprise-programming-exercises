package CredibleExam.exam_12_27;

import java.util.*;

/**
 * @Classname CommonAlert
 * @Description TODO
 * @Date 2020/7/19 9:21
 * @Created by Administrator
 */
public class CommonAlert {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 5, 7, 9};
        int[] arr3 = {1, 3, 4, 5, 8};
        Arrays.stream(getCommonAlert(arr1, arr2, arr3)).forEach(t -> System.out.print(t + " "));
    }

    public static int[] getCommonAlert(int[] arr1, int[] arr2, int[] arr3) {
        if(arr1.length==0||arr2.length==0||arr3.length==0){
            return new int[0];
        }
        List<Integer> list=new ArrayList<>();
        for(int a1:arr1){
            //二分查找
            if(Arrays.binarySearch(arr2,a1)>=0&&Arrays.binarySearch(arr3,a1)>=0){
                list.add(a1);
            }
        }
        //采用流式stream进行处理
        return list.stream().mapToInt(Integer::valueOf).toArray();

//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < arr1.length; i++) {
//            set.add(arr1[i]);
//        }
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < arr2.length; i++) {
//            if (set.remove(arr2[i])) {
//                list.add(arr2[i]);
//            }
//        }
//        Set<Integer> set2 = new HashSet<>(list);
//        List<Integer> list2=new ArrayList<>();
//        for(int j=0;j<arr3.length;j++){
//            if(set2.remove(arr3[j])){
//                list2.add(arr3[j]);
//            }
//        }
//        int len=Math.min(list.size(),list2.size());
//        int[] res = new int[len];
//        for (int i = 0; i < list2.size(); i++) {
//            res[i] = list2.get(i);
//        }
//        Arrays.sort(res);
//        return res;


    }
}
