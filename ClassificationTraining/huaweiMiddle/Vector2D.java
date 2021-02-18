package ClassificationTraining.huaweiMiddle;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname Vector2D
 * @Description TODO
 * @Date 2020/10/25 10:34
 * @Created by Administrator
 */
public class Vector2D {

    Queue<Integer> queue = new LinkedList<>();

    public Vector2D(int[][] v) {
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                queue.offer(v[i][j]);
            }
        }

    }

    public int next() {
        return queue.poll();

    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }


}
