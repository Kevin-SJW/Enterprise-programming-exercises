import java.util.Arrays;

/**
 * @Classname QuickSort
 * @Description TODO
 * @Date 2019/4/16 16:20
 * @Created by 14241
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 8, 3, 6, 9, 4 };
        System.out.println("快速排序交换之前：");
        for(int num : arr){
            System.out.print(num + " ");
        }

        System.out.println("\n");
        System.out.println("快速排序交换之后：");
        quickSort(arr, 0, arr.length - 1);
        for(int num : arr) {
            System.out.print(num + " ");}
    }

//    }

    private static int Sort(int[] arr, int l, int r) {
        /*取出第一个元素*/
        int v = arr[l];
        /*j表示小于第一个元素和大于第一个元素的分界点*/
        int j = l;

        for (int i = j + 1; i <= r; i++) {
            /*将所有小于第一个元素的值的元素全部都放到它的左边
            * 如果当前元素小于v，则交换*/
            if (arr[i] < v) {
                swap(arr, i, j + 1);
                j++;
            }
        }
        /*将第一个元素和中间的元素进行交换*/
        swap(arr, l, j);

        return j;

    }

    private static void quickSort(int[] arr, int l, int r) {
        if(l>r){
            return;
        }

        int p = Sort(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);



    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
