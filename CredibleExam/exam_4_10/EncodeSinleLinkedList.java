package CredibleExam.exam_4_10;


import java.util.ArrayList;
import java.util.List;

/**
 * @Classname EncodeSinleLinkedList
 * @Description TODO
 * @Date 2020/7/26 20:08
 * @Created by Administrator
 * 链表交换
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int data) {
        this.val = data;
    }
}

public class EncodeSinleLinkedList {

    public static ListNode swap(ListNode head, int k) {
        ListNode root = head;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int leftIndex = k - 1, rightIndex = list.size() - k;
        int leftVal = list.get(leftIndex), rightVal = list.get(rightIndex);
        ListNode start = root;
        while (start != null) {
            //找到正数第k个元素
            if (leftIndex == 0) {
                start.val = rightVal;
            }
            //找到倒数第k个元素
            if (rightIndex == 0) {
                start.val = leftVal;
            }
            start = start.next;
            leftIndex--;
            rightIndex--;
        }
        return root;
    }
}
