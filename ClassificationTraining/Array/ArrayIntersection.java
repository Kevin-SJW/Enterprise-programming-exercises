package ClassificationTraining.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname ArrayIntersection
 * @Description TODO
 * @Date 2020/9/26 10:41
 * @Created by Administrator
 */
public class ArrayIntersection {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Arrays.stream(intersect2(nums1, nums2)).forEach(t -> System.out.print(t + " "));

    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                ans.add(nums1[i]);
                i++;
                j++;
            }
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();

    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> ans = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                ans.add(nums1[i]);
                i++;
                j++;
            }

        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
}
