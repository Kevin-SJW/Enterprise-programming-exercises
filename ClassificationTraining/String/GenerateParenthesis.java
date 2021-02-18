package ClassificationTraining.String;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname GenerateParenthesis
 * @Description TODO
 * @Date 2019/11/1 14:26
 * @Created by 14241
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        int n=3;
        System.out.println(generateParenthesis(n));

    }
    public static  List<String> generateParenthesis(int n){
        List<String> ans=new ArrayList<>();
        if(n==0){
            ans.add("");
        }else{
            for(int c=0;c<n;c++){
                for(String left:generateParenthesis(c)){
                    for(String right:generateParenthesis(n-1-c)){
                        ans.add("("+left+")"+right);
                    }
                }
            }
        }
            return ans;
    }
}
