package ClassificationTraining.huaweiMiddle;

/**
 * @Classname OddEvenList
 * @Description TODO
 * @Date 2020/9/20 16:46
 * @Created by Administrator
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 */
public class OddEvenList {

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;

        }
        odd.next = evenHead;
        return head;
    }

    public static ListNode oddEvenList2(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode odd=head,even=head.next,evenHead=even;
        while(even!=null&&even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;

    }
}
