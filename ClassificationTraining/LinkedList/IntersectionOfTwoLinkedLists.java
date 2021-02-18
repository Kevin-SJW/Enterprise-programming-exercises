package ClassificationTraining.LinkedList;

import java.util.HashMap;

/**
 * @Classname IntersectionOfTwoLinkedLists
 * @Description TODO
 * @Date 2020/3/15 16:05
 * @Created by 14241
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int data) {
        this.val = data;
    }
}

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode headB = new ListNode(1);
        ListNode cur = getIntersectionNode(headA, headB);
        System.out.println(cur);

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode curNodeA = headA;
        ListNode curNodeB = headB;

        while (curNodeA != null) {
            map.put(curNodeA, curNodeA.val);
            curNodeA = curNodeA.next;
        }
        while (curNodeB != null) {
            if (map.containsKey(curNodeB)) {
                return curNodeB;
            } else {
                map.put(curNodeB, curNodeB.val);
                curNodeB = curNodeB.next;
            }
        }
        return null;
    }
}
