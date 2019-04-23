import java.util.Scanner;

/**
 * @Classname Permutation
 * @Description TODO
 * @Date 2019/4/23 9:47
 * @Created by 14241
 */
public class Permutation {
    public static void main(String args[]) {
        permutation(new char[] { 'a', 'b', 'c', 'd' }, 0);
    }

    public static void permutation(char[] ss, int i) {
        if (ss == null || i < 0 || i > ss.length) {
            return;
        }

        if (i == ss.length - 1) {
            System.out.println(new String(ss));
        } else {
            for (int j = i; j < ss.length; j++) {
                /*交换前缀,使之产生下一个前缀*/
                swap(ss, i, j);
                permutation(ss, i + 1);
                /*将前缀换回来,继续做上一个的前缀排列*/
                swap(ss, i, j);
            }
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
