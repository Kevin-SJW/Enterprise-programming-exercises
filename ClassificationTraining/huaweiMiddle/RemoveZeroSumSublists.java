package ClassificationTraining.huaweiMiddle;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname RemoveZeroSumSublists
 * @Description TODO
 * @Date 2021/1/19 0:08
 * @Created by Administrator
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，
 * 直到不存在这样的序列为止。
 * 删除完毕后，请你返回最终结果链表的头节点。你可以返回任何满足题目要求的答案。
 * 输入：head = [1,2,-3,3,1]  输出：[3,1] 答案 [1,2,1] 也是正确的。
 */
public class RemoveZeroSumSublists {
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return null; }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>(); // 首次遍历建立 节点处链表和<->节点 哈希表
        int sum = 0; // 若同一和出现多次会覆盖，即记录该sum出现的最后一次节点
        for (ListNode temp = dummy; temp != null; temp = temp.next) {
            sum += temp.val;
            map.put(sum, temp);
        }
        sum = 0;  // 第二遍遍历 若当前节点处sum在下一处出现了则表明两结点之间所有节点和为0 直接删除区间所有节点
        for (ListNode temp = dummy; temp != null; temp = temp.next) {
            sum += temp.val;
            temp.next = map.get(sum).next;
        }
        return dummy.next;
    }
    public ListNode removeZeroSumSublists2(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode node=dummy;
        while(node!=null&&node.next!=null){
            int sum=0;
            //从当前节点开始逐个连续相加直到和为0
            ListNode start=node.next;
            while(start!=null){
                sum+=start.val;
                if(sum==0){  //删除和为0的子链表
                    node.next=start.next;
                    break;
                }
                start=start.next;
            }
            //如果找到子链表,直接进入下一层循环
            if(sum==0) continue;
            node=node.next;
        }
        return dummy.next;
    }
}
