package HighConcurrency.CompletableFuture;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @Classname FutureTaskTest
 * @Description TODO
 * @Date 2020/3/3 17:59
 * @Created by 14241
 */
public class FutureTaskTest {
    public static void main(String[] args) {

        long begin= System.currentTimeMillis();
        //多线程环境需要注意线程安全问题
        List<HighConcurrency.CompletableFuture.UserInfo> userInfoList= Collections.synchronizedList(new ArrayList<>());
        for(int i=0;i<=20;i++){
            HighConcurrency.CompletableFuture.UserInfo userInfo=new HighConcurrency.CompletableFuture.UserInfo();
            userInfo.setId(i);
            userInfo.setName("username"+i);
            userInfo.setCarId(i);
            userInfo.setJobId(i);
            userInfo.setHomeId(i);
            userInfoList.add(userInfo);
        }

        FutureTaskTest futureTaskTest=new FutureTaskTest();
        //stream 查询一个用户花费3s  并行计算后一个用户1秒左右 查询21个用户花费21秒
        //parallelStream 速度更慢
        userInfoList.stream()
                .map(userInfo->{
//                    QueryUserService queryUserService=new QueryUserService();
                    userInfo =futureTaskTest.converUserInfo2(userInfo);
                    return userInfo;
                }).collect(Collectors.toList());
        System.out.println("=============");
        long end=System.currentTimeMillis();
        System.out.println(end-begin);
    }

    private Supplier<HighConcurrency.CompletableFuture.QueryUtils> queryUtilsSupplier = HighConcurrency.CompletableFuture.QueryUtils::new;

    private Map<String,FutureTask<String>> futureMap=new HashMap<>();
    /**
     * 使用 FutureTask 来优化查询
     *
     * @param userInfo
     * @return
     */

    public HighConcurrency.CompletableFuture.UserInfo converUserInfo2(HighConcurrency.CompletableFuture.UserInfo userInfo) {
        Callable<String> homeCallable=new Callable() {
            @Override
            public Object call() throws Exception {
                return queryUtilsSupplier.get().queryHome(userInfo.getHomeId());
            }
        };
        FutureTask<String> getHomeDesc=new FutureTask<>(homeCallable);
        new Thread(getHomeDesc).start();
        futureMap.put("homeCallable",getHomeDesc);
        Callable<String> carCallable=new Callable() {
            @Override
            public Object call() throws Exception {
                return queryUtilsSupplier.get().queryCar(userInfo.getCarId());
            }
        };
        FutureTask<String> getCarDesc=new FutureTask(carCallable);
        new Thread(getCarDesc).start();
        futureMap.put("carCallable",getCarDesc);
        Callable<String> jobCallable=new Callable() {
            @Override
            public Object call() throws Exception {
                return queryUtilsSupplier.get().queryCar(userInfo.getJobId());
            }
        };
        FutureTask<String> getJobDesc=new FutureTask<>(jobCallable);
        new Thread(getJobDesc).start();
        futureMap.put("jobCallable",getJobDesc);
        try {
            //—1代码在执行的时候遇到了堵塞，然后—2和—3的get也需要进行等待，
            // 因此使用常规的futuretask进行优化，这里难免还是会有堵塞的情况。
            //-1
            userInfo.setHomeDes( futureMap.get("homeCallable").get());
            //-2
            userInfo.setCarDes(futureMap.get("carCallable").get());
            //-3
            userInfo.setJobDes(futureMap.get("jobCallable").get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("该对象完成查询" );
        return userInfo;
    }
}
