package Arrays;

import java.util.Arrays;

/**
 * @Classname ThreeDWithNew
 * @Description TODO
 * @Date 2019/10/28 19:57
 * @Created by 14241
 */
public class ThreeDWithNew {
    public static void main(String[] args) {
        // 3-D array with fixed length:
        int[][][] a = new int[2][2][4];
        System.out.println(Arrays.deepToString(a));
    }
} /* Output:
[[[0, 0, 0, 0], [0, 0, 0, 0]], [[0, 0, 0, 0], [0, 0, 0, 0]]]
*///:~
