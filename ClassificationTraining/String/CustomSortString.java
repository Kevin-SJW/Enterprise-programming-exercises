package ClassificationTraining.String;

/**
 * @Classname CustomSortString
 * @Description TODO
 * @Date 2020/9/26 17:16
 * @Created by Administrator
 * 字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。
 * <p>
 * S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。更具体地说，
 * 如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。
 * <p>
 * 返回任意一种符合条件的字符串T。
 * <p>
 * 输入:
 * S = "cba"
 * T = "abcd"
 * 输出: "cbad"
 * 解释:
 * S中出现了字符 "a", "b", "c", 所以 "a", "b", "c" 的顺序应该是 "c", "b", "a".
 * 由于 "d" 没有在S中出现, 它可以放在T的任意位置. "dcba", "cdba", "cbda" 都是合法的输出。
 */
public class CustomSortString {
    public static void main(String[] args) {
        String s = "cba";
        String t = "abcd";
        System.out.println(customSortString(s, t));

    }

    public static String customSortString(String s, String t) {
        StringBuilder sb = new StringBuilder();
        int[] num=new int[t.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if ( s.charAt(i) == t.charAt(j)){
                    num[j]=1;
                    sb.append(t.charAt(j));
                }
            }
        }
        System.out.println("sb:"+sb.toString());
        for(int j=0;j<t.length();j++){
            if(num[j]!=1){
                sb.append(t.charAt(j));
            }
        }
        return sb.toString();
    }
}
