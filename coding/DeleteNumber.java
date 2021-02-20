package coding; /**
 * @Classname DeleteNumber
 * @Description 有一个数组a[N]顺序存放0~N-1，第一次间隔1个数，第二次间隔2个数，一次类推到末尾时循环至开头继续进行，
 * * 求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:
 * ｛0，1，2，3，4，5，6，7｝，0->1(删除)->2->3->4(删除)->5->6->7->8(删除),如此循环直到最后一个数被删除。
 * @Date 2019/4/14 21:20
 * 测试用例：
 * 0 1 2 3 4 5 6 7 8 9
 * 9
 * @Created by 14241
 */

import java.util.*;

public class DeleteNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String[] array = str.split(" ");
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < array.length; i++) {
            list.add(array[i].trim());

        }
        int i = 0;
        int j = 1;
        while (list.size() > 1) {
            i = (i + j) % list.size();
            list.remove(i);
            j++;
        }
        System.out.println(list.get(0));
    }

}

