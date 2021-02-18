package ClassificationTraining.huaweiHard;


import java.util.PriorityQueue;

/**
 * @Classname MergeKSortedLists
 * @Description TODO
 * @Date 2020/8/30 18:05
 * @Created by Administrator
 */
public class MergeKSortedLists {
    public ListNode mergeKSortedLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, (o1, o2) -> {
            if (o1.val == o2.val) {
                return 0;
            }
            return o1.val < o2.val ? -1 : 1;
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
        return dummy.next;

    }

    public ListNode mergeKSortedLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, (o1, o2) -> {
            if (o1 == o2) {
                return 0;
            }
            return (o1.val < o2.val) ? -1 : 1;
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            cur.next = node;
            cur = cur.next;
            while (node.next != null) {
                minHeap.offer(node.next);
            }
        }
        return dummy.next;


    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int data) {
        this.val = data;
    }
}
