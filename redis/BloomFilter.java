package redis;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname BloomFilter
 * @Description TODO
 * @Date 2020/3/18 22:17
 * @Created by 14241
 */
public  class BloomFilter {

    private byte[] data;

    public BloomFilter(int initSize) {
        // 默认创建大小 * 2 的空间
        this.data = new byte[initSize * 2];
}

    public static void main(String[] args) {
        Random random = new Random();
        // 假设我们的数据有 1 百万
        int size = 1_000_000;
        // 用一个数据结构保存一下所有实际存在的值
        LinkedList<Integer> existentNumbers = new LinkedList<>();
        BloomFilter bloomFilter = new BloomFilter(size);

        for (int i = 0; i < size; i++) {
            int randomKey = random.nextInt();
            existentNumbers.add(randomKey);
            bloomFilter.add(randomKey);
        }

        // 验证已存在的数是否都存在
        AtomicInteger count = new AtomicInteger();
        AtomicInteger finalCount = count;
        existentNumbers.forEach(number -> {
            if (bloomFilter.contains(number)) {
                finalCount.incrementAndGet();
            }
        });
        System.out.printf("实际的数据量：%d, 判断存在的数据量: %d \n", size, count.get());
//        System.out.println(finalCount);

        // 验证10个不存在的数
        count = new AtomicInteger();
        while (count.get() < 10) {
            int key = random.nextInt();
            if (existentNumbers.contains(key)) {
                continue;
            } else {
                // 这里一定是不存在的数
                System.out.println(bloomFilter.contains(key));
                count.incrementAndGet();
            }
        }
    }

    public void add(int key) {
        int location1 = Math.abs(hash1(key) % data.length);
        int location2 = Math.abs(hash2(key) % data.length);
        int location3 = Math.abs(hash3(key) % data.length);

        data[location1] = data[location2] = data[location3] = 1;
    }

    public boolean contains(int key) {
        int location1 = Math.abs(hash1(key) % data.length);
        int location2 = Math.abs(hash2(key) % data.length);
        int location3 = Math.abs(hash3(key) % data.length);

        return data[location1] * data[location2] * data[location3] == 1;
    }

    private int hash1(Integer key) {
        return key.hashCode();
    }

    private int hash2(Integer key) {
        int hashCode = key.hashCode();
        return hashCode ^ (hashCode >>> 3);
    }

    private int hash3(Integer key) {
        int hashCode = key.hashCode();
        return hashCode ^ (hashCode >>> 16);
    }
}
