package CredibleExam.exam_4_24;

import java.util.Arrays;

/**
 * @Classname SortServers
 * @Description TODO
 * @Date 2020/7/31 0:30
 * @Created by Administrator
 */
public class SortServers {
    public static void main(String[] args) {
        int[] labels = {1, 1, 4, 2, 1, 3};
        System.out.println(sortServers(labels));

    }

    public static int sortServers(int[] labels) {
        int[] ans = Arrays.copyOf(labels, labels.length);
        Arrays.sort(ans);
        int count = 0;
        for (int i = 0; i < labels.length; i++) {
            if (ans[i] != labels[i]) {
                count++;
            }
        }
        return count;
    }
}
