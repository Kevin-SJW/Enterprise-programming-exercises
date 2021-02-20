package RateLimiting;

/**
 * @Classname RateLimiterExample
 * @Description TODO
 * @Date 2020/5/26 20:15
 * @Created by Administrator
 */
import com.google.common.util.concurrent.RateLimiter;

import java.time.Instant;

/**
 * Guava 实现限流
 */
public class RateLimiterExample {
    public static void main(String[] args) {
        // 每秒产生 10 个令牌（每 100 ms 产生一个）
        RateLimiter rt = RateLimiter.create(10);
        for (int i = 0; i < 11; i++) {
            new Thread(() -> {
                // 获取 1 个令牌
                rt.acquire();
                System.out.println("正常执行方法，ts:" + Instant.now());
            }).start();
        }
    }

//    从以上结果可以看出令牌确实是每 100ms 产生一个，而 acquire() 方法为阻塞等待获取令牌，
//    它可以传递一个 int 类型的参数，用于指定获取令牌的个数。它的替代方法还有 tryAcquire()，
//    此方法在没有可用令牌时就会返回 false 这样就不会阻塞等待了。当然 tryAcquire() 方法也可以设置超时时间，
//    未超过最大等待时间会阻塞等待获取令牌，如果超过了最大等待时间，还没有可用的令牌就会返回 false。
//
//    注意：使用 guava 实现的令牌算法属于程序级别的单机限流方案，而上面使用 Redis-Cell 的是分布式的限流方案
}
