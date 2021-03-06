package ClassificationTraining.huaweiMiddle;

/**
 * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。
 * 一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。
 * 现给定起始字符串start和结束字符串end，请编写代码，
 * 当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。
 * 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"   输出: True
 * 我们可以通过以下几步将start转换成end:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 */
public class SwapNeighborLetter {
    public static void main(String[] args) {
        String start = "RXXLRXRXL", end = "XRLXXRRLX";
        System.out.println(canTransform(start, end)); }
    public static boolean canTransform(String start, String end) {
        if (!start.replace("X", "")
                .equals(end.replace("X", ""))) {
            return false; }
        int t = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'L') {
                while (end.charAt(t) != 'L') {
                    t++;
                }
                if (i < t++) {
                    return false; } } }
        t = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'R') {
                while (end.charAt(t) != 'R') {
                    t++;
                }
                if (i > t++) {
                    return false;
                }
            }

        }
        return true;
    }
}

