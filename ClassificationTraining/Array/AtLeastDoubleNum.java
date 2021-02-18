package ClassificationTraining.Array;

/**
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * 如果是，则返回最大元素的索引，否则返回-1。
 */
public class AtLeastDoubleNum {
    public static void main(String[] args) {
        int[] nums = {3, 6, 1, 0};
        System.out.println(dominantIndex2(nums));

    }

    public static int dominantIndex(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != maxIndex && nums[maxIndex] < 2 * nums[i]) {
                return -1;
            }
        }
        return maxIndex;
    }

    public static int dominantIndex2(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != maxIndex && nums[maxIndex] < 2 * nums[i]) {
                return -1;
            }
        }
        return maxIndex;

    }

}

//    int max = Arrays.stream(nums).max().getAsInt();
//
//    List<Integer> res=new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//        if (nums[i] == max) {
//        continue;
//        } else {
//        res.add(nums[i]);
//        }
//        }
//        int max2=0;
//        for(int num:res){
//        if(max2<num){
//        max2=num;
//        }
//        }
//        if (max >= 2 * max2) {
//        return Arrays.binarySearch(nums, max);
//        } else {
//        return -1;
//        }
