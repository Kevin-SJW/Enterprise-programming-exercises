package LeetCodeSimple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname PascalTriangle2
 * @Description TODO
 * @Date 2020/6/27 17:07
 * @Created by Administrator
 */
public class PascalTriangle2 {
    public static void main(String[] args) {
        int rowIndex=3;
        System.out.println(getRow(rowIndex));

    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        for(int i=1;i<rowIndex+1;i++){
            list.add((int)((long)list.get(i-1)*(rowIndex-i+1)/i));
        }
        return list;
    }
}
