package ClassificationTraining.String;

/**
 * @Classname MaxConsecutiveOnes3
 * @Description TODO
 * @Date 2020/7/28 0:43
 * @Created by Administrator
 * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * Output: 6
 * Explanation:
 * [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 */
public class MaxConsecutiveOnes3 {
    public static void main(String[] args) {
        int[] A = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(longestOnes(A, k));
    }

    public static int longestOnes(int[] A, int k) {
        int cnt = 0, l = 0, r = 0, res = 0;
        while (r < A.length) {
            if (A[r] == 0) {
                cnt++;
            }
            while (cnt > k) {
                if (A[l++] == 0) {
                    cnt--;
                }
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

    public static int longestOnes2(int[] A, int k) {
        int l = 0, r = 0, cnt = 0;
        int res = 0;
        while (r < A.length) {
            if (A[r] == 0) {
                cnt++;
            }
            while (cnt > k) {
                if (A[l++] == 0) {
                    cnt--;
                }
            }

            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
