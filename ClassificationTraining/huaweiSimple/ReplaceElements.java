package ClassificationTraining.huaweiSimple;

import java.util.Arrays;

/**
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 * 完成所有替换操作后，请你返回这个数组。
 * 输入：arr = [17,18,5,4,6,1]
 * 输出：[18,6,6,6,1,-1]
 */
public class ReplaceElements {
    public static void main(String[] args) {
        int[] arr = {17, 18, 5, 4, 6, 1};
        Arrays.stream(replaceElements(arr)).forEach(t -> System.out.print(t + " "));

    }

    public static int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            res[i] = max;
            max = arr[i] > max ? arr[i] : max;
        }
        return res;
    }

    public static int[] replaceElements2(int[] arr) {
        int max = -1;
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            res[i] = max;
            max = arr[i] > max ? arr[i] : max;

        }
        return res;
    }
}
