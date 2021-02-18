package ClassificationTraining.PatternTwoPointers;

/**
 * @Classname SubArrayProductLessThanK
 * @Description TODO
 * @Date 2020/7/22 22:36
 * @Created by Administrator
 * medium
 * Your are given an array of positive integers nums.
 * <p>
 * Count and print the number of (contiguous) subarrays where the product of all the elements
 * in the subarray is less than k.
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 */
public class SubArrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0 || k == 1) {
            return 0;
        }
        int res = 0;

        int left = 0, right = 0;
        int segmentProduct = 1;
        while (right < nums.length) {

            segmentProduct *= nums[right++];
            while (segmentProduct >= k) {
                segmentProduct /= nums[left++];
            }
            res += right - left;

        }

        return res;
    }

    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0 || k == 1) {
            return 0;
        }
        int res = 0;
        int left = 0, right = 0;
        int segmentSum = 1;
        while (right < nums.length) {
            segmentSum *= nums[right++];
            if (segmentSum >= k) {
                segmentSum /= nums[left++];
            }
            res += right - left;
        }
        return res;

    }

}

//        if(k == 0 || k == 1)    return 0;
//        int l = 0,sum = 0,res = 1;
//        for(int r=0;r<nums.length;++r){
//            res *= nums[r];
//            while(res >= k){
//                res /= nums[l];
//                l++;
//            }
//            sum += (r-l+1);
//        }
//        return sum;

