package ClassificationTraining.huaweiMiddle;

/**
 * @Classname CompareVersion
 * @Description TODO
 * @Date 2020/10/8 16:58
 * @Created by Administrator
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 * <p>
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 * <p>
 *  . 字符不代表小数点，而是用于分隔数字序列。
 * <p>
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 * <p>
 * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
 */
public class CompareVersion {
    public static void main(String[] args) {
        String version1 = "0.1", version2 = "1.1";
        System.out.println(compareVersion(version1, version2));

    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len = Math.max(v1.length, v2.length);
        for (int i = 0; i < len; i++) {
            Integer m = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            Integer n = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            int compare = m.compareTo(n);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;

    }
}
