import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname GenParenthesis
 * @Description TODO
 * @Date 2019/4/21 13:04
 * @Created by 14241
 */
public class GenParenthesis {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        System.out.println(genParenthesis(n));

    }
    private  static List<String> genParenthesis(int n){
        List<String> str=new ArrayList<>();
        if(n==0){
            str.add("");
        }
        else{
            for(int c=0;c<n;c++){
                for(String left:genParenthesis(c)){
                    for(String right:genParenthesis(n-1-c)){
                        str.add("("+left+")"+right);

                    }
                }

            }
        }
        return str;
    }
}
