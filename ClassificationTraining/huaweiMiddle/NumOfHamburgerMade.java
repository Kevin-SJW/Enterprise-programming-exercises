package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname NumOfHamburgerMade
 * @Description TODO
 * @Date 2020/10/2 14:38
 * @Created by Administrator
 * 圣诞活动预热开始啦，汉堡店推出了全新的汉堡套餐。为了避免浪费原料，请你帮他们制定合适的制作计划。 1276
 * <p>
 * 给你两个整数 tomatoSlices 和 cheeseSlices，分别表示番茄片和奶酪片的数目。不同汉堡的原料搭配如下：
 * <p>
 * 巨无霸汉堡：4 片番茄和 1 片奶酪
 * 小皇堡：2 片番茄和 1 片奶酪
 * 请你以 [total_jumbo, total_small]（[巨无霸汉堡总数，小皇堡总数]）的格式返回恰当的制作方案，使得剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量都是 0。
 * <p>
 * 如果无法使剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量为 0，就请返回 []。
 * <p>
 * 输入：tomatoSlices = 16, cheeseSlices = 7
 * 输出：[1,6]
 * 解释：制作 1 个巨无霸汉堡和 6 个小皇堡需要 4*1 + 2*6 = 16 片番茄和 1 + 6 = 7 片奶酪。不会剩下原料。
 * <p>
 * 假设巨无霸汉堡xx个，小皇堡yy个，那么可得二元一次方程如下：
 * 4x + 2y = tomatoSlices
 * x + y = cheeseSlices
 * <p>
 * 求解方程可得：
 * x = tomatoSlices / 2 - cheeseSlicesx
 * y = cheeseSlices - x
 * <p>
 * 因此，在x和y必须是非负整数的前提下，从上面x和y的解可发现以下几个规律：
 * <p>
 * tomatoSlicestomatoSlices 必须是偶数；
 * tomatoSlices / 2 - cheeseSlicestomatoSlices/2−cheeseSlices 必须 >= 0>=0
 * cheeseSlices - x必须 >= 0>=0
 */
public class NumOfHamburgerMade {
    public static void main(String[] args) {
        int tomatoSlices = 16, cheeseSlices = 7;
        numOfBurgers(tomatoSlices, cheeseSlices).stream().forEach(t -> System.out.print(t + " "));

    }

    public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> ansList = new ArrayList<>();
        if (tomatoSlices % 2 == 1) {
            return ansList;
        }
        int x = tomatoSlices / 2 - cheeseSlices;
        if (x < 0) {
            return ansList;
        }
        int y = cheeseSlices - x;
        if (y < 0) {
            return ansList;
        }
        ansList.add(x);
        ansList.add(y);
        return ansList;


    }
}
