package ClassificationTraining.huaweiSimple;

/**
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)"
 * 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()"
 * 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 * 输入：command = "G()(al)"
 * 输出："Goal"
 * 解释：Goal 解析器解释命令的步骤如下所示：
 * G -> G
 * () -> o
 * (al) -> al
 * 最后连接得到的结果是 "Goal"
 */
public class DesignGoalInterpret {
    public static void main(String[] args) {
        String command = "G()(al)";
        String command2="G()()()()(al)";
        System.out.println(interpret2(command2));
    }

    public static String interpret(String command) {
        command = command.replace("()", "o");
        command = command.replace("(al)", "al");
        return command;
    }

    public static String interpret2(String command) {
        StringBuilder sb = new StringBuilder();

        StringBuilder temp = new StringBuilder();
        for (Character ele : command.toCharArray()) {
            if (ele.equals('G')) {
                sb.append(ele);
            } else {
                temp.append(ele);
            }

            if ("()".equals(temp.toString())) {
                sb.append("o");
                temp = new StringBuilder();
            }

            if ("(al)".equals(temp.toString())) {
                sb.append("al");
                temp = new StringBuilder();
            }
        }

        return sb.toString();
    }

}
