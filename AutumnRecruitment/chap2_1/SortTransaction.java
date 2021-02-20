package AutumnRecruitment.chap2_1;

import AutumnRecruitment.StdIn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname SortTransaction
 * @Description TODO
 * @Date 2019/11/14 16:51
 * @Created by 14241
 */
public class SortTransaction {
    public static Transaction[] readTransactions() {
        Queue<Transaction> queue = new LinkedList<Transaction>()  {
        };
        while (StdIn.hasNextLine()) {
            String line = StdIn.readLine();
            queue.offer((new Transaction(line)));
        }
        Transaction[] transactions = new Transaction[queue.size()];
        for (int i = 0; i < transactions.length; i++) {
            transactions[i] = queue.poll();
        }
        return transactions;
    }

    public static void main(String[] args) {
        Transaction[] transactions = readTransactions();
        Arrays.sort(transactions);
        for (int i = 0; i < transactions.length; i++) {
            System.out.println(transactions[i]);
        }
    }
}
