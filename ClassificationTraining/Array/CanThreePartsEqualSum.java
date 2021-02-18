package ClassificationTraining.Array;

/**
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * 形式上，如果可以找出索引 i+1 < j 且满足 A[0] + A[1] + ... + A[i]
 * == A[i+1] + A[i+2] + ... + A[j-1] ==
 * A[j] + A[j-1] + ... + A[A.length - 1] 就可以将数组三等分。
 */
public class CanThreePartsEqualSum {
    public static void main(String[] args) {
        int[] num = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        System.out.println(canThreePartsEqualSum(num));
    }

    public static boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        int count = 0;
        for (int num : A) {
            sum += num;
        }
        if (sum % 3 != 0) {
            return false;
        }

        int i = 0;
        for (int temp = 0; i < A.length; i++) {
            temp += A[i];
            if (temp == sum / 3) {
                count++;
                break;
            }
        }
        int temp2 = 0;
        for (i = i + 1; i < A.length; i++) {
            temp2 += A[i];
            if (temp2 == sum / 3) {
                count++;
                break;
            }
        }
        return count == 2 && i < A.length;
    }

    public static boolean canThreePartsEqualSum2(int[] A) {
        int count = 0;
        int sum = 0;
        for (int num : A) {
            sum += num;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int i = 0;
        for (int temp = 0; i < A.length; i++) {
            temp += A[i];
            if (temp == sum / 3) {
                count++;
                break;
            }
        }
        int temp2 = 0;
        for (i = i + 1; i < A.length; i++) {
            temp2 += A[i];
            if (temp2 == sum / 3) {
                count++;
                break;
            }
        }
        return count == 2 && i < A.length;
    }

}
