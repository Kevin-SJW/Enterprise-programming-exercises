package CredibleExam.exam_11_20;

import java.util.*;

/**
 * @Classname VendingMachineSystem3
 * @Description TODO
 * @Date 2020/12/5 0:00
 * @Created by Administrator
 * 设计一款自动售货机的进出管理系统
 * trayNum个商品轨道，每个商品轨道上最多可放置trayCapacity个商品，对已售空的轨道可以加入某一品牌的商品，
 * 即不一定是原品牌；
 * <p>
 * 输入 [[2,5],[3,[3,5,4,6,2]],[3,3],[]]
 * 输出 [null,true,[3,5,4],[6]]
 */
public class VendingMachineSystem3 {
    private int trayNum;
    private int trayCapacity;
    TreeMap<Integer, LinkedList<Integer>> machine;

    public VendingMachineSystem3(int trayNum, int trayCapacity) {
        this.trayNum=trayNum;
        this.trayCapacity=trayCapacity;
        machine = new TreeMap<>(Comparator.comparingInt(o -> o));
    }

    public boolean addProduct(int brandId, int[] productIdList) {
        if (machine.containsKey(brandId)) {
            LinkedList<Integer> products = machine.get(brandId);
            if (products.size() + productIdList.length <= trayCapacity) {
                for (int item : productIdList) {
                    products.add(item);
                }
                machine.put(brandId, products);
                return true;
            } else {
                return false;
            }
        } else {
            if (machine.size() < trayNum) {
                LinkedList<Integer> products = new LinkedList<>();
                for (int item : productIdList) {
                    products.add(item);
                }
                machine.put(brandId, products);
                return true;
            } else {
                return false;
            }
        }
    }

    public int[] buyProduct(int brandId, int num) {
        int[] res = new int[num];
        if (machine.containsKey(brandId)) {
            LinkedList<Integer> products = machine.get(brandId);
            if (products.size() >= num) {
                for (int i = 0; i < num; i++) {
                    res[i] = products.removeFirst();
                }
                if(products.size()==0){
                    machine.remove(brandId);
                }else{
                    machine.put(brandId,products);
                }
                return res;
            } else {
                return new int[]{};
            }
        } else {
            return new int[]{};
        }
    }

    public int[] queryProduct() {
        int[] res = new int[machine.size()];
        if (machine.size() == 0) {
            return new int[]{};
        } else {

            int index = 0;
//            List<Integer> brandList = new ArrayList<>();
            for (Map.Entry<Integer, LinkedList<Integer>> entry : machine.entrySet()) {
                res[index++]=entry.getValue().peekFirst();
//                int brandId = entry.getKey();
//                brandList.add(brandId);
            }
//            Collections.sort(brandList);
//            for (int i = 0; i < brandList.size(); i++) {
//                int val=machine.get(brandList.get(i)).getFirst();
//                res[index] = val;
//                index++;
//            }
        }
        return res;
    }

    public static void main(String[] args) {
        VendingMachineSystem3 obj = new VendingMachineSystem3(2, 5);
        int[] value = {3, 5, 4, 6, 2};
        System.out.println(obj.addProduct(3, value));
        Arrays.stream(obj.buyProduct(3, 3)).forEach(t -> System.out.print(t + " "));
        List<Integer> res = new ArrayList<>();
        System.out.println();
        for (int num : obj.queryProduct()) {
            res.add(num);
        }
        res.stream().forEach(t -> System.out.print(t + " "));
    }
}
