package coding;

/**
 * @Classname LinkListDemo
 * @Description TODO
 * @Date 2019/9/22 17:44
 * @Created by 14241
 */
class Node2 {
    /**
     * 链表的节点数据
     */
    int data;

    /**
     * 链表的下一个节点的指针
     */
    Node2 next = null;

    public Node2(int data) {
        this.data = data;
    }
}

public class LinkListDemo {
    public static void main(String[] args) {
        LinkListDemo node=new LinkListDemo();
        //链表的头指针
        Node2 head=null;

        //新增节点,第一次新增时需要返回头指针，用于定位链表

        head=node.insertNode(2,head);
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
        node.insertNodeByIndex(1,node.insertNode(6,head));
        node.printList(head);


    }

    /**
     * 增加一个节点
     *
     * @param data
     * @param head
     * @return
     */
    public Node2 insertNode(int data, Node2 head) {

        Node2 node = new Node2(data);
        if (head == null) {
            head = node;
            return head;
        }
        Node2 curNode = head;
        //循环找到当前链表的尾节点
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        //尾节点的指针指向新增加的节点
        curNode.next = node;
        return head;
    }

    /**
     * 插入一个新的节点
     *
     * @param index
     * @param node
     */
    public void insertNodeByIndex(int index, Node2 node) {
        if (index < 1 || index > length(node)) {
            System.out.println("wrong inset position！");
        }
        Node2 temp = node;
        int length = 1;

        //记录光标位置
        while (temp != null) {
            if (index == length) {
                temp.next = node.next;
                node.next = temp;
            } else {
                temp = temp.next;
            }
            length++;

        }
    }

    /**
     * 获取链表长度
     *
     * @param head
     * @return
     */
    public int length(Node2 head) {
        Node2 curNode = head;
        int length = 0;
        while (curNode != null) {
            curNode = curNode.next;
            length++;
        }
        return length;
    }

    /**
     * 删除节点
     *
     * @param index
     * @param head
     */
    public Node2 deleteNode(int index, Node2 head) {
        //删除的节点的索引小于1或者大于链表的长度，直接返回false
        if (index < 1 || index > length(head)) {
            return null;
        }
        //删除头结点
        if (index == 1) {
            head = head.next;
            return head;
        }
        //删除头结点后，从头结点的下一个节点开始遍历
        Node2 curNode = head.next;
        //记录当前循环的节点的上一个节点用于删除当前节点
        Node2 preNode = head;
        //当前节点不为空
        while(curNode!=null){
            if(index==2){
                preNode.next=curNode.next;
                break;
            }else{
                preNode=curNode;
                curNode=curNode.next;
            }
        }
        return head;

    }

    /**
     * 打印链表
     * @param head
     * @return
     */
    public void printList(Node2 head){
        Node2 curNode= head;
        //循环遍历到尾节点
        while(curNode!=null){

            System.out.print(curNode.data+" ");
            curNode=curNode.next;
        }
        System.out.println();

    }

}
