package ClassificationTraining.huaweiMiddle;

/**
 * @Classname MergeInBetween
 * @Description TODO
 * @Date 2020/12/2 23:45
 * @Created by Administrator
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 * <p>
 * 请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。
 * <p>
 * 下图中蓝色边和节点展示了操作后的结果：
 */
public class MergeInBetween {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur = list1;
        ListNode end = list1;
        ListNode l2 = list2;
        for (int i = 1; i < a; i++) {
            cur = cur.next;
        }
        for (int j = 1; j <=b; j++) {
            end = end.next;
        }
        cur.next = l2;
        while (l2.next != null) {
            l2 = l2.next;
        }
        l2.next = end.next;
        return list1;

    }
}
