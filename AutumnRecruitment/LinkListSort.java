package AutumnRecruitment;

import java.util.Scanner;


/**
 * @Classname LinkListSort
 * @Description TODO
 * @Date 2019/9/4 19:33
 * @Created by 14241
 */


public class LinkListSort {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    public static ListNode partition(ListNode head,int m) {
        ListNode begin = new ListNode(-1);
        begin.next = head;
        ListNode help = begin;
        if (head.val <= m) {
            help = help.next;
        }
        ListNode next = head.next;
        while (next != null) {
            if (next.val <= m) {
                head.next = next.next;
                next.next = help.next;
                help.next = next;
                help = next;
                next = head.next;
            } else {
                head = next;
                next = head.next;
            }
        }
        return begin.next;
    }

    /******************************结束写代码******************************/

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }
        head= partition(head,m);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }
        System.out.println();
    }
}

