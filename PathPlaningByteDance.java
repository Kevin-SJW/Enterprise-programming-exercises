import java.util.Random;
import java.util.Stack;

/**
 * @Classname PathPlaningByteDance
 * @Description TODO
 * @Date 2019/4/14 14:11
 * @Created by 14241
 */



import java.util.*;
import java.io.*;
import java.lang.System;

/**
 * ByteDance春招第二批第四题，复杂度有点高，
 * 规定时间没跑完，只过了50%
 * 4
 * 0 2 6 5
 * 2 0 4 4
 * 6 4 0 2
 * 5 4 2 0
 *
 */

public class PathPlaningByteDance {
    private static Random rnd = new Random();
    private static int start;

    public static int count = 0;

    private static int[][] edge;
    //目标路径
    private static int[] s;
    //临时路径
    private static int[] t;

    private static Stack<node>[] stack;

    private static boolean[] found;

    private static int weight = 0;

    private static int z = 1;


    public static void initialFoudEdge(int count) {
        found = new boolean[count];
        for (int i = 0; i < count; i++) {
            found[i] = false;
        }
    }

    public static void generateEdge(int count) {

    }


    public int numberOfNode() {
        return count;
    }

    public static void outPath() {

        z++;
    }


    public static void tranform() {
        for (int i = 0; i < count; i++) {
            s[i] = t[i];
        }
        s[count] = weight;
    }

    public static void greedyFind(int temp) {
        start = temp;
        found[temp] = true;
        node c;
        int dindex = -1;
        int start = temp;
        int k = count - 1;

        for (int i = start; k > 0; ) {
            int min = 60000;
            for (int j = 0; j < count; j++) {
                if (j != 0 && edge[i][j] > 0 && found[j] == false
                        && min > edge[i][j]) {
                    min = edge[i][j];
                    dindex = j;
                }
            }
            weight += min;
            found[dindex] = true;
            t[count - 1 - k] = dindex;
            i = dindex;
            k--;
            if (k == 0) {
                t[count - 1] = 0;
                weight += edge[i][temp];
            }
        }
        tranform();
        s[s.length - 1] = weight;
    }

    public static void find(int start) {
        start = start;
        int iStart = start;
        node c;
        int nweight = 0;
        found[iStart] = true;
        int k = 0;

        for (int i = start; ; ) {
            found[i] = true;
            if (stack[k].empty()) {
                for (int j = 0; j < count; j++) {
                    if (found[j] == false && j != i && edge[i][j] > 0
                            && nweight + edge[i][j] < weight) {
                        node temp = new node(j, edge[i][j], i);
                        stack[k].push(temp);
                    }
                }
            }
            if (!stack[k].empty()) {
                int l = stack[k].peek().nodeNumber;
                t[k] = l;
                nweight = nweight + edge[i][l];

                i = l;
                k++;
            } else {
                if (k == count - 1) {
                    if (nweight + edge[i][start] < weight) {
                        t[k] = start;
                       /* 每次输出时权值在变，所以每次比较都与当前的最短路径权值比较。*/
                        weight = nweight + edge[i][start];
                        tranform();
                        outPath();
                        s[s.length - 1] = nweight + edge[i][start];

                    }
                    while (stack[k].empty()) {
                        c = stack[--k].pop();
                        i = c.lastNodeNumber;
                        found[c.nodeNumber] = false;
                        nweight = nweight - c.addWeight;
                        if (stack[0].empty()) {
                            break;
                        }
                    }


                } else {
                    while (stack[k].empty()) {
                        c = stack[--k].pop();
                        i = c.lastNodeNumber;
                        found[c.nodeNumber] = false;
                        nweight = nweight - c.addWeight;
                        if (stack[0].empty()) {
                            break;
                        }
                    }

                }
            }

            if (stack[0].empty()) {
                break;
            }
        }

    }

    static class node {
        int nodeNumber;

        int lastNodeNumber;

        int addWeight;

        node(int nodeNumber, int addWeight, int lastNodeNumber) {
            this.nodeNumber = nodeNumber;
            this.addWeight = addWeight;
            this.lastNodeNumber = lastNodeNumber;
        }
    }

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        count = n;

        stack = new Stack[count];
        for (int i = 0; i < count; i++) {
            stack[i] = new Stack<node>();
        }

        s = new int[count + 1];
        t = new int[count + 1];
        for (int i = 0; i < count + 1; i++) {
            s[i] = -1;
        }
        for (int i = 0; i < count + 1; i++) {
            t[i] = -1;
        }

        edge = new int[count][count];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {

                edge[i][j] = scanner.nextInt();
            }
        }


        initialFoudEdge(count);
        greedyFind(0);

        outPath();
        initialFoudEdge(count);

        find(0);
        outPath();

        System.out.println(s[s.length - 1]);
    }


}

