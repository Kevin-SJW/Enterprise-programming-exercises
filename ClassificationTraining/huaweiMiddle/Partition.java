package ClassificationTraining.huaweiMiddle;

/**
 * @Classname Partition
 * @Description TODO
 * @Date 2020/10/17 11:56
 * @Created by Administrator
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode start = head;
        while (start != null) {
            int value = start.val;
            if (x > value) {
                p1.next = start;
                p1 = p1.next;
            } else {
                p2.next = start;
                p2 = p2.next;
            }
            start = start.next;
        }
        p2.next = null;
        p1.next = l2.next;
        return l1.next;

    }
}
