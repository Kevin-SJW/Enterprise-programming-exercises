package CredibleExam.exam_3_27;

import java.util.*;

/**
 * @Classname FindLangugePreference
 * @Description TODO
 * @Date 2020/7/26 12:02
 * @Created by Administrator
 * 编程语言偏好调查
 * 输入reviews=["pythonjava is good","i love cpp"],languages=["python","java","cpp"],k=2
 */
public class FindLangugePreference {
    public static void main(String[] args) {
        String[] reviews = {"pythonjava is good", "i love cpp"};
        String[] languages = {"python", "java", "cpp"};
        int k = 2;
        Arrays.stream(findLanguages(reviews, languages, k)).forEach(t -> System.out.print(t + "　"));
    }
    public static String[] findLanguages(String[] reviews, String[] languages, int k) {
        Map<String, Node> map = new HashMap<>();
        Node curNode = null;
        for (String language : languages) {
            if (map.containsKey(language)) {
                curNode = map.get(language);
                curNode.index++;
            } else {
                curNode = new Node();
                curNode.str = language;
            }
            map.put(language, curNode);
        }
        for (String review : reviews) {
            String[] reviewStrs = review.split(" ");
            Set<String> set = new HashSet<>();
            for (String word : reviewStrs) {
                if (set.contains(word)) {
                        continue;
                }
                if (map.containsKey(word)) {
                    Node cur = map.get(word);
                    cur.index++;
                    map.put(word, cur);
                }
            }
        }
        List<Node> ans = new ArrayList<>();
        for (String str : map.keySet()) {
            ans.add(map.get(str));
        }
        Collections.sort(ans, (o1, o2) -> {
            TreeSet<String> treeSet = new TreeSet<>();
            treeSet.add(o1.str);
            treeSet.add(o2.str);
            return o2.index == o1.index ? o1.str.equals(treeSet.first())
                    ? -1 : 1 : o2.index - o1.index;
        });
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k && i < ans.size(); i++) {
            if (i >= k) {
                break;
            }
            res.add(ans.get(i).str);
        }
        return res.toArray(new String[res.size()]);
    }
}

class Node {
    public int index;
    public String str;
}
