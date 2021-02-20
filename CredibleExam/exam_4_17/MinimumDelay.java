package CredibleExam.exam_4_17;

/**
 * @Classname MinimumDelay
 * @Description TODO
 * @Date 2020/7/30 0:48
 * @Created by Administrator
 */
public class MinimumDelay {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6};
        int len = 3;

        System.out.println(calculateLatency(arr, len));

    }

    public static int calculateBaseLatency(int[] arr, int len) {
        int baseId = arr[0];
        int res = 0;
        for (int i = 1; i < len; i++) {
            res += arr[i] - baseId;
        }
        return res;

    }

    public static int calculateLatency(int[] arr, int len) {
        int mainLatency = calculateBaseLatency(arr, len);
        for (int i = 1; i < len; i++) {
            int latency = mainLatency;
            int left = i;
            int right = len - i;
            int dist = arr[i] - arr[i - 1];
            latency += dist * (left - right);
            if (latency < mainLatency) {
                mainLatency = latency;
            }
        }
        return mainLatency;
    }
}
