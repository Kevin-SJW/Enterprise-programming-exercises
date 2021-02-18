package ClassificationTraining.huaweiSimple;

/**
 * @Classname IsRectangleOverlap
 * @Description TODO
 * @Date 2020/10/3 11:48
 * @Created by Administrator
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 * <p>
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * <p>
 * 给出两个矩形，判断它们是否重叠并返回结果。
 * <p>
 *  
 */
public class IsRectangleOverlap {
    public static void main(String[] args) {
        int[] rec1 = {0, 0, 2, 2};
        int[] rec2 = {1, 1, 3, 3};
        System.out.println(isRectangleOverlap(rec1, rec2));

    }

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        for (int i = 0; i < rec1.length; i++) {
            for (int j = 0; j < rec2.length; j++) {
                if (rec2[0] >= rec1[2] && rec2[1] >= rec1[3]) {
                    return false;
                } else if (rec2[2] <= rec1[0] && rec2[3] <= rec1[1]) {
                    return false;
                } else if (rec2[0] >= rec1[2] || rec2[2] <= rec1[0] || rec2[1] >= rec1[3] || rec2[3] <= rec1[1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isRectangleOverlap2(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] || rec2[2] <= rec1[0] || rec1[3] <= rec2[1] || rec2[3] <= rec1[1]);
    }


}
