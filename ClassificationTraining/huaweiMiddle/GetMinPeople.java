package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;

/**
 *考生在在线平台考试，可以查每道题的结果，针对回答错误且未给出正确答案的结果，这时需要综合多个考生的答案，
 * 假设没有questionCount道题，题目编号从1到questionCount，现给出每个考生的答对题目的编号，格式如1,3
 * 表示答对1-3题，9 9 表示答对第9题，考生答对的题目是连续的，每个考试至少答对一道题，计算至少要答对几道题。
 */
public class GetMinPeople {
    public static void main(String[] args) {
        int questionCount = 10;
        int peopleCount = 6;
        int[][] correctRanges = {{1, 3}, {4, 6}, {1, 6}, {6, 10}, {5, 8}, {10, 10}};
        System.out.println(getMinPeople(questionCount, peopleCount, correctRanges));
    }
    private static int getMinPeople(int questionCount, int peopleCount, int[][] correctRanges) {
        Arrays.sort(correctRanges, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        int count = 0;
        int sequence = 0;
        int index = 0;
        int temp = 0;
        if (correctRanges[0][0] > 1) {
            return -1;
        }
        while (index < questionCount) {
            if (correctRanges[sequence][0] > index + 1) {
                return -1; }
            while (sequence < peopleCount && correctRanges[sequence][0] <= index + 1) {
                temp = Math.max(correctRanges[sequence][1], temp);
                sequence++;
            }
            if (temp > index) {
                index = temp;
                count++;
            }
            if (sequence > peopleCount - 1 && temp < questionCount) {
                return -1; }
        }
        return count;
    }
}
