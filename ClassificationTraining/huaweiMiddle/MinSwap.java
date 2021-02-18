package ClassificationTraining.huaweiMiddle;

/**
 * @Classname MinSwap
 * @Description TODO
 * @Date 2021/1/20 22:49
 * @Created by Administrator
 * 我们有两个长度相等且不为空的整型数组 A 和 B 。
 * 可以交换 A[i] 和 B[i] 的元素。注意这两个元素在各自的序列中应该处于相同的位置。
 * 在交换过一些元素之后，数组 A 和 B 都应该是严格递增的
 * （数组严格递增的条件仅为A[0] < A[1] < A[2] < ... < A[A.length - 1]）。
 * 给定数组 A 和 B ，请返回使得两个数组均保持严格递增状态的最小交换次数。假设给定的输入总是有效的。
 * 输入: A = [1,3,5,4], B = [1,2,3,7]
 * 输出: 1
 * 交换 A[3] 和 B[3] 后，两个数组如下:
 * A = [1, 3, 5, 7] ， B = [1, 2, 3, 4]
 * 两个数组均为严格递增的。
 */
public class MinSwap {
    public static void main(String[] args) {
        int[] A={1,3,5,4};
        int[] B={1,2,3,7};
        System.out.println(minSwap(A,B));
    }
    public static int minSwap(int[] A, int[] B) {
        int yes=1;
        int no =0;
        int temp=0;
        for (int i = 1; i < A.length; i++) {
            if(A[i]<=A[i-1] || B[i]<=B[i-1]){
                temp=no+1;
                no =yes;
            }else if(A[i]<=B[i-1]||B[i]<=A[i-1]){
                temp=yes+1;
            }else{
                temp=Math.min(yes+1,no+1);
                no=Math.min(no,yes);
            }
            yes =temp;
        }
        return Math.min(yes,no);
    }
}
