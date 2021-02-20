package ClassificationTraining.huaweiMiddle;

/**
 * @Classname CompressString
 * @Description TODO
 * @Date 2021/2/18 23:06
 * @Created by Administrator
 */
public class CompressString {
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(compress(chars));
    }

    public static int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                sb.append(count);
                sb.append(chars[i]);
                count = 1;
            }

        }
        sb.append(count);
        String res = sb.toString();
        int len=0;
        while(len<res.length()){
            len++;
        }
        return len;
    }

}
