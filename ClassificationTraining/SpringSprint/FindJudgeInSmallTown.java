package ClassificationTraining.SpringSprint;

/**
 * @Classname FindJudgeInSmallTown
 * @Description TODO
 * @Date 2021/2/11 11:25
 * @Created by Administrator
 * 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 * 如果小镇的法官真的存在，那么：小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。只有一个人同时满足属性 1 和属性 2 。
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
 * <p>
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
 * <p>
 * 输入：N = 2, trust = [[1,2]]
 * 输出：2
 * 法官不相信任何人，说明法官不存在出度
 * 所有人都信任法官，说明法官的入度为N-1
 * 那么法官的出度加入度为N-1
 */
public class FindJudgeInSmallTown {
    public static void main(String[] args) {
        int N = 2;
        int[][] trust = {{1, 2}};
        System.out.println(findJudge(N, trust));
    }

    public static int findJudge(int N, int[][] trust) {
        if (N == 1) {
            return 1;
        }
        int[] cnt = new int[N + 1];
        for (int[] index : trust) {
            cnt[index[0]]--;//出度--
            cnt[index[1]]++;//入度++
        }
        for (int i = 0; i <= N; i++) {
            if (cnt[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
