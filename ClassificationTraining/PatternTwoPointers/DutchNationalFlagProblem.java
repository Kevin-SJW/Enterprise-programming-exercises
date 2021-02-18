package ClassificationTraining.PatternTwoPointers;

/**
 * @Classname DutchNationalFlagProblem
 * @Description TODO
 * @Date 2020/7/22 23:25
 * @Created by Administrator
 * medium
 */
public class DutchNationalFlagProblem {
    public static void main(String[] args) {

    }

    public static void dutchNationalFlagProblem(int[] arr) {
        int r = 0;
        int w = 0;
        int b = arr.length - 1;
        while (w <= b) {
            int x = arr[w];
            if (x == 1) {// 若为前排的数字，则调换到前排
                arr[w] = arr[r];
                arr[r] = x;// 交换“0” “1”
                w++;
                r++;// 指向前排和中排的游标增1
            } else if (x == 2) {// 若为中间的数字，则不处理
                w++;
            } else {// 若为后排的数字，则调换到后排
                arr[w] = arr[b];
                arr[b] = x;
                b--;// 指向后排的游标减一
            }

        }
    }
}
