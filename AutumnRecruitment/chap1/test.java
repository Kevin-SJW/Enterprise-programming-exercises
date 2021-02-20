package AutumnRecruitment.chap1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Classname test
 * @Description TODO
 * @Date 2019/9/21 15:15
 * @Created by 14241
 */
public class test {
    public static void iterManipulation(List<String> a){
        ListIterator<String> it=a.listIterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
    public static void testLinkedList(List<String> a){
        List<String> list=new LinkedList<>();

    }
    public static void main(String[] args){

    }
}
