package HighConcurrency.CompletableFuture;


import java.util.function.Supplier;

/**
 * @Classname QuerySupplier
 * @Description TODO
 * @Date 2020/3/3 17:50
 * @Created by 14241
 */
public class QuerySupplier implements Supplier<String> {
    private Integer id;
    private String type;
    private HighConcurrency.CompletableFuture.QueryUtils queryUtils;
    public QuerySupplier(Integer id, String type, HighConcurrency.CompletableFuture.QueryUtils queryUtils) {
        this.id = id;
        this.type = type;
        this.queryUtils=queryUtils;
    }
    @Override
    public String get() {
        if("home".equals(type)){
            return queryUtils.queryHome(id);
        }else if ("job".equals(type)){
            return queryUtils.queryJob(id);
        }else if ("car".equals(type)){
            return queryUtils.queryCar(id);
        }
        return null;
    }
}
