package ClassificationTraining.Search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname BigPackage
 * @Description TODO
 * @Date 2020/8/12 0:22
 * @Created by Administrator
 * 在LeetCode商店中， 有许多在售的物品。
 * 然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
 * 现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。
 * 每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。
 * 大礼包
 */
public class BigPackage {
    //回溯组合排列算法练习；
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special,
                              List<Integer> needs) {
        int res=0;
        //先不用sp；
        for(int i=0;i<needs.size();i++){
            res+=(needs.get(i)*price.get(i));
        }
        //sp;
        for(List<Integer> sp:special){
            if(check(sp,needs)){
                List<Integer> newNeed=new ArrayList<>();
                for(int i=0;i<needs.size();i++){
                    newNeed.add(needs.get(i)-sp.get(i));
                }
                //有点全排列的味道所以可以直接special而不用再更新；
                res=Math.min(res,sp.get(sp.size()-1)
                        +shoppingOffers(price,special,newNeed));
            }
        }
        return res;
    }
    private boolean check(List<Integer> sp, List<Integer> need){
        int i=0;
        for(int num:need){
            if(sp.get(i++) > num){
                return false;
            }
        }
        return true;
    }

}
