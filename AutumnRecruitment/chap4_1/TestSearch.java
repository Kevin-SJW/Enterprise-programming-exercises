package AutumnRecruitment.chap4_1;

import AutumnRecruitment.StdOut;
import AutumnRecruitment.chap3_5.In;

/**
 * @Classname TestSearch
 * @Description TODO
 * @Date 2019/12/16 22:03
 * @Created by 14241
 */
public class TestSearch {
    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        DepthFirstSearch search = new DepthFirstSearch(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v)) {
                StdOut.print(v + " ");
            }
        }
        StdOut.println();

        if (search.count() != G.V()) {
            StdOut.print("NOT ");
        }
        StdOut.println("connected");
    }
}
