package LeetCodeSimple;

/**
 * @Classname SymmetricTree
 * @Description TODO
 * @Date 2020/6/27 15:05
 * @Created by Administrator
 */
public class SymmetricTree {
    public static void main(String[] args) {

    }
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
