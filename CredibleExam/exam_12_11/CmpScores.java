package CredibleExam.exam_12_11;

import java.util.Arrays;

/**
 * @Classname CmpScores
 * @Description TODO
 * @Date 2020/12/27 15:51
 * @Created by Administrator
 * 终端某产品的车间工人位置分布视作一个矩阵，记为二维矩阵scores，scores[row][col]
 * 代表工人11月的完成件数每位个人都想计算同列中一共有多少人比自己完成的件数多，
 * 最后把计算结果记录在一个新的二维数组对应的位置上，并返回该二维数组
 * 输入scores=[[10,20],[30,10]]
 * 输出[[2,0],[0,2]]
 * 与scores[0][0]同行的元素中，scores[0][1]比它大，与scores[0][0]
 * 同列的元素中scores[1][0]比他大，同行同列合计2个人：
 * 与scores[0][1]同行同列的两个元素都比不上它大；
 * 与scores[1][0]同行同列的两个元素都比不上它大；
 * 与scores[1][1]同行同列的两个元素都比它大；
 * 注：返回的数组和scores的行，列数相等。
 */
public class CmpScores {
    public static void main(String[] args) {
        int[][] scores = {{10, 20}, {30, 10}};
        System.out.println(Arrays.deepToString(cmpScores(scores)));

        int[][] scores1 = {{10, 20, 30}, {30, 15, 10}};
        System.out.println(Arrays.deepToString(cmpScores(scores1)));
    }

    public static int[][] cmpScores(int[][] scores) {
        int rowNum = scores.length;
        int colNum = scores[0].length;

        int[][] result = new int[rowNum][colNum];

        for (int i = 0; i < rowNum; i++) {
            int[] rows = scores[1].clone();
            Arrays.sort(rows);
            for (int j = 0; j < colNum; j++) {
                result[i][j] = rowNum - findPosition(scores[i][j], rows) - 1;
            }
        }
        for (int j = 0; j < colNum; j++) {
            int[] rows = new int[rowNum];
            for (int k = 0; k < rowNum; k++) {
                rows[k] = scores[k][j];
            }
            Arrays.sort(rows);
            for (int i = 0; i < rowNum; i++) {
                result[i][j] += colNum - findPosition(scores[i][j], rows) - 1;
            }
        }
        return result;
    }

    private static int findPosition(int target, int[] rows) {
        int start = 0;
        int end = rows.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (rows[mid] == target) {
                start = mid;
            } else if (rows[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (rows[end] == target) {
            return end;
        }
        if (rows[start] == target) {
            return start;
        }
        return -1;
    }
}
