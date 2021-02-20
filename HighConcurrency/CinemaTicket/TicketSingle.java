package HighConcurrency.CinemaTicket;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 通过卖票程序读懂多线程--单线程程序
 *
 * @author zhuhuix
 * @date 2020-05-12
 */
public class TicketSingle {

    private static final String ROOM = "中央放映厅";
    private static final int ROW = 10;
    private static final int COL = 20;
    private static final String FILM_NAME = "战狼3";
    private static final BigDecimal PRICE = BigDecimal.valueOf(30);

    private static List<Ticket> tickets = new ArrayList<>();

    private static final int CUSTOMER_COUNT = 250;
    private static List<Customer> customers = new ArrayList<>(CUSTOMER_COUNT);

    public static void main(String[] args) {
        //中央放映厅总共有250个座位，2020-05-12 18:00 放映战狼3，售票价格为30元
        int ticketId=1;
        for (int row = 1; row <= ROW; row++) {
            for (int col = 1; col <= COL; col++) {
                Ticket ticket = new Ticket(ticketId++, ROOM, row, col,
                        FILM_NAME, PRICE,
                        LocalDateTime.of(2020, 5, 10, 18, 00));
                tickets.add(ticket);
            }
        }
        Iterator<Ticket> iterator = tickets.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());

        }

        //顾客到售票点进行随机买票
        Collections.shuffle(tickets);
        int index = 1;
        while (tickets.size() > 0 && index <= CUSTOMER_COUNT) {
            Ticket ticket = tickets.get(tickets.size() - 1);

            Customer customer = new Customer(index);
            customer.buyTicket(ticket);
            customers.add(customer);

            tickets.remove(ticket);

            System.out.println(tickets.size() + "," + index);
            System.out.println(index + "号顾客买到了"
                    + "第" + customer.getTicket().getRow() + "行，第" + customer.getTicket().getCol() + "列的票");
            index++;
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("电影票出售情况如下：");
        //剩余票的状态
        System.out.println("剩余票数：" + tickets.size());
        Iterator<Ticket> ticketIterator = tickets.iterator();
        while (ticketIterator.hasNext()) {
            System.out.println(ticketIterator.next().toString());
        }
        //顾客购买情况
        System.out.println("买到票的人数：" + customers.size());
        Iterator<Customer> customerIterator = customers.iterator();
        while (customerIterator.hasNext()) {
            System.out.println(customerIterator.next().toString());
        }
        System.out.println("未买到票的人数：" +(CUSTOMER_COUNT- customers.size()));

    }
}
