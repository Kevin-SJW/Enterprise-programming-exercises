package ClassificationTraining.huaweiMiddle;

import java.util.*;

/**
 * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。
 * 这些片段可能有所重叠，也可能长度不一。
 * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。
 * 我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。
 * 返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 */
public class VideoStitching {
    public static void main(String[] args) {
        int[][] clips = {{0, 4}, {2, 8}};
        int T = 5;
        int[][] clips2 = {{0, 1}, {1, 2}};
        int T2 = 5;
        System.out.println(videoStitching(clips,T));

    }

    public static int videoStitching(int[][] clips, int T) {
        //上一个的最大值
        int e ;
        //记录当前最小值
        int s = 0;
        int count = 0;
        for (int i = 0; i <= T; i++) {
            e = 0;
            for (int j = 0; j < clips.length; j++) {
                if (clips[j][0] <= s) {
                    e = Math.max(clips[j][1], e);
                }
            }
            count++;
            if (e>=T) {
                return count;
            }
            s = e;
        }
        return -1;
    }

    public static List<int[]> videoStitching2(int[][] clips, int T) {

        Arrays.sort(clips, Comparator.comparingInt(o -> o[0]));
        Deque<int[]> stack = new LinkedList<>();
        for (int[] i : clips) {
            int[] j = stack.peek();
            if (stack.isEmpty() || j[1] < i[0]) {
                stack.push(i);
            } else {
                j[1] = Math.max(i[1], j[1]);
            }
        }
        List<int[]> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
}
