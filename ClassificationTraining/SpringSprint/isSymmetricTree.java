package ClassificationTraining.SpringSprint;

/**
 * @Classname isSymmetricTree
 * @Description TODO
 * @Date 2021/2/11 16:31
 * @Created by Administrator
 */
public class isSymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);

    }
    public static boolean isMirror(TreeNode t1,TreeNode t2){
        if(t1==null&&t2==null){
            return true;
        }
        if(t1==null||t2==null){
            return false;
        }
        return (t1.val==t2.val)&&
                isMirror(t1.left,t2.right)&&
                isMirror(t1.right,t2.left);

    }
}
