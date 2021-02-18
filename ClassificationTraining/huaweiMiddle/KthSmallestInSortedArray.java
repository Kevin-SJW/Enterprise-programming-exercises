package ClassificationTraining.huaweiMiddle;

import java.util.*;

/**
 * @Classname KthSmallestInSortedArray
 * @Description TODO
 * @Date 2020/10/3 18:49
 * @Created by Administrator
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 */
public class KthSmallestInSortedArray {
    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        System.out.println(kthSmallest(matrix, k));

    }

    public static int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0) {
            return 0;
        }
        List<Integer> sortList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                    sortList.add(matrix[i][j]);
            }
        }

        Collections.sort(sortList);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(sortList.get(i));
        }
        return stack.peek();


    }
}
