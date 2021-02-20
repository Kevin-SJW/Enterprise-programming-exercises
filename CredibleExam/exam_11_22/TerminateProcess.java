package CredibleExam.exam_11_22;

import java.util.*;

/**
 * @Classname TerminateProcess
 * @Description TODO
 * @Date 2020/7/12 22:45
 * @Created by Administrator
 * 给 n 个进程，每个进程都有一个独一无二的 PID （进程编号）和它的 PPID （父进程编号）。
 * 每一个进程只有一个父进程，但是每个进程可能会有一个或者多个孩子进程。它们形成的关系就像一个树状结构。只有一个进程的 PPID 是 0 ，意味着这个进程没有父进程。所有的 PID 都会是唯一的正整数。
 * 我们用两个序列来表示这些进程，第一个序列包含所有进程的 PID ，第二个序列包含所有进程对应的 PPID。
 * 现在给定这两个序列和一个 PID 表示你要杀死的进程，函数返回一个 PID 序列，表示因为杀这个进程而导致的所有被杀掉的进程的编号。
 * 当一个进程被杀掉的时候，它所有的孩子进程和后代进程都要被杀掉。
 * 你可以以任意顺序排列返回的 PID 序列。
 * <p>
 * 示例 1:
 * 输入:
 * pid = [1, 3, 10, 5]
 * ppid = [3, 0, 5, 3]
 * kill = 5
 * 输出: [5,10]
 * <p>
 * 注意:
 * （1）被强制关闭的进程编号一定在 PID 序列中。
 * （2）PID 序列个数>= 1，PPID 的个数与 PID 相等。
 * （3）必须考虑大的数据量情况下的性能，时间复杂度为 O(n^2)的解法通过的用例会很少。
 * 首先题目中有时间复杂度的限制，排除了暴力循环求解的方法，其次想到了构造一个多叉树的结构，但这个实现起来难度比较大。仔细分析一下，把需求抽取出来无非就是找到一个节点的所有子节点，可以通过一个Map来存储节点和所有子节点的关系，然后递归寻找即可。数据结构为：
 * <p>
 * HashMap<Integer, List> progressMap 让ppid作为key；pid的list作为value；
 * 解题步骤：
 * <p>
 * （1）遍历输入的list，构造ppid与pid list的map
 * <p>
 * （2）遍历map的key，找到要杀死的节点
 * <p>
 * （3）再根据要杀死节点的所有子节点循环递归，直至找到所有的子
 */
public class TerminateProcess {
    public static void main(String[] args) {
        List<Integer> pid = Arrays.asList(1, 3, 10, 5);
        List<Integer> ppid = Arrays.asList(3, 0, 5, 3);
        int kill = 5;
        terminateProcess(pid, ppid, kill).stream().forEach(t -> System.out.print(t + " "));
//        System.out.println(terminateProcess(pid, ppid, kill).toString());

    }

    // 如果杀的节点没有子节点，则返回自己
    public static List<Integer> terminateProcess(List<Integer> pid, List<Integer> ppid,
                                                 int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            map.putIfAbsent(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        while (!queue.isEmpty()) {
            int id = queue.remove();
            ans.add(id);
            if (map.containsKey(id)) {
                queue.addAll(map.get(id));
            }
        }
        return ans;

    }


}

