package LeetCodeSimple;

/**
 * @Classname PathSum
 * @Description TODO
 * @Date 2020/6/27 16:29
 * @Created by Administrator
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        else if(root.left==null&&root.right==null){
            return root.val==sum;
        }else{
            sum=sum-root.val;
            return hasPathSum(root.left,sum)||hasPathSum(root.right,sum);
        }

    }
}
