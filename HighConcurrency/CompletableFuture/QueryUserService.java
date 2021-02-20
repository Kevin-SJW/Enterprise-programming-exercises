package HighConcurrency.CompletableFuture;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @Classname QueryUserService
 * @Description TODO
 * @Date 2020/3/3 17:51
 * @Created by 14241
 */
public class QueryUserService {
    private Supplier<HighConcurrency.CompletableFuture.QueryUtils> queryUtilsSupplier = HighConcurrency.CompletableFuture.QueryUtils::new;
    public HighConcurrency.CompletableFuture.UserInfo converUserInfo(HighConcurrency.CompletableFuture.UserInfo userInfo) {
        HighConcurrency.CompletableFuture.QuerySupplier querySuppiler1 = new HighConcurrency.CompletableFuture.QuerySupplier(userInfo.getCarId(), "car", queryUtilsSupplier.get());
        CompletableFuture<String> getCarDesc = CompletableFuture.supplyAsync(querySuppiler1);
        //--1
        getCarDesc.thenAccept(carDesc -> userInfo.setCarDes(carDesc));

        HighConcurrency.CompletableFuture.QuerySupplier querySuppiler2 = new HighConcurrency.CompletableFuture.QuerySupplier(userInfo.getHomeId(), "home", queryUtilsSupplier.get());
        CompletableFuture<String> getHomeDesc = CompletableFuture.supplyAsync(querySuppiler2);
        //--2
        getHomeDesc.thenAccept(homeDesc -> userInfo.setHomeDes(homeDesc));

        HighConcurrency.CompletableFuture.QuerySupplier querySuppiler3 = new HighConcurrency.CompletableFuture.QuerySupplier(userInfo.getJobId(), "job", queryUtilsSupplier.get());
        CompletableFuture<String> getJobDesc = CompletableFuture.supplyAsync(querySuppiler3);
        //--3
        getJobDesc.thenAccept(jobDesc -> userInfo.setJobDes(jobDesc));

        CompletableFuture<Void> getUserInfo = CompletableFuture.allOf(getCarDesc, getHomeDesc, getJobDesc);
        getUserInfo.thenAccept(result -> System.out.println("全部完成查询" ));

        //--4
        getUserInfo.join();
        return userInfo;
    }
    public static void main(String[] args) {
        long begin= System.currentTimeMillis();
        System.out.println("begin"+begin);
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
        //stream 查询一个用户花费3s  并行计算后一个用户1秒左右 查询21个用户花费21秒
        //parallelStream 速度更慢
        userInfoList.stream()
                .map(userInfo->{
                    QueryUserService queryUserService=new QueryUserService();
                    userInfo =queryUserService.converUserInfo(userInfo);
                    return userInfo;
                }).collect(Collectors.toList());
        System.out.println("=============");
        long end=System.currentTimeMillis();
        System.out.println("end"+end);
        System.out.println(end-begin);
    }
}
