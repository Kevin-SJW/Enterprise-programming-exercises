package ClassificationTraining.huaweiSimple;

/**
 * @Classname GetKthFromEnd
 * @Description TODO
 * @Date 2020/9/20 15:38
 * @Created by Administrator
 */
public class GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;
        while (k-- > 0) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

}