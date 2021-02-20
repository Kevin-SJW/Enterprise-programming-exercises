package HighConcurrency.CinemaTicketMultiThread;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 通过卖票程序读懂多线程--多线程
 *
 * @author zhuhuix
 * @date 2020-05-12
 */
public class TicketThread extends Thread {
    private static final String ROOM = "中央放映厅";
    private static final int ROW = 10;
    private static final int COL = 20;
    private static final String FILM_NAME = "战狼3";
    private static final BigDecimal PRICE = BigDecimal.valueOf(30);

    private volatile static List<Ticket> tickets = new Vector<>();

    private static final int CUSTOMER_COUNT = 250;
    private static int customerId = 1;
    private volatile static List<Customer> customers = new Vector<>(CUSTOMER_COUNT);

    TicketThread(String name) {
        super(name);

    }

    @Override
    public void run() {

        while (tickets.size() > 0 && customerId <= CUSTOMER_COUNT) {
            synchronized (TicketThread.class) {
                //线程内两次判断，防止tickets 数组溢出
                if (tickets.size()>0) {
                    Ticket ticket = tickets.get(tickets.size() - 1);
//                    ticket.setWindow(Thread.currentThread().getName());
                    Customer customer = new Customer(customerId);
                    customer.buyTicket(ticket);
                    customers.add(customer);

                    tickets.remove(ticket);

                    System.out.println(tickets.size() + "," + customerId);
                    System.out.println(Thread.currentThread().getName() + ":" + customerId + "号顾客买到了"
                            + "第" + customer.getTicket().getRow() + "行，第" + customer.getTicket().getCol() + "列的票");
                    customerId++;
                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //中央放映厅总共有250个座位，2020-05-12 18:00 放映战狼3，售票价格为30元
        int ticketId = 1;
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

        TicketThread ticketThreadA = new TicketThread("售票点A");
        TicketThread ticketThreadB = new TicketThread("售票点B");
        TicketThread ticketThreadC = new TicketThread("售票点C");

        ticketThreadA.start();
        ticketThreadB.start();
        ticketThreadC.start();

        ticketThreadA.join();
        ticketThreadB.join();
        ticketThreadC.join();

        System.out.println("电影票出售情况如下：");
        //剩余票的状态
        System.out.println("总共票数:" + ROW * COL + ",剩余票数：" + tickets.size());
        Iterator<Ticket> ticketIterator = tickets.iterator();
        while (ticketIterator.hasNext()) {
            System.out.println(ticketIterator.next().toString());
        }
        //顾客购买情况
        System.out.println("买到票的人数：" + customers.size());
        System.out.println("未买到票的人数：" + (CUSTOMER_COUNT - customers.size()));
        Iterator<Customer> customerIterator = customers.iterator();
        while (customerIterator.hasNext()) {
            System.out.println(customerIterator.next().toString());
        }
        System.out.println("未买到票的人数：" + (CUSTOMER_COUNT - customers.size()));

    }
}
