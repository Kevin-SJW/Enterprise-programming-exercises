package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname AllPossibleFBT
 * @Description TODO
 * @Date 2020/9/6 10:55
 * @Created by Administrator
 */
public class AllPossibleFBT {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> ret = new ArrayList<>();
        if (N % 2 == 0) {
            return ret;
        }
        if (N == 1) {
            ret.add(new TreeNode(0));
        }
        for (int left = 1; left <= N - 2; left++) {
            List<TreeNode> leftRoot = allPossibleFBT(left);
            List<TreeNode> rightRoot = allPossibleFBT(N - left - 1);
            for (TreeNode l : leftRoot) {
                for (TreeNode r : rightRoot) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ret.add(root);
                }
            }
        }
        return ret;
    }
}
