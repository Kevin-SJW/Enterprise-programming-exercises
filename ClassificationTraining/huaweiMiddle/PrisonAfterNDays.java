package ClassificationTraining.huaweiMiddle;


import java.util.Arrays;

/**
 * 8 间牢房排成一排，每间牢房不是有人住就是空着。
 * 每天，无论牢房是被占用或空置，都会根据以下规则进行更改：
 * 如果一间牢房的两个相邻的房间都被占用或都是空的，那么该牢房就会被占用。
 * 否则，它就会被空置。
 * （请注意，由于监狱中的牢房排成一行，所以行中的第一个和最后一个房间无法有两个相邻的房间。）
 * 我们用以下方式描述监狱的当前状态：如果第 i 间牢房被占用，则 cell[i]==1，否则 cell[i]==0。
 * 根据监狱的初始状态，在 N 天后返回监狱的状况（和上述 N 种变化）。
 * 输入：cells = [0,1,0,1,1,0,0,1], N = 7
 * 输出：[0,0,1,1,0,0,0,0]
 * 关键就是找到状态的循环周期，写个测试程序可以看出来14天为一个周期(数组首尾皆不考虑0/1的情况，因为计算时默认0)；
 * 计算时遍历数组，从1开始到倒数第二位结束，如果当前元素的上一个元素和下一个元素相等就计当前元素为1，反之为0
 */
public class PrisonAfterNDays {
    public static void main(String[] args) {
        int[] cells = {0, 1, 0, 1, 1, 0, 0, 1};
        int N = 7;
        Arrays.stream(prisonAfterNDays(cells, N)).forEach(t -> System.out.print(t + " "));
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {
        N = (N - 1) % 14+1;
        for (int i = 0; i < N; i++) {
            cells = cal(cells);
        }
        return cells;
    }

    public static int[] cal(int[] cells) {
        int[] array=new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            if (cells[i - 1] == cells[i + 1]) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        return array;
    }
}
