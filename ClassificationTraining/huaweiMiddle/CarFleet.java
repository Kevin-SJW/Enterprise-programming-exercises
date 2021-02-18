package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;

/**
 * @Classname CarFleet
 * @Description TODO
 * @Date 2020/12/15 0:16
 * @Created by Administrator
 * N  辆车沿着一条车道驶向位于 target 英里之外的共同目的地。
 * 每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。
 * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。
 * 此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
 * 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
 * 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
 * 会有多少车队到达目的地?
 * 输入：target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * 输出：3
 * 解释：
 * 从 10 和 8 开始的车会组成一个车队，它们在 12 处相遇。
 * 从 0 处开始的车无法追上其它车，所以它自己就是一个车队。
 * 从 5 和 3 开始的车会组成一个车队，它们在 6 处相遇。
 * 请注意，在到达目的地之前没有其它车会遇到这些车队，所以答案是 3。
 * 新建一个类Data，包含pos和speed两个属性，然后新建这个类对象数组datas；
 * 对datas根据pos从小到大排序；
 * 然后从大到小遍历datas数组，不断的判断当前车是否能够与行驶在前面的车队相遇，若能相遇，则将其并到前面车队中，否则当前车另起一个车队。
 * 如何判断是否能够相遇
 * <p>
 * 位置小的车要超过行驶在前面位置大的车，必须速度大一点，然后判断相遇的地点是否在终点target之前，若在target之前，说明能够相遇。
 */
public class CarFleet {
    public static void main(String[] args) {
        int[] position = {10, 8, 0, 5, 3};
        int[] spedd = {2, 4, 1, 1, 3};
        int target = 12;
        System.out.println(carFleet(target, position, spedd));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        float[][] map = new float[position.length][2];
        for (int i = 0; i < position.length; i++) {
            map[i][0] = position[i]; //存放位置
            map[i][1] = (float) (target - position[i]) / speed[i];  //存放时间
        }
        //对map排序，以位置的远近排序 由远到进排序
        Arrays.sort(map, (o1, o2) -> (int) (o2[0] - o1[0]));

        int res = 0;//计算车队数
        float closesitetime = 0;//存储近的时间
        for (int i = 0 ; i < position.length; i++) {
            //由近到远开始计算 远的时间<近的时间  不做处理
            //          远的时间>近的时间  存储shorttime为当下的时间(远的时间)
            //              res++(车队+1)
            //每次更新当下车队的时间
            float farsitetime = map[i][1];//存储远的时间
            if (farsitetime > closesitetime){
                closesitetime = farsitetime;
                //因为远的时间 > 近的时间 所以将远的时间给予近的时间，进行下次比较
                res++;//车队+1
            }
        }
        return res;

    }

}
