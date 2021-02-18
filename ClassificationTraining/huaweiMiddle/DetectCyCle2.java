package ClassificationTraining.huaweiMiddle;

/**
 * @Classname DetectCyCle2
 * @Description TODO
 * @Date 2020/8/30 17:15
 * @Created by Administrator
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int data){
        this.val=data;
    }
}

public class DetectCyCle2 {
    public ListNode detectCycle(ListNode head) {
        if( head == null || head.next == null )
            return null;
        ListNode fast = head;
        ListNode slow = head;

        while( fast != null && fast.next != null  ){
            slow = slow.next;
            fast = fast.next.next;
            if( fast == slow ){
                ListNode find = head;
                while( find != slow ){
                    find = find.next;
                    slow = slow.next;
                }
                return find;
            }
        }

        return null;
    }
}
