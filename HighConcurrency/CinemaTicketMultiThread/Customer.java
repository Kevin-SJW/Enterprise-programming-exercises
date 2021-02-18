package HighConcurrency.CinemaTicket;

/**
 * 通过卖票程序读懂多线程--顾客类
 *
 * @author zhuhuix
 * @date 2020-05-12
 */
public class Customer {
    //顾客id
    private int customerId;
    //购买的电影票
    private Ticket ticket;

    public Customer(int customerId) {
        this.customerId = customerId;
    }

    //顾客买票
    public void buyTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", ticket=" + ticket.toString() +
                '}';
    }
}
