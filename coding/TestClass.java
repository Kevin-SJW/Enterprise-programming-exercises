package coding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname TestClass
 * @Description TODO
 * @Date 2019/4/14 21:12
 * @Created by 14241
 */
public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n>1000){
                n=999;
            }
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<n;i++){
                list.add(i);
            }
            int i=0;
            while(list.size()>1){
                i=(i+1)%list.size();
                list.remove(i);
                i+=1;
            }
            System.out.println(list.get(0));
        }

    }
}
