package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;

/**
 * @Classname BookingTickets
 * @Description TODO
 * @Date 2020/8/10 23:55
 * @Created by Administrator
 * 订机票 [i,j,k] i-j,预定了k个座位
 * [10,55,45,25,25]
 */
public class BookingTickets {
    public static void main(String[] args) {
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        Arrays.stream(bookingFlightTickets(bookings, n)).forEach(t -> System.out.print(t + " "));
    }

    public static int[] bookingFlightTickets(int[][] bookings, int n) {
        int[] answer = new int[n];
        for (int[] booking : bookings) {
            int from = booking[0];
            int to = booking[1];
            int count = booking[2];
            while (from <= to) {
                answer[from - 1] += count;
                from++;
            }

        }
        return answer;

    }

}
