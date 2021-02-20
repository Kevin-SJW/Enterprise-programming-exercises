package AutumnRecruitment.chap1_3;

/**
 * @Classname StackLinkedList
 * @Description TODO
 * @Date 2019/9/29 12:40
 * @Created by 14241
 */
class Node {

    int value;

    Node next = null;
}

public class StackLinkedList<Item> {

    /**
     * 栈顶
     */
    private Node first;
    /**
     * 元素数量
     */
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        //向栈顶添加元素
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop() {
        //从栈顶删除元素
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }


}
