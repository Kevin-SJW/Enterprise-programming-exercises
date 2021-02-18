package ClassificationTraining.Greedy;

/**
 * @Classname CouplesHoldingHands
 * @Description TODO
 * @Date 2020/8/5 23:39
 * @Created by Administrator
 * N couples sit in 2N seats arranged in a row and want to hold hands.
 * We want to know the minimum number of swaps so that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up and switch seats.
 * <p>
 * The people and seats are represented by an integer from 0 to 2N-1,
 * the couples are numbered in order, the first couple being (0, 1),
 * the second couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).
 * <p>
 * The couples' initial seating is given by row[i] being the value of the person
 * who is initially sitting in the i-th seat.
 */
public class CouplesHoldingHands {
    public static void main(String[] args) {
        int[] row = {0, 2, 1, 3};
        System.out.println(minSwapsCouples(row));
    }

    public static int minSwapsCouples(int[] row) {
        int result = 0;
        for (int i = 0; i < row.length - 1; i += 2) {
            for (int j = i + 1; j < row.length; j++) {
                if (row[i] / 2 == row[j] / 2) {
                    if (j == i + 1) {
                        break;
                    } else {
                        int temp = row[j];
                        row[j] = row[i + 1];
                        row[i + 1] = temp;
                        result++;
                        break;
                    }
                }
            }
        }
        return result;

    }
}
