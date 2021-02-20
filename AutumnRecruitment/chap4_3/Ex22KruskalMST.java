package AutumnRecruitment.chap4_3;

import AutumnRecruitment.chap3_5.Queue;
import AutumnRecruitment.chap4_1.CC;
import AutumnRecruitment.chap4_1.Graph;

/**
 * @Classname Ex22KruskalMST
 * @Description TODO
 * @Date 2020/1/3 17:08
 * @Created by 14241
 */
public class Ex22KruskalMST {
    private Queue<Edge> mst;

    public Ex22KruskalMST(EdgeWeightedGraph G) {
        mst = new Queue<Edge>();
        MinPQ<Edge> pq = new MinPQ<Edge>();
        for (Edge e : G.edges()) {
            pq.insert(e);
        }
        UF uf = new UF(G.V());

        Graph graph = new Graph(G.V());
        for (Edge edge : G.edges()) {
            int v = edge.either(), w = edge.other(v);
            graph.addEdge(v, w);
        }
        CC cc = new CC(graph);

        while (!pq.isEmpty() && mst.size() < G.V() - cc.count()) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) {
                continue;
            }
            uf.union(v, w);
            mst.enqueue(e);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }
}
