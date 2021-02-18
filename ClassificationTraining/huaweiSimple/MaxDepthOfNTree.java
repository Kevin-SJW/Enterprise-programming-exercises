package ClassificationTraining.huaweiSimple;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname MaxDepthOfNTree
 * @Description TODO
 * @Date 2020/10/1 10:37
 * @Created by Administrator
 */
//N叉树的最大深度
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


public class MaxDepthOfNTree {
    public int maxDepth(Node root) {
        int count;
        if (root == null) {
            return 0;
        } else if (root.children.isEmpty()) {
            return 1;
        } else {
            List<Integer> heights = new LinkedList<>();
            for (Node num : root.children) {
                heights.add(maxDepth(num));
            }
            count = Collections.max(heights) + 1;

        }
        return count;

    }

}
