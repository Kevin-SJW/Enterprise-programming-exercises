package LeetCodeSimple;

import java.util.Arrays;

/**
 * @Classname MergeSortedArray
 * @Description TODO
 * @Date 2020/6/27 9:27
 * @Created by Administrator
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        Arrays.stream(nums1).forEach(t -> System.out.print(t + " "));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (k >= 0) {
            if (j < 0 || (i >= 0 && nums1[i] > nums2[j])) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (k >= 0) {
            if (j < 0 || (i >= 0 && nums1[i] > nums2[i])) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[i--];
            }
        }
    }
}
