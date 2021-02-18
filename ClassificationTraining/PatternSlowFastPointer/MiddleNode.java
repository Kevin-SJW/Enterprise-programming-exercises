package ClassificationTraining.PatternSlowFastPointer;

/**
 * @Classname MiddleNode
 * @Description TODO
 * @Date 2020/7/24 23:41
 * @Created by Administrator
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
