package CredibleExam.exam_9_26;

import java.util.*;

/**
 * @Classname HighFive
 * @Description TODO
 * @Date 2020/7/5 18:53
 * @Created by Administrator
 * Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.
 * <p>
 * Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  The average score is calculated using integer division.
 * <p>
 * 给你一个不同学生的分数列表，请按 学生的 id 顺序 返回每个学生 最高的五科 成绩的 平均分。
 * 对于每条 items[i] 记录， items[i][0] 为学生的 id，items[i][1] 为学生的分数。平均分请采用整数除法计算。
 * 输入：
 * [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * 输出：[[1,87],[2,88]]
 */
public class HighFive2 {
    public static void main(String[] args) {
        int[][] items = {{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}};
//        Arrays.stream(highFive(items)).forEach(t-> Arrays.stream(t).forEach(s-> System.out.print(s+" ")));
        int[][] res = highFive2(items);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
        }
    }

    public static int[][] highFive(int[][] items) {
        Map<Integer, Queue<Integer>> map = new TreeMap<>();
        Comparator<Integer> comparator = ((o1, o2) -> o2 - o1);
        Queue<Integer> scores;
        for (int i = 0; i < items.length; i++) {
            if (map.containsKey(items[i][0])) {
                scores = map.get(items[i][0]);
                scores.add(items[i][1]);
            } else {
                scores = new PriorityQueue<>(comparator);
                scores.add(items[i][1]);
                map.put(items[i][0], scores);
            }
        }
        int[][] res = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Queue<Integer>> entry : map.entrySet()) {
            res[index][0] = entry.getKey();
            int sum = 0;
            Queue<Integer> queue = entry.getValue();
            for (int i = 0; i < 5; i++) {
                sum += queue.poll();
            }
            res[index++][1] = sum / 5;
        }
        return res;
    }

    public static int[][] highFive2(int[][] items) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        Comparator<Integer> comparator = ((o1, o2) -> o2 - o1);
        Queue<Integer> scores;
        for (int i = 0; i < items.length; i++) {
            if (map.containsKey(items[i][0])) {
                scores = map.get(items[i][0]);
                scores.add(items[i][1]);
            } else {
                scores = new PriorityQueue<>(comparator);
                scores.add(items[i][1]);
                map.put(items[i][0], scores);
            }
        }
        int[][] res = new int[map.size()][2];
        int index = 0;

        for (Map.Entry<Integer, Queue<Integer>> entry : map.entrySet()) {
            res[index][0] = entry.getKey();
            int sum = 0;
            Queue<Integer> queue = entry.getValue();
            for (int i = 0; i < 5; i++) {
                sum += queue.poll();
            }
            res[index++][1] = sum / 5;

        }
        return res;
    }
}

