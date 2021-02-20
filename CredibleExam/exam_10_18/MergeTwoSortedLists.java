package CredibleExam.exam_10_18;



/**
 * @Classname MergeTwoSortedLists
 * @Description TODO
 * @Date 2020/7/5 21:36
 * @Created by Administrator
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(int data){
        this.val=data;
    }
}

public class MergeTwoSortedLists {
    public static void main(String[] args) {

    }
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val > l2.val) {
            l2.next = merge(l1, l2.next);
            return l2;
        } else {
            l1.next = merge(l1.next, l2);
            return l1;
        }

    }
}
