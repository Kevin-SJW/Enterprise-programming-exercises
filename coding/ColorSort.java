package coding;

import java.util.Arrays;

/**
 * @Classname ColorSort
 * @Description 荷兰国旗包含三种颜色：红、白、蓝。
 * 有三种颜色的球，算法的目标是将这三种球按颜色顺序正确地排列。
 * 它其实是三向切分快速排序的一种变种，在三向切分快速排序中，每次切分都将数组分成三个区间：
 * 小于切分元素、等于切分元素、大于切分元素，而该算法是将数组分成三个区间：等于红色、等于白色、等于蓝色。
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * @Date 2019/4/13 16:20
 * @Created by 14241
 */
public class ColorSort {
    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};
        System.out.print(Arrays.toString(sortColor(nums)));
        System.out.println();
        sortColors2(nums);

    }

    private static int[] sortColor(int[] nums) {
        int zero = -1, one = 0, two = nums.length;
        while (one < two) {
            if (nums[one] == 0) {
                swap(nums, ++zero, one++);
            } else if (nums[one] == 2) {
                swap(nums, --two, one);
            } else {
                ++one;
            }
        }
        return nums;

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void sortColors2(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        Arrays.stream(count).forEach(t-> System.out.print(t+" "));
    }
}
