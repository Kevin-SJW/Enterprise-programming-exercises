package LeetCodeSimple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname PascalTriangle
 * @Description TODO
 * @Date 2020/6/27 16:49
 * @Created by Administrator
 */
public class PascalTriangle {
    public static void main(String[] args) {
        int numRows=5;
//        generate(numRows).stream().forEach(t->
//                t.forEach(p-> System.out.print(p+" ")));
        System.out.println(generate(numRows).toString());

    }
    public static List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res=new ArrayList<>();
            if(numRows==0){
                return res;
            }
            for(int i=0;i<numRows;i++){
                List<Integer> rows=new ArrayList<>();
                for(int j=0;j<i+1;j++){
                    if(j==0||i==j){
                        rows.add(1);
                    }else{
                        rows.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                    }
                }
                res.add(rows);
            }
            return res;
    }
}
