package ClassificationTraining.huaweiMiddle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname BrickWall
 * @Description TODO
 * @Date 2020/8/17 23:48
 * @Created by Administrator
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> wa : wall) {
            int sum = 0;
            for (int i=0;i<wa.size()-1;i++) {
                sum += wa.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                max = Math.max(max, map.get(sum));
            }

        }
        return wall.size() - max;
    }
}
