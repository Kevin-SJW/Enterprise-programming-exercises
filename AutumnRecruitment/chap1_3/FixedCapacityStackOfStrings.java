package AutumnRecruitment.chap1_3;

import java.util.Scanner;

/**
 * @Classname FixedCapacityStackOfStrings
 * @Description TODO
 * @Date 2019/9/29 13:40
 * @Created by 14241
 */
public class FixedCapacityStackOfStrings {
    private String[] a; // stack entries
    private int N; // size

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

    /**
     * Exercise 1.3.1
     * @return
     */
    public boolean isFull() {
        return N == a.length;
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings s;
        s = new FixedCapacityStackOfStrings(101);
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            String item = sc.nextLine();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                System.out.println(s.pop() + " ");
            }
        }
        System.out.println("(" + s.size() + " left on stack)");
    }
}
