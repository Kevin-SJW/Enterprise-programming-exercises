package CredibleExam.exam_4_17;

/**
 * @Classname LegalDevNumber
 * @Description TODO
 * @Date 2020/7/30 0:24
 * @Created by Administrator
 * 设备号包含4,18则为不合法
 */
public class LegalDevNumber {
    public static void main(String[] args) {
        int start = 3, end = 20;
        System.out.println(legalDevNumber(start, end));

    }

    public static int legalDevNumber(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (String.valueOf(i).contains("4") || String.valueOf(i).contains("18")) {
                continue;
            }
            count++;

        }
        return count;

    }
}
