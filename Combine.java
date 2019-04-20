import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname Combine
 * @Description 给定整数n，返回1到n的所有组合
 * @Date 2019/4/20 15:44
 * @Created by 14241
 */
public class Combine {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            System.out.println(combine(n,i));
            System.out.println("\n");
        }

    }
    public static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {
        if(n<=0||k<=0||k>n){
            return res;
        }

        combineAux(n,k,1,new ArrayList<Integer>());
        return res;

    }
    private static void combineAux(int n,int k,int sta,List<Integer> t){

        if(t.size()==k){
            res.add(new ArrayList(t));
            return;
        }

        for(int i = sta;i<=n-(k-t.size())+1;i++){
            t.add(i);
            combineAux(n,k,i+1,t);
            t.remove(t.size()-1);
        }
    }


}
