package ClassificationTraining.huaweiMiddle;

/**
 * @Classname DecodeAtIndex
 * @Description TODO
 * @Date 2020/12/18 23:37
 * @Created by Administrator
 * 给定一个编码字符串 S。请你找出 解码字符串 并将其写入磁带。
 * 解码时，从编码字符串中 每次读取一个字符 ，并采取以下步骤：
 * <p>
 * 如果所读的字符是字母，则将该字母写在磁带上。
 * 如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。
 * 现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。
 * 输入：S = "leet2code3", K = 10
 * 输出："o"
 * 解码后的字符串为 "leetleetcodeleetleetcodeleetleetcode"。
 * 字符串中的第 10 个字母是 "o"。
 */
public class DecodeAtIndex {
    public static void main(String[] args) {
        String s = "leet2code3";
        int k = 10;
        System.out.println(decodeAtIndex2(s, k));
    }

    public static String decodeAtIndex(String s, int k) {
        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                sb.append(c);
            } else if (Character.isDigit(c)) {
                num = Integer.parseInt(String.valueOf(c));
                for (int j = 0; j < num; j++) {
                    res.append(sb);
                }
                sb = res;
                res = new StringBuilder();
            }
        }
        char index = sb.toString().charAt(k - 1);
        return String.valueOf(index);
    }

    //S中数字过多过大可能的溢出问题,优化点：我们并不需要计算出解释后总长度，
    // 只要计算到 >= K的部分的长度即可；
    public static String decodeAtIndex2(String s, int k) {
        int count, lastCount;
        count = 0;
        lastCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                count *= c - '0';
                //如果乘了数字以后大于等于K，则返回到上个循环节中找
                if (count >= k) {//当整除的时候是找最后一个(lastCount)而不是0
                    return decodeAtIndex(s, (k - 1) % lastCount + 1);
                }
            } else {
                count++;
                lastCount = count;
                if (count == k) {
                    return "" + c;
                }
            }
        }
        return null;

    }
}
