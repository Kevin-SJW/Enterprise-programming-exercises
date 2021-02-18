package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname RemoveSubFloders
 * @Description TODO
 * @Date 2020/9/20 17:06
 * @Created by Administrator
 * 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，
 * 并以 任意顺序 返回剩下的文件夹。
 * 我们这样定义「子文件夹」：
 * 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的子文件夹。
 * 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：
 * / 后跟一个或者多个小写英文字母。
 * 例如，/leetcode 和 /leetcode/problems 都是有效的路径，而空字符串和 / 不是。
 */
public class RemoveSubFloders {
    public static void main(String[] args) {
        String[] folder = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        removeSubfolders(folder).stream().forEach(t -> System.out.print(t + " "));
    }

    public static List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        Arrays.sort(folder);
        res.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String father = res.get(res.size() - 1);
            if (!folder[i].contains(father + "/")) {
                res.add(folder[i]);
            }
        }
        return res;
    }

    public static List<String> removeSubfolders2(String[] folder) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(folder);
        ans.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String father = ans.get(ans.size()-1);
            if (!folder[i].contains(father + "/")) {
                ans.add(folder[i]);
            }
        }
        return ans;
    }

}
