package ClassificationTraining.huaweiMiddle;

import java.util.*;

/**
 * @Classname KillProcess
 * @Description TODO
 * @Date 2020/10/8 17:26
 * @Created by Administrator
 * 给 n 个进程，每个进程都有一个独一无二的 PID （进程编号）和它的 PPID （父进程编号）。
 * 每一个进程只有一个父进程，但是每个进程可能会有一个或者多个孩子进程。它们形成的关系就像一个树状结构。
 * 只有一个进程的 PPID 是 0 ，
 * 意味着这个进程没有父进程。所有的 PID 都会是唯一的正整数。
 * 我们用两个序列来表示这些进程，第一个序列包含所有进程的 PID ，第二个序列包含所有进程对应的 PPID。
 * 现在给定这两个序列和一个 PID 表示你要杀死的进程，函数返回一个 PID 序列，
 * 表示因为杀这个进程而导致的所有被杀掉的进程的编号。
 * 当一个进程被杀掉的时候，它所有的孩子进程和后代进程都要被杀掉。
 * 你可以以任意顺序排列返回的 PID 序列。
 */
public class KillProcess {
    public static void main(String[] args) {
        List<Integer> pid = Arrays.asList(1, 3, 10, 5);
        List<Integer> ppid = Arrays.asList(3, 0, 5, 3);
        int kill = 5;
        System.out.println(killProcess(pid, ppid, kill));

    }

    public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < ppid.size(); i++) {
            if (!map.containsKey(ppid.get(i))) {
                map.put(ppid.get(i), new ArrayList<>());
            }
            map.get(ppid.get(i)).add(pid.get(i));
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        queue.offer(kill);
        while (!queue.isEmpty()) {
            int id = queue.poll();
            ans.add(id);
            if (map.containsKey(id)) {
                queue.addAll(map.get(id));
            }
        }
        return ans;

    }
}
