package ClassificationTraining.huaweiMiddle;

/**
 * @Classname ReverseKGroup
 * @Description TODO
 * @Date 2021/1/27 22:52
 * @Created by Administrator
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            //不足k个，不需要反转，base case
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        //反转前k个元素
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }
    //反转A-B
    public ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        //while终止条件修改
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        //返回反转后的头结点
        return pre;
    }
}
