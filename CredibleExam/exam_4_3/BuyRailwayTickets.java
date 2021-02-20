package CredibleExam.exam_4_3;


import java.util.*;

/**
 * @Classname BuyRailwayTickets
 * @Description TODO
 * @Date 2020/7/26 18:31
 * @Created by Administrator
 * 火车购买联票数
 * 分析：(1)未被购买过过每排联票数为2，AB+DF或者BC+DF
 * （2）被购买过所在排购买过B/AC可购买联票数为1，所在购买过D/F可购买数减1
 * （3）实现：最大购买数2*row，减去2中购买情况数。
 */
public class BuyRailwayTickets {

    private static int A_COL = 0;
    private static int B_COL = 1;
    private static int C_COL = 2;
    private static int D_COL = 3;
    private static int F_COL = 5;

    public static int numSet(int rows, String[] seats) {
        Set<Integer> rowOrdered = new HashSet<>();
        Map<Integer, List<Integer>> hasBuy = new HashMap<>();
        int result;
        for (String seat : seats) {
            int row = Integer.parseInt(seat.substring(0, seat.length() - 1));
            int col = seat.charAt(seat.length() - 1) - 'A';
            if (!hasBuy.containsKey(row)) {
                List<Integer> colHasBuy = new ArrayList<Integer>();
                colHasBuy.add(col);
                hasBuy.put(row, colHasBuy);
            } else {
                hasBuy.get(row).add(col);
            }
            rowOrdered.add(row);

        }
        result = 2 * rows;
        return dealRowHasBuy(hasBuy, result);

    }

    private static int dealRowHasBuy(Map<Integer, List<Integer>> hasBuy, int result) {
        for (Map.Entry<Integer, List<Integer>> entry : hasBuy.entrySet()) {
            List<Integer> values = entry.getValue();
            if (values.contains(D_COL) || values.contains(F_COL)) {
                result--;
            }
            if (values.contains(A_COL) || values.contains(B_COL) && values.contains(C_COL)) {
                result--;
            }
        }
        return result;
    }
}
