package ClassificationTraining.huaweiMiddle;

import java.util.*;

/**
 * @Classname ThroneInheritance
 * @Description TODO
 * @Date 2020/12/20 10:50
 * @Created by Administrator
 * 一个王国里住着国王、他的孩子们、他的孙子们等等。每一个时间点，这个家庭里有人出生也有人死亡。
 * 这个王国有一个明确规定的皇位继承顺序，第一继承人总是国王自己。我们定义递归函数 Successor(x, curOrder) ，给定一个人 x 和当前的继承顺序，该函数返回 x 的下一继承人。
 * Successor(x, curOrder):
 * 如果 x 没有孩子或者所有 x 的孩子都在 curOrder 中：
 * 如果 x 是国王，那么返回 null
 * 否则，返回 Successor(x 的父亲, curOrder)
 * 否则，返回 x 不在 curOrder 中最年长的孩子
 * 比方说，假设王国由国王，他的孩子 Alice 和 Bob （Alice 比 Bob 年长）和 Alice 的孩子 Jack 组成。
 * <p>
 * 一开始， curOrder 为 ["king"].
 * 调用 Successor(king, curOrder) ，返回 Alice ，所以我们将 Alice 放入 curOrder 中，得到 ["king", "Alice"] 。
 * 调用 Successor(Alice, curOrder) ，返回 Jack ，所以我们将 Jack 放入 curOrder 中，得到 ["king", "Alice", "Jack"] 。
 * 调用 Successor(Jack, curOrder) ，返回 Bob ，所以我们将 Bob 放入 curOrder 中，得到 ["king", "Alice", "Jack", "Bob"] 。
 * 调用 Successor(Bob, curOrder) ，返回 null 。最终得到继承顺序为 ["king", "Alice", "Jack", "Bob"] 。
 * 通过以上的函数，我们总是能得到一个唯一的继承顺序。
 */
public class ThroneInheritance {
    String kingName;
    Map<String, List<String>> map = new HashMap<>();
    Set<String> set = new HashSet<>();

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
        map.put(kingName, new LinkedList<>());
    }

    public void birth(String parentName, String childName) {
        if (map.containsKey(parentName)) {
            map.get(parentName).add(childName);
        }
        map.put(childName, new LinkedList<>());
    }

    public void death(String name) {
            set.add(name);

    }

    public List<String> getInheritanceOrder() {
        List<String> res = new LinkedList<>();
        dfs(res, kingName);
        return res;

    }

    public void dfs(List<String> res, String name) {
        if (!set.contains(name)) {
            res.add(name);
        }
        for (String subName : map.get(name)) {
            dfs(res, subName);
        }
    }

    public static void main(String[] args) {
        ThroneInheritance t = new ThroneInheritance("king"); // 继承顺序：king
        t.birth("king", "andy"); // 继承顺序：king > andy
        t.birth("king", "bob"); // 继承顺序：king > andy > bob
        t.birth("king", "catherine"); // 继承顺序：king > andy > bob > catherine
        t.birth("andy", "matthew"); // 继承顺序：king > andy > matthew > bob > catherine
        t.birth("bob", "alex"); // 继承顺序：king > andy > matthew > bob > alex > catherine
        t.birth("bob", "asha"); // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
        System.out.println(t.getInheritanceOrder());
        ; // 返回 ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
        t.death("bob"); // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
        System.out.println(t.getInheritanceOrder());
        ; // 返回 ["king", "andy", "matthew", "alex", "asha", "catherine"]

    }
}
