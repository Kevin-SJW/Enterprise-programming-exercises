package AutumnRecruitment.chap3_1;

import AutumnRecruitment.StdIn;

/**
 * @Classname TestBinarySearchST
 * @Description TODO
 * @Date 2019/12/5 17:27
 * @Created by 14241
 */
public class TestBinarySearchST {

    public static void main(String[] args) {
        BinarySearchST<String, Integer> st = new BinarySearchST<>(1000000);
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys()) {
            System.out.println(s + " " + st.get(s));
        }
        System.out.println("min(): " + st.min());
        System.out.println("max(): " + st.max());
        System.out.println("floor(\"F\"): " + st.floor("F"));
        System.out.println("ceiling(\"C\"): " + st.ceiling("C"));
        System.out.println("select(0): " + st.select(0));
        System.out.println("rank(\"R\"): " + st.rank("R"));
        System.out.println("deleteMin():");
        st.deleteMin();
        for (String s : st.keys()) {
            System.out.println(s + " " + st.get(s));
        }
        System.out.println("deleteMax():");
        st.deleteMax();
        for (String s : st.keys()) {
            System.out.println(s + " " + st.get(s));
        }
    }
}
