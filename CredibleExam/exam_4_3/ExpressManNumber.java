package CredibleExam.exam_4_3;

/**
 * @Classname ExpressManNumber
 * @Description TODO
 * @Date 2020/7/26 17:41
 * @Created by Administrator
 * 判断快递员数目
 */
public class ExpressManNumber {
    public static void main(String[] args) {
//        int[] arr = {1,0,1};
        int[] arr = {1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0};
        System.out.println(expressManNumber(arr));

    }

    public static int expressManNumber(int[] arr) {
        int count = 0;
        if (arr.length == 0) {
            return 0;
        }
        if (arr.length <= 3) {
            count = 1;
            return count;
        }
        for (int i = 1; i < arr.length - 3; i += 3) {
            if (arr[i - 1] == 1 || arr[i + 1] == 1) {
                count++;

            }
        }
        return count;
    }
}
