package RateLimiting;

/**
 * @Classname RedisLimting
 * @Description 时间窗口算法
 * @Date 2020/5/26 20:06
 * @Created by Administrator
 */
import redis.clients.jedis.Jedis;

public class RedisLimiting {
    // Redis 操作客户端
    static Jedis jedis = new Jedis("127.0.0.1", 6379);


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 15; i++) {
            boolean res = isPeriodLimiting("java", 3, 10);
            if (res) {
                System.out.println("正常执行请求：" + i);
            } else {
                System.out.println("被限流：" + i);
            }
        }
        // 休眠 4s
        Thread.sleep(4000);
        // 超过最大执行时间之后，再从发起请求
        boolean res = isPeriodLimiting("java", 3, 10);
        if (res) {
            System.out.println("休眠后，正常执行请求");
        } else {
            System.out.println("休眠后，被限流");
        }
    }

    /**
     * 限流方法（滑动时间算法）
     * @param key      限流标识
     * @param period   限流时间范围（单位：秒）
     * @param maxCount 最大运行访问次数
     * @return
     */
    private static boolean isPeriodLimiting(String key, int period, int maxCount) {
        long nowTs = System.currentTimeMillis(); // 当前时间戳
        // 删除非时间段内的请求数据（清除老访问数据，比如 period=60 时，标识清除 60s 以前的请求记录）

        jedis.auth("yingjun");
        jedis.select(0);
        jedis.zremrangeByScore(key, 0, nowTs - period * 1000);
        long currCount = jedis.zcard(key); // 当前请求次数
        if (currCount >= maxCount) {
            // 超过最大请求次数，执行限流
            return false;
        }
        // 未达到最大请求数，正常执行业务
        jedis.zadd(key, nowTs, "" + nowTs); // 请求记录 +1
        return true;
    }

//    此实现方式存在的缺点有两个：
//
//    使用 ZSet 存储有每次的访问记录，如果数据量比较大时会占用大量的空间，比如 60s 允许 100W 访问时；
//    此代码的执行非原子操作，先判断后增加，中间空隙可穿插其他业务逻辑的执行，最终导致结果不准确。
}
