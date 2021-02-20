package coding;/*老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩.



输入描述:
输入包括多组测试数据。
每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
学生ID编号从1编到N。
第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。

输出描述:
对于每一次询问操作，在一行里面输出最高成绩.*/
import java.util.*;
public class GetHighestScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] firstStr = line.split("\\s");
            int N = Integer.parseInt(firstStr[0]);
            int M = Integer.parseInt(firstStr[1]);

            // 将学生成绩保存下来
            line = sc.nextLine();
            String[] gdStrings = line.split("\\s");

            int[] grades = new int[N];
            for (int i = 0; i < N; i++) {
                grades[i] = Integer.parseInt(gdStrings[i]);
            }

            // 处理QU问题
            for (int k = 0; k < M; k++) {
                String ss = sc.nextLine();
                String[] strings = ss.split("\\s");
                String flag = strings[0];
                int from = Integer.parseInt(strings[1]);
                int to = Integer.parseInt(strings[2]);

                if (flag.equals("Q")) {
                    // 此处有坑-------from有可能小于to
                    int maxValue = max(from - 1, to - 1, grades);// 从成绩中从from-1到to-1的最大值
                    System.out.println(maxValue);
                } else if (flag.equals("U")) {
                    // 出现U时，更新数组的成绩
                    grades[from - 1] = to;
                }
            }
        }
    }

    /**
     * 从成绩数组中从start到end的最大值
     *
     * @param start
     * @param end
     * @param students
     * @return
     */
    public static int max(int start, int end, int[] scores) {
        if (start > end)
            return max(end, start, scores);
        else {
            int max = scores[start];
            for (int i = start + 1; i <= end; i++) {
                if (scores[i] > max)
                    max = scores[i];
            }
            return max;
        }

    }

}

