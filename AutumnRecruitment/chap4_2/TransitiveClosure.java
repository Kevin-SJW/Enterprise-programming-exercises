package AutumnRecruitment.chap4_2;

/**
 * @Classname TransitiveClosure
 * @Description TODO
 * @Date 2020/1/2 17:32
 * @Created by 14241
 */
public class TransitiveClosure {
    private DirectedDFS[] all;

    TransitiveClosure(Digraph G) {
        all = new DirectedDFS[G.V()];
        for (int v = 0; v < G.V(); v++) {
            all[v] = new DirectedDFS(G, v);
        }
    }

    boolean reachable(int v, int w) {
        return all[v].marked(w);
    }
}
