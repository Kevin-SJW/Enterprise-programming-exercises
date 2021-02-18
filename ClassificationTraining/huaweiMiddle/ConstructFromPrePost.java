package ClassificationTraining.huaweiMiddle;

/**
 * @Classname ConstructFromPrePost
 * @Description TODO
 * @Date 2020/11/8 18:58
 * @Created by Administrator
 */
public class ConstructFromPrePost {

    int preIndex = 0, posIndex = 0;

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[preIndex++]);
        if (root.val != post[posIndex]) {
            root.left = constructFromPrePost(pre, post);
        }
        if (root.val != post[posIndex]) {
            root.right = constructFromPrePost(pre, post);
        }
        posIndex++;
        return root;
    }
}
