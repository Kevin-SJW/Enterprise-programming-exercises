package ClassificationTraining.huaweiSimple;

import java.util.Arrays;

/**
 * 给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。944
 * 你需要选出一组要删掉的列 D，对 A 执行删除操作，使 A 中剩余的每一列都是
 * 非降序 排列的，然后请你返回 D.length 的最小可能值。
 * 删除 操作的定义是：选出一组要删掉的列，删去 A 中对应列中的所有字符，
 * 形式上，第 n 列为 [A[0][n], A[1][n], ..., A[A.length-1][n]]）。
 * 输入：["cba", "daf", "ghi"]
 * 输出：1
 * 解释：
 * 当选择 D = {1}，删除后 A 的列为：["c","d","g"] 和 ["a","f","i"]，均为非降序排列。
 * 若选择 D = {}，那么 A 的列 ["b","a","h"] 就不是非降序排列了。 
 */
public class MinDeleteSize {
    public static void main(String[] args) {
        String[] A = {"cba", "daf", "ghi"};
        String[] B = {"zyx", "wvu", "tsr"};
        System.out.println(minDeletionSize2(A));
    }

    public static int minDeletionSize(String[] A) {
        int length = A[0].length();
        int index = 0;
        if (A.length == 0) {
            return 0;
        }
        for (int i = 0; i < length; i++) {
            char[] temp = new char[A.length];
            for (int j = 0; j < A.length; j++) {
                temp[j] = A[j].charAt(i);
            }
            if (isNonDecrese(temp)) {
                index++;
                break;
            }
        }
        return index;
    }


    public static boolean isNonDecrese(char[] temp) {
        char[] clone = temp.clone();
        Arrays.sort(temp);
        return Arrays.equals(temp, clone);
    }

    //非降序序列
    public static int minDeletionSize2(String[] A) {
        int length = A[0].length();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < A.length - 1; j++) {
                if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                    sum++;
                    break;
                }
            }
        }
        return sum;


    }
}
