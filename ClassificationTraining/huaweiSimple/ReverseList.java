package ClassificationTraining.huaweiSimple;

/**
 * @Classname ReverseList
 * @Description TODO
 * @Date 2020/9/13 12:48
 * @Created by Administrator
 * 反转链表
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int data) {
        this.val = data;
    }
}

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
    //递归反转链表
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode last = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    //反转前N个节点
    public ListNode reverseN(ListNode head, int n) {
        ListNode successor = null;
        if (n == 1) {
            successor = head.next;//记录第n+1个节点，后面要用
            return head;
        }
        ListNode last = reverseN(head.next, n - 1); //反转前N-1个节点
        head.next.next = head;
        head.next = successor; // 让反转之后的head节点和后面的节点连起来
        return last;
    }
    //反转链表的一部分
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n); //base case为reverseN
        }
        //前进到反转的起点触发base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}
