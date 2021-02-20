package AutumnRecruitment.chap3_3;

import AutumnRecruitment.StdIn;

/**
 * @Classname TestRB
 * @Description TODO
 * @Date 2019/12/10 16:12
 * @Created by 14241
 */
public class TestRB {

    public static void main(String[] args) {
        RedBlackBST<String, Integer> bst = new RedBlackBST<>();
        for (int i = 0; i<5; i++) {
            String key = StdIn.readString();
            bst.put(key, i);
        }
        System.out.println("RB Tree: ");
        for (String s : bst.keys()) {
            System.out.println(s + " " + bst.get(s));
        }

        System.out.println("min(): " + bst.min());
        System.out.println("max(): " + bst.max());
        System.out.println("floor(\"F\"): " + bst.floor("F"));
        System.out.println("ceiling(\"C\"): " + bst.ceiling("C"));
        System.out.println("select(1): " + bst.select(1));
        System.out.println("rank(\"R\"): " + bst.rank("R"));
    }
}
