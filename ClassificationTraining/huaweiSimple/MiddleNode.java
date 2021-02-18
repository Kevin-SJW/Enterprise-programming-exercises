package ClassificationTraining.huaweiSimple;

/**
 * @Classname MiddleNode
 * @Description TODO
 * @Date 2020/10/4 15:47
 * @Created by Administrator
 */
public class MiddleNode {

    public static ListNode middleNode(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;

    }
}
