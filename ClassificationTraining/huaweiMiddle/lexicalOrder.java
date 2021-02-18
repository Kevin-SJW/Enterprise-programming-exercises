package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Classname lexicalOrder
 * @Description TODO
 * @Date 2020/12/27 18:54
 * @Created by Administrator
 */
public class lexicalOrder {
    public static void main(String[] args) {
        int n=13;
        System.out.println(lexicalOrder(n));
    }

    public static List<Integer> lexicalOrder(int n) {
        PriorityQueue<String> heaq = new PriorityQueue<>(Comparator.naturalOrder());

        for (int i = 1; i <= n; i++)
            heaq.offer(String.valueOf(i));

        List<Integer> ans = new ArrayList<>();
        while (!heaq.isEmpty())
            ans.add(Integer.parseInt(heaq.poll()));
        return ans;

    }
}
