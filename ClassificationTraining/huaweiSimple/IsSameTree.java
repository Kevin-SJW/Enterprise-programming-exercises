package ClassificationTraining.huaweiSimple;

/**
 * @Classname IsSameTree
 * @Description TODO
 * @Date 2020/10/1 12:30
 * @Created by Administrator
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
