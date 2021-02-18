package ClassificationTraining.huaweiMiddle;

/**
 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：

 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 返回 A 的最大湍流子数组的长度。
 */
public class maxTurbulanceSize {
    public static void main(String[] args) {
        int[] arr={9,4,2,10,7,8,8,1,9};
        System.out.println(maxTurbulenceSize(arr));
    }
    public static int maxTurbulenceSize(int[] arr){
        if(arr.length==0){
            return 0;
        }
        int res=0;
        int left=0,right=0;
        int n=arr.length;
        while(right<n-1){
            if(left==right){
                if(arr[left]==arr[left+1]){
                    left++;
                }
                right++;
            }else{
                if(arr[right-1]<arr[right]&&arr[right]>arr[right+1]){
                    right++;
                }else if(arr[right-1]>arr[right]&&arr[right]<arr[right+1]){
                    right++;
                }else{
                    left=right;
                }
            }
            res=Math.max(res,right-left+1);
        }
        return res;

    }
}
