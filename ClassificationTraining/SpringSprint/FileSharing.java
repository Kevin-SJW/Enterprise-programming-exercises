package ClassificationTraining.SpringSprint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1500
 * 我们需要使用一套文件分享系统来分享一个非常大的文件，该文件由 m 个从 1 到 m 编号的文件块组成。
 * 当用户加入系统时，系统应为其注册一个独有的 ID。这个独有的 ID 应当被相应的用户使用一次，但是当用户离开系统时，
 * 其 ID 应可以被（后续新注册的用户）再次使用。
 * 用户可以请求文件中的某个指定的文件块，系统应当返回拥有这个文件块的所有用户的 ID。如果用户收到 ID 的非空列表，
 * 就表示成功接收到请求的文件块。
 * <p>
 * FileSharing(int m) 初始化该对象，文件有 m 个文件块。
 * int join(int[] ownedChunks)：一个新用户加入系统，并拥有文件的一些文件块。
 * 系统应当为该用户注册一个 ID，该 ID 应是未被其他用户占用的最小正整数。返回注册的 ID。
 * void leave(int userID)：ID 为 userID 的用户将离开系统，你不能再从该用户提取文件块了。
 * int[] request(int userID, int chunkID)：ID 为 userID 的用户请求编号为 chunkID 的文件块。
 * 返回拥有这个文件块的所有用户的 ID 所构成的列表或数组，按升序排列
 */
public class FileSharing {
    public FileSharing(int m) {

    }

    public int join(List<Integer> ownedChunks) {
        return 0;
    }

    public void leave(int userID) {

    }

    public List<Integer> request(int userID, int chunkID) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        // 我们用该系统分享由 4 个文件块组成的文件。
        FileSharing fileSharing = new FileSharing(4);
        // 一个拥有文件块 [1,2] 的用户加入系统，为其注册 id = 1 并返回 1。
        fileSharing.join(Arrays.asList(1, 2));
        // 一个拥有文件块 [2,3] 的用户加入系统，为其注册 id = 2 并返回 2。
        fileSharing.join(Arrays.asList(2, 3));
        // 一个拥有文件块 [4] 的用户加入系统，为其注册 id = 3 并返回 3。
        fileSharing.join(Arrays.asList(4));
        // id = 1 的用户请求第 3 个文件块，只有 id = 2 的用户拥有文件块，返回 [2] 。注意，现在用户 1 现拥有文件块 [1,2,3]。
        fileSharing.request(1, 3);
        // id = 2 的用户请求第 2 个文件块，id 为 [1,2] 的用户拥有该文件块，所以我们返回 [1,2] 。
        fileSharing.request(2, 2);
        // id = 1 的用户离开系统，其所拥有的所有文件块不再对其他用户可用。
        fileSharing.leave(1);
        // id = 2 的用户请求第 1 个文件块，系统中没有用户拥有该文件块，所以我们返回空列表 [] 。
        fileSharing.request(2, 1);
        // id = 2 的用户离开系统。
        fileSharing.leave(2);
        // 一个不拥有任何文件块的用户加入系统，为其注册 id = 1 并返回 1 。注意，id 1 和 2 空闲，可以重新使用。
        fileSharing.join(new ArrayList<>());

    }
}

