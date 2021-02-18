package CredibleExam.exam_11_20;

import java.util.*;

/**
 * @Classname VendingMachineSystem
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
public class VendingMachineSystem2 {
    private int trayNum;

    private int capacity;

    private TreeMap<Integer, LinkedList<Integer>> machine;

    public VendingMachineSystem2(int trayNum, int trayCapacity) {
        this.trayNum = trayNum;
        this.capacity = trayCapacity;
        machine = new TreeMap<>(Comparator.comparingInt(Integer::intValue));
    }

    public boolean addProduct(int brandId, int[] productIdList) {
        if (machine.containsKey(brandId)) {
            if (capacity - machine.get(brandId).size() >= productIdList.length) {
                Arrays.sort(productIdList);
                LinkedList<Integer> list = new LinkedList<>();
                for (int num : productIdList) {
                    list.addLast(num);
                }
                return true;
            } else {
                return false;
            }
        } else {
            if (machine.size() < trayNum && capacity >= productIdList.length) {
                LinkedList<Integer> tempList = new LinkedList<>();
                for (int i = 0; i < productIdList.length; i++) {
                    tempList.addLast(productIdList[i]);
                }
                machine.put(brandId, tempList);
                return true;
            } else {
                return false;
            }
        }
    }

    public int[] buyProduct(int brandId, int num) {
        if (machine.containsKey(brandId)) {
            LinkedList<Integer> temp = machine.get(brandId);
            if (temp.size() >= num) {
                int[] brandResult = new int[num];
                for (int i = 0; i < num; i++) {
                    brandResult[i] = temp.removeFirst();
                }
                if (temp.size() == 0) {
                    machine.remove(brandId);
                } else {
                    machine.put(brandId, temp);
                }
                return brandResult;
            } else {
                return new int[]{};
            }
        } else {
            return new int[]{};
        }
    }

    public int[] queryProduct() {
        int[] res = new int[machine.size()];
        int index = 0;
        for (Map.Entry<Integer, LinkedList<Integer>> entry : machine.entrySet()) {
            res[index++] = entry.getValue().peekFirst();
        }
        return res;
//        if (machine.size() == 0) {
//            return new int[]{};
//        }
//        List<Integer> brandIdList = new ArrayList<>();
//        List<Integer> res = new ArrayList<>();
//        for (Map.Entry<Integer, LinkedList<Integer>> entry : machine.entrySet()) {
//            brandIdList.add(entry.getKey());
//        }
//        Collections.sort(brandIdList);
//        for (int i = 0; i < brandIdList.size(); i++) {
//            int brandId = brandIdList.get(i);
//            if (machine.get(brandId).size() != 0) {
//                res.add(machine.get(brandId).peekFirst());
//            }
//        }
//        return res.stream().mapToInt(Integer::valueOf).toArray();

    }

    public static void main(String[] args) {
        VendingMachineSystem2 obj = new VendingMachineSystem2(2, 5);
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
