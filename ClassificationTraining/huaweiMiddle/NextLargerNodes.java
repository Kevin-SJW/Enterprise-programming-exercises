package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname NextLargerNodes
 * @Description TODO
 * @Date 2021/1/10 11:52
 * @Created by Administrator
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 * 每个节点都可能有下一个更大值（next larger value）：
 * 对于 node_i，如果其 next_larger(node_i) 是 node_j.val，
 * 那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。
 * 如果不存在这样的 j，那么下一个更大值为 0 。
 *
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 *
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示
 * 其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 *
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 */
public class NextLargerNodes {
    //暴力法
    public static int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        //链表元素存储到集合中
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if(list.get(j)>list.get(i)){
                    res[i]=list.get(j);
                    break;
                }
            }
        }
        return res;
    }
}
