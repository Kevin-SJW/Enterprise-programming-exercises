package LeetCodeSimple;

/**
 * @Classname RemoveDuplicatesFromSortedList
 * @Description TODO
 * @Date 2020/6/27 9:18
 * @Created by Administrator
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {

    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur=head;
        while(cur!=null&&cur.next!=null){
            if(cur.val==cur.next.val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        return head;
    }
}
