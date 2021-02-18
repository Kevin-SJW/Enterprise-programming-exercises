package ClassificationTraining.huaweiMiddle;

/**
 * @Classname CarPooling
 * @Description TODO
 * @Date 2020/8/10 23:41
 * @Created by Administrator
 * 有capacity个作为，由于道路限制，只能像一个方向行驶
 * 不允许掉头或改变方向，可以想象为向量
 * 乘客数量，上车地点，下车地点，是否可以完成任务
 */
public class CarPooling {
    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 4;
        System.out.println(carPooling(trips, capacity));

    }

    public static boolean carPooling(int[][] trips, int capacity) {
        int[] allTrip = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            for (int j = trips[i][1]; j < trips[i][2]; j++) {
                allTrip[j] += trips[i][0];
                if (allTrip[j] > capacity) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean carPooling2(int[][] trips, int capacity) {
        int[] allTrip = new int[10000];
        for (int i = 0; i < trips.length; i++) {
            int from = trips[i][1], to = trips[i][2], people = trips[i][0];
            for (int j = from; j < to; j++) {
                allTrip[j] += people;
                if (allTrip[j] > capacity) {
                    return false;
                }
            }
        }
        return true;
    }
}
