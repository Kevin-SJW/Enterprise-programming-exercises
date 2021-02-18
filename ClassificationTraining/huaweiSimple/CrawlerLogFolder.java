package ClassificationTraining.huaweiSimple;

/**
 * @Classname CrawlerLogFolder
 * @Description TODO
 * @Date 2020/10/1 16:29
 * @Created by Administrator
 */
public class CrawlerLogFolder {
    public static void main(String[] args) {
        String[] logs = {"d1/", "d2/", "../", "d21/", "./"};
        System.out.println(minOperations(logs));

    }

    public static int minOperations(String[] logs) {
        int depth = 0;

        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals("../")) {
                if (depth == 0) {
                    continue;
                } else {
                    depth--;
                }
            } else if (logs[i].equals("./")) {
                continue;
            } else {
                depth++;
            }
        }
        return depth;
    }
}
