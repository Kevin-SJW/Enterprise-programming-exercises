package AutumnRecruitment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname DoubleMatch
 * @Description TODO
 * @Date 2019/9/20 21:13
 * @Created by 14241
 */

class Node implements Comparable {
    int val;
    int num;

    public Node(int num, int val) {
        this.num = num;
        this.val = val;
    }

    public void decrease() {
        this.num--;
    }

    public boolean isEmpty() {
        return this.num == 0;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Node) {
            if (val == ((Node) o).val) {
                return 0;
            } else if (val > ((Node) o).val) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }
}

public class DoubleMatch {
    public static void main(String[] args) {
        List<Node> list = new ArrayList<Node>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            int val = scanner.nextInt();
            list.add(new Node(num, val));
        }
        Collections.sort(list);
        int result = 0;
        int i = 0;
        int j = list.size() - 1;
        while (i <= j) {
            int a = list.get(i).val;
            int b = list.get(j).val;
            list.get(i).decrease();
            list.get(j).decrease();
            if (list.get(i).isEmpty()) {
                i++;
            }
            if (list.get(j).isEmpty()) {
                j--;
            }
            if (result < a + b) {
                result = a + b;
            }

        }
        System.out.println(result);
    }
}
