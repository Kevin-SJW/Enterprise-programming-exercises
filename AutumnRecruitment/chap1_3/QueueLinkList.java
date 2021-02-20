package AutumnRecruitment.chap1_3;

/**
 * @Classname QueueLinkList
 * @Description TODO
 * @Date 2019/9/29 12:52
 * @Created by 14241
 */

public class QueueLinkList<Item> {
    /**
     * 指向最早添加的结点的链接
     */
    private Node first;
    /**
     * 指向最近添加的结点的链接
     */
    private Node last;
    /**
     * 队列中的元素数量
     */
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    /**
     * 判空
     *
     * @return
     */
    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        //向表尾添加元素
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
            N++;
        }
//        public Item dequeue(Item item) {
//            //从表头删除元素
//            item = first.item;
//            first = first.next;
//            if (isEmpty()) {
//                last = null;
//                N--;
//                return item;
//            }


        }
    }



