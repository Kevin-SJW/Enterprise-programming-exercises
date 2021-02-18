package ClassificationTraining.LinkedList;


import java.util.Stack;

/**
 * @Classname PalindromeLinkedList
 * @Description TODO
 * @Date 2020/8/9 14:33
 * @Created by Administrator
 * 利用栈先进后去的特点，先将head的每个节点入栈，
 * 然后循环判断head的节点值和出栈的值是否相等，只要不相等即可返回false。
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        System.out.println(isPalindrome(node1));

    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        Stack<Integer> stack = new Stack<>();
        while (newHead.next != null) {
            stack.push(newHead.next.val);
            newHead.next = newHead.next.next;
        }
        while (head != null && !stack.isEmpty()) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode cur = new ListNode(-1);
        cur.next = head;
        Stack<Integer> stack = new Stack<>();
        while (cur.next != null) {
            stack.push(cur.next.val);
            cur.next = cur.next.next;
        }
        while (head != null && !stack.isEmpty()) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;


    }
}


