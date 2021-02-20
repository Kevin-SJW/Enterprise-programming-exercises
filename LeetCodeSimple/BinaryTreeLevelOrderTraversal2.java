package LeetCodeSimple;

import java.util.*;

/**
 * @Classname BinaryTreeLevelOrderTraversal2
 * @Description TODO
 * @Date 2020/6/27 15:23
 * @Created by Administrator
 */
public class BinaryTreeLevelOrderTraversal2 {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();

        if(root==null){
            return res;
        }
        TreeNode curNode;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> curList=new ArrayList<>();
            for(int i=0;i<size;i++){
                curNode=queue.poll();
                curList.add(curNode.val);
                if(curNode.left!=null){
                    queue.offer(curNode.left);
                }
                if(curNode.right!=null){
                    queue.offer(curNode.right);
                }
            }
            res.add(curList);
        }
        Collections.reverse(res);
        return res;
    }
}
