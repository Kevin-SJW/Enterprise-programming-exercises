package ClassificationTraining.huaweiSimple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname LastRemainingNumberInCircle
 * @Description TODO
 * @Date 2020/9/13 14:28
 * @Created by Administrator
 */
public class LastRemainingNumberInCircle {
    public static void main(String[] args) {
        int n = 5, m = 3;
//        System.out.println(lastRemaining(n,m));
//        Arrays.stream(lastRemaining(n, m)).forEach(t-> System.out.print(t+" "));
        System.out.println(lastRemaining2(n, m));

    }

    public static int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }
//        list.forEach(t-> System.out.print(t+" "));
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);

    }

    public static int lastRemaining2(int n, int m) {
        List<Integer> res=new ArrayList<>();

        for(int i=0;i<n;i++){
            res.add(i);
        }
        int index=0;
        while (n>1){
            index=(index+m-1)%n;
            res.remove(index);
            n--;
        }
        return res.get(0);
    }
}
