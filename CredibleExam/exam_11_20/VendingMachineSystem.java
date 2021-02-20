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
 *
 * 输入 [[2,5],[3,[3,5,4,6,2]],[3,3],[]]
 * 输出 [null,true,[3,5,4],[6]]
 *
 */
public class VendingMachineSystem {
    private int trayNum;

    private int trayCapacity;

    private TreeMap<Integer, LinkedList<Integer>> machine;

    public VendingMachineSystem(int trayNum, int trayCapacity) {
        this.trayNum = trayNum;
        this.trayCapacity = trayCapacity;
        machine = new TreeMap<>(Comparator.comparingInt(Integer::intValue));
    }

    public boolean addProduct(int brandId, int[] productIdList) {
        LinkedList<Integer> tray = machine.get(brandId);
        if (null == tray) {
            if (machine.size() >= trayNum) {
                return false;
            }
            tray = new LinkedList<>();
        }
        if (tray.size() + productIdList.length > trayCapacity) {
            return false;
        }
        for (int i = 0; i < productIdList.length; i++) {
            tray.add(productIdList[i]);
        }
        machine.put(brandId, tray);
        return true;
    }

    public int[] buyProduct(int brandId, int num) {
        LinkedList<Integer> tray = machine.get(brandId);
        if (null == tray || tray.size() < num) {
            return new int[0];
        }
        int[] res = new int[num];
        for (int i = 0; i < num; i++) {
            res[i] = tray.pollFirst();
        }
        if (tray.size() == 0) {
            machine.remove(brandId);
        }
        return res;
    }

    public int[] queryProduct() {
        int[] res = new int[machine.size()];
        int index = 0;
        for (Map.Entry<Integer, LinkedList<Integer>> entry : machine.entrySet()) {
            res[index++] = entry.getValue().peekFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        VendingMachineSystem obj=new VendingMachineSystem(2,5);
        int[] value={3,5,4,6,2};
        System.out.println(obj.addProduct(3,value));
        Arrays.stream(obj.buyProduct(3, 3)).forEach(t-> System.out.print(t+" "));
        List<Integer> res=new ArrayList<>();
        System.out.println();
        for(int num:obj.queryProduct()){
            res.add(num);
        }
        res.stream().forEach(t-> System.out.print(t+" "));
    }
}
