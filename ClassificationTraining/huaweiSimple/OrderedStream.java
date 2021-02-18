package ClassificationTraining.huaweiSimple;

import java.util.ArrayList;
import java.util.List;

/**
 * 有 n 个 (id, value) 对，其中 id 是 1 到 n 之间的一个整数，value 是一个字符串。
 * 不存在 id 相同的两个 (id, value) 对。
 * 设计一个流，以 任意 顺序获取 n 个 (id, value) 对，并在多次调用时 按 id 递增的顺序 返回一些值。
 * 实现 OrderedStream 类：
 * OrderedStream(int n) 构造一个能接收 n 个值的流，并将当前指针 ptr 设为 1 。
 * String[] insert(int id, String value) 向流中存储新的 (id, value) 对。存储后：
 * 如果流存储有 id = ptr 的 (id, value) 对，则找出从 id = ptr 开始的 最长 id 连续递增序列 ，
 * 并 按顺序 返回与这些 id 关联的值的列表。然后，将 ptr 更新为最后那个  id + 1 。
 * 否则，返回一个空列表。
 */
public class OrderedStream {
    String[] stream;
    int ptr = 0;

    public OrderedStream(int n) {
        //根据长度创建String数组保存值
        stream = new String[n];
    }
    public List<String> insert(int id, String value) {
        // id从1起始，所以减1
        stream[id - 1] = value;
        List<String> list = new ArrayList<>();
        for (int i = ptr; i < stream.length; i++) {
            // 如果遇到流中的空值，跳出循环直接返回list
            if (stream[i] == null) {
                break;
            } else {
                // 如果该处不为空值，那么ptr就可以到这个地方，返回的list中也应包括这个值
                ptr++;
                list.add(stream[i]);
            }
        }
        return list;
    }
}
