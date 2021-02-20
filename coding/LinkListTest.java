package coding; /**
 * @Classname LinkListTest
 * @Description TODO
 * @Date 2019/9/22 16:37
 * @Created by 14241
 */

/**
 * 链表的结构
 * @author haoge
 */
class Node {
    /**
     * 链表节点的数据
     */
    int data;
    /**
     * 链表指向的下一个节点的指针
     */
    Node next = null;

    public Node(int data) {
        this.data = data;
    }
}

/**
 * 链表的插入、删除、计算长度和打印链表
 * @author haoge
 *
 */
public class LinkListTest {

    public static void main(String[] args) {
        LinkListTest node = new LinkListTest();
        //链表的头指针
        Node head = null;

        //新增节点,第一次新增时需要返回头指针，用于定位链表
        head = node.insertNode(2, head);
        node.insertNode(5, head);
        node.insertNode(4, head);
        node.insertNode(3, head);
        node.insertNode(1, head);



        //链表的长度
        System.out.println("链表的长度为：" + node.length(head));

        //输出节点
        System.out.println("输出节点:");
        node.printList(head);

        //删除节点
        if ((head = node.deleteNode(2, head)) != null) {
            System.out.println("删除索引为2的节点后：");
            node.printList(head);
        } else {
            System.out.println("删除失败！");
            node.printList(head);
        }

        //删除头结点测试
        if ((head = node.deleteNode(1, head)) != null) {
            System.out.println("删除头节点后：");
            node.printList(head);
        } else {
            System.out.println("删除失败！");
            node.printList(head);
        }
        //插入一个新节点
        node.insertNodeByIndex(3,head);
//        node.printList(head);
    }

    /**
     * 新增节点
     * @param data
     */
    public Node insertNode(int data, Node head) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return head;
        }
        Node curNode = head;
        //循环找到当前链表的尾节点
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        //尾节点的指针指向新增加的节点
        curNode.next = node;
        return head;
    }

    /**
     * 插入一个节点
     * @param index
     * @param node
     */
    public void insertNodeByIndex(int index, Node node) {
        if (index < 1 || index > new LinkListTest().length(node)) {
            System.out.println("插入位置不合法");
            return;
        }
        Node temp = node;
        int length = 1;
        // 记录光标位置
        while (temp.next != null) {
            if (index == length) {
                // 找到要插入的位置,进行插入操作，
                node.next = temp.next;
                temp.next = node;
            } else {
                temp = temp.next;
            }
            length++;
        }

    }


    /**
     * 链表的长度
     * @return
     */
    public int length(Node head) {
        Node curNode = head;
        int length = 0;
        while (curNode != null) {
            curNode = curNode.next;
            length ++;
        }
        return length;
    }

    /**
     * 删除节点
     */
    public Node deleteNode(int index, Node head) {
        //删除的节点的索引小于1或者大于链表的长度，直接返回false
        if (index < 1 || index > length(head)) {
            return null;
        }
        //删除头结点
        if (index == 1) {
            head = head.next;
            return head;
        }
        //从头结点的下一个节点开始遍历
        Node curNode = head.next;
        //记录当前循环的节点的上一个节点用于删除当前节点
        Node preNode = head;
        int i = 2;
        while (curNode != null) {
            if (i == index) {
                //前一个节点的next指向当前节点的下一个节点，即删除当前节点
                preNode.next = curNode.next;
                break;
            } else {
                preNode = curNode;
                curNode = curNode.next;
            }
        }

        return head;
    }

    /**
     * 打印链表
     */
    public Node printList(Node head) {
        Node curNode = head;
        //循环遍历到尾节点
        while (curNode != null) {
            System.out.print(curNode.data + "  ");
            curNode = curNode.next;
        }

        System.out.println();
        return head;
    }
}

