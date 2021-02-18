package ClassificationTraining.huaweiMiddle;

/**
 * @Classname SmallestCommonElement
 * @Description TODO
 * @Date 2020/10/5 17:33
 * @Created by Administrator
 * 给你一个矩阵 mat，其中每一行的元素都已经按 递增 顺序排好了。请你帮忙找出在所有这些行中 最小的公共元素。
 * <p>
 * 如果矩阵中没有这样的公共元素，就请返回 -1。
 * <p>
 *  
 */
public class SmallestCommonElement {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4, 5}, {2, 4, 5, 8, 10},
                {3, 5, 7, 9, 11}, {1, 3, 5, 7, 9}};
        System.out.println(smallestCommonElement(mat));

    }

    public static int smallestCommonElement(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[] count = new int[10000];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (++count[mat[i][j]] == row) {
                    return mat[i][j];
                }
            }
        }
        return -1;
    }

    public int smallestCommonElement3(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[] count = new int[10000];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ++count[mat[i][j]];
            }
        }
        for (int i = 0; i < 10000; i++) {
            if (count[i] == row) {
                return i;
            }
        }
        return -1;

    }

    /**
     * 方法一：统计元素出现次数
     * 逐行遍历所有元素，并统计每个元素的出现次数。因为元素在 [1...10000] 范围内，所以使用数组记录每个元素的出现次数。
     * <p>
     * 然后，从左至右遍历数组，返回第一个出现 n 次的元素。顺便说一下，这就是计数排序方法。
     *
     * @param mat
     * @return
     */
    public int smallestCommonElement2(int[][] mat) {
        int count[] = new int[10001];
        int n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                ++count[mat[i][j]];
            }
        }
        for (int k = 1; k <= 10000; ++k) {
            if (count[k] == n) {
                return k;
            }
        }
        return -1;
    }


}
