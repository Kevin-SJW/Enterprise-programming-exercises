package CredibleExam.exam_12_27;

/**
 * @Classname TestSweepingRobot
 * @Description TODO
 * @Date 2020/7/19 10:59
 * @Created by Administrator
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.val=data;
    }
}

public class TestSweepingRobot {
    public static void main(String[] args) {

    }
    public double captureProb(TreeNode root,int target){
        return helper(root,target,1.0);

    }
    public double helper(TreeNode node,int target,double prob){
        if(node==null){
            return 0;
        }
        if(node.val==target){
            return prob;
        }
        double leftProb=0.0,rightProb=0.0;
        if(node.left!=null){
            leftProb=node.right!=null?0.5:1;
        }
        if(node.right!=null){
            rightProb=node.left!=null?0.5:1;
        }
        return prob*helper(node.left,target,leftProb)+prob*helper(node.right,target,rightProb);
    }
}
