package ClassificationTraining.huaweiMiddle;

import java.util.*;

/**
 * @Classname FindDiagonalOrder
 * @Description TODO
 * @Date 2020/10/5 18:15
 * @Created by Administrator
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），
 * 请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * <p>
 * 横纵坐标和为对角线索引
 */
public class FindDiagonalOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Arrays.stream(findDiagonalOrder2(matrix)).forEach(t -> System.out.print(t + " "));

    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!map.containsKey(i + j)) {
                    map.put(i + j, new ArrayList<>());
                }
                map.get(i + j).add(matrix[i][j]);
            }
        }
        List<Integer> res = new ArrayList<>();
        map.forEach((k, v) -> {
            if ((k & 1) == 0) {
                Collections.reverse(v);
            }
            res.addAll(v);
        });
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static int[] findDiagonalOrder2(int[][] matrix) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!map.containsKey(i + j)) {
                    map.put(i + j, new ArrayList<>());
                }
                    map.get(i + j).add(matrix[i][j]);

            }
        }
        List<Integer> res = new ArrayList<>();
        map.forEach((k, v) -> {
            if ((k & 1) == 0) {
                Collections.reverse(v);
            }
            res.addAll(v);

        });
        return res.stream().mapToInt(Integer::valueOf).toArray();

    }
}
