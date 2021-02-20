package HighConcurrency.BankTellerSimulation2;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Classname BankTellerSimulation2
 * @Description TODO
 * @Date 2020/1/19 15:18
 * @Created by 14241
 */
class Customer {
    private final int serviceTime;

    public Customer(int tm) {
        serviceTime = tm;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    @Override
    public String toString() {
        return "[" + serviceTime + "]";
    }

}

/**
 * teach the customer line to display itself
 */
class CustomerLine extends ArrayBlockingQueue<Customer> {

    public CustomerLine(int maxSize) {
        super(maxSize);
    }

    @Override
    public String toString() {
        if (this.size() == 0) {
            return "[empty]";
        }
        StringBuilder sb = new StringBuilder();
        for (Customer customer : this) {
            sb.append(customer);
        }
        return sb.toString();
    }

}

/**
 * randomly add customer to a queue
 */
class CustomerGenerator implements Runnable {
    private CustomerLine customers;
    private Random rand = new Random(47);

    public CustomerGenerator(CustomerLine cq) {
        customers = cq;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
                customers.put(new Customer(rand.nextInt(1000)));
            }

        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " terminated");
    }
}

class Teller implements Runnable, Comparable<Teller> {
    public static int count = 0;
    public final int id = count++;
    // Customers served during this shift:
    private int customServed = 0;
    private CustomerLine customers;
    public boolean servingCustomLine = true;

    public Teller(CustomerLine cq) {
        customers = cq;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Customer customer = customers.take();
                TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
                synchronized (this) {
                    customServed++;
                    if (!servingCustomLine) {
                        wait();
                    }
                }
            }

        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " terminated");

    }

    public synchronized void doSomethingElse() {
        customServed = 0;
        servingCustomLine = false;
    }

    public synchronized void servingCustomLine() {
        assert !servingCustomLine : "already serving" + this;
        servingCustomLine = true;
        notifyAll();
    }

    @Override
    public String toString() {
        return "teller" + id;
    }

    public String shortString() {
        return "T" + id;
    }

    // Used by priority queue:
    @Override
    public synchronized int compareTo(Teller other) {
        return customServed < other.customServed ? -1 :
                (customServed == other.customServed ? 0 : 1);
    }
}

class TellerManager implements Runnable {
    private ExecutorService exec;
    private CustomerLine customers;
    private PriorityQueue<Teller> workingTellers = new PriorityQueue<>();
    private Queue<Teller> tellersDoingOtherThings = new LinkedList<>();
    private int adjustmentPeriod;
    private static Random rand = new Random(47);

    public TellerManager(ExecutorService e, int adjustmentPeriod,
                         CustomerLine customers) {
        exec = e;
        this.customers = customers;
        this.adjustmentPeriod = adjustmentPeriod;
        // Start with a single teller:
        Teller teller = new Teller(customers);
        exec.execute(teller);
        workingTellers.add(teller);

    }

    public void adjustTellerNumbers() {
        // This is actually a control system. By adjusting
        // the numbers, you can reveal stability issues in
        // the control mechanism.
        // If line is too long, add another teller:
        if (customers.size() / workingTellers.size() > 2) {
            // If tellers are on break or doing
            // another job, bring one back:
            if (tellersDoingOtherThings.size() > 2) {
                Teller teller = tellersDoingOtherThings.remove();
                teller.servingCustomLine();
                workingTellers.offer(teller);
                return;
            }
            // Else create (hire) a new teller
            Teller teller = new Teller(customers);
            exec.execute(teller);
            workingTellers.add(teller);
            return;
        }
        // If line is short enough, remove a teller:
        if (workingTellers.size() > 1 &&
                customers.size() / workingTellers.size() < 2) {
            reassignOneTeller();
        }
        // If there is no line, we only need one teller:
        if (customers.size() == 0) {
            while (workingTellers.size() > 1) {
                reassignOneTeller();
            }

        }

    }

    // Give a teller a different job or a break:
    public void reassignOneTeller() {
        Teller teller = workingTellers.poll();
        teller.doSomethingElse();
        tellersDoingOtherThings.offer(teller);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                adjustTellerNumbers();
                System.out.println(customers + " { ");
                for (Teller teller : workingTellers) {
                    System.out.print(teller.shortString() + " ");
                }
                System.out.println("}");
            }

        } catch (InterruptedException e) {
            System.out.println(this + "interrupted");
        }
        System.out.println(this + "terminated.");
    }

    @Override
    public String toString() {

            return " tellerManager";
        }
    }

public class BankTellerSimulation2 {
    static final int MAX_LINE_SIZE=50;
    static final int ADJUSTMENT_PERIOD=1000;

    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService exec= Executors.newCachedThreadPool();
        // If line is too long, customers will leave:
        CustomerLine customers=new CustomerLine(MAX_LINE_SIZE);
        exec.execute(new CustomerGenerator(customers));
        exec.execute(new TellerManager(exec,ADJUSTMENT_PERIOD,customers));
        // Optional argument
        if (args.length > 0) // Optional argument
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
        else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdownNow();



    }
}
