package CredibleExam.exam_7_24;

import java.util.*;

/**
 * @Classname RelativeSortArray
 * @Description TODO
 * @Date 2020/7/21 0:02
 * @Created by Administrator
 * 输出 2 2 2 1 4 3 3 9 6 7 19
 */
public class RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        Arrays.stream(relativeSortArray(arr1, arr2)).forEach(t -> System.out.print(t + " "));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int size = Math.max(arr1.length, arr2.length);

        int t = 0;
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }

        for (int j = 0; j < arr1.length; j++) {
            if (!set.contains(arr1[j])) {
                list.add(arr1[j]);

            }
        }
        Collections.sort(list);
        int[] ans = new int[size - list.size()];
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr2[i] == arr1[j]) {
                    ans[t++] = arr1[j];
                }
            }

        }
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < ans.length; i++) {
            list2.add(ans[i]);
        }
        list2.addAll(list);
//        Arrays.stream(ans).forEach(p -> System.out.print(p + " "));
//        System.out.println();
        return list2.stream().mapToInt(Integer::valueOf).toArray();
    }

}
