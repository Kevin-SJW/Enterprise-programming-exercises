package ClassificationTraining.huaweiMiddle;

/**
 * @Classname SwapPairs
 * @Description TODO
 * @Date 2020/9/5 0:06
 * @Created by Administrator
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode Next = head.next;
        head.next = swapPairs(head.next.next);
        Next.next = head;
        return Next;
    }

    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode Next = head.next;
        head.next = swapPairs2(head.next.next);
        Next.next = head;
        return Next;
    }
}
