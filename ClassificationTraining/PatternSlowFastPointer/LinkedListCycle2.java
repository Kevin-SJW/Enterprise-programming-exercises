package ClassificationTraining.PatternSlowFastPointer;


/**
 * @Classname LinkedListCycle2
 * @Description TODO
 * @Date 2020/7/24 23:52
 * @Created by Administrator
 */
public class LinkedListCycle2 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        ListNode node = detectCycle(node1);
        System.out.println(node.val);
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode find = fast;
                while (find != slow) {
                    find = fast.next;
                    slow = slow.next;
                }
                return find;
            }
        }
        return null;
    }
}
