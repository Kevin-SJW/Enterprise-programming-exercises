package ClassificationTraining.SpringSprint;

/**
 * @Classname LongestZigzag
 * @Description TODO
 * @Date 2021/2/13 13:47
 * @Created by Administrator
 */
public class LongestZigzag {
    int max = 0;

    public int longestZigZag(TreeNode root) {
        zigZag(root);
        return max > 0 ? max - 1 : 0;
    }

    //int[0]，表示n作为左边最长
    //int[1]，表示n作为右边最长
    private int[] zigZag(TreeNode n) {
        if (n == null) return new int[]{0, 0};
        //作为左边时，取右子树作为右边
        //作为右边时，去左子树作为左边
        int[] res = new int[]{zigZag(n.right)[1] + 1, zigZag(n.left)[0] + 1};
        max = Math.max(max, Math.max(res[0], res[1]));
        return res;
    }

}
