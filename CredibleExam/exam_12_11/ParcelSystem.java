package CredibleExam.exam_12_11;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname ParcelSystem
 * @Description TODO
 * @Date 2020/12/27 10:57
 * @Created by Administrator
 * 设计题，设计快递柜系统
 * 一共不多于十个快递区域（area），每个区域有小（‘0’）中（‘1’）大（‘2’）三种尺寸表示三种尺寸的格子
 * init:初始化快递系统，给定快递区域area以及该区域三个尺寸柜子数量，如果该area已经初始化了，则返回-1，
 * 否则初始化并返回1。
 * Deposit:存入快递，给定快递的ID，规定区域area，以及标准尺寸volume，因为要求全系统快递ID唯一，
 * 如果该ID已存在，则返回-1（这里要注意的是全系统）；如果该area不存在，也返回-1；
 * 如果该区域volume尺寸的柜子没有了，则可以依次存入比他大一个尺寸的柜子里，
 * 如果还是没得地方存，就返回-1，成功存入返回存放的volume.
 * Retrieve：取出快递，给定快递ID，如果该ID存在，则删除该快递的记录并返回1，如果不存在则返回-1.
 * QueryId：查询快递。给定快递ID，如果该ID存在，则返回该ID储存的area，如果不存在则返回-1；
 */
public class ParcelSystem {
    private Map<Integer, Map<Integer, Integer>> areaMap;
    private Map<Integer, String> idAreaMap;

    public ParcelSystem() {
        areaMap = new HashMap<>();
        idAreaMap = new HashMap<>();
    }

    public int init(int area, int[] volumeNumbers) {
        if (areaMap == null || areaMap.containsKey(area) || volumeNumbers.length != 3) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, volumeNumbers[0]);
        map.put(1, volumeNumbers[1]);
        map.put(2, volumeNumbers[2]);
        areaMap.put(area, map);
        return 1;
    }

    public int deposit(int id, int area, int volume) {
        if (areaMap == null || !areaMap.containsKey(area) || idAreaMap.containsKey(id)
                || volume < 0 | volume > 2) {
            return -1;
        }
        int savedVolume = 1;
        Map<Integer, Integer> volumeMap = areaMap.get(area);
        if (volumeMap.get(volume) > 0) {
            volumeMap.put(volume, volumeMap.get(volume) - 1);
            savedVolume = volume;
        } else if (volumeMap.containsKey(volume + 1) && volumeMap.get(volume + 1) > 0) {
            volumeMap.put(volume + 1, volumeMap.get(volume + 1) - 1);
            savedVolume = volume + 1;
        } else if (volumeMap.containsKey(volume + 2) && volumeMap.get(volume + 2) > 0) {
            volumeMap.put(volume + 2, volumeMap.get(volume + 2) - 1);
            savedVolume = volume + 2;
        }
        if (savedVolume == -1) {
            return -1;
        }
        areaMap.put(area, volumeMap);
        idAreaMap.put(id, area + "_" + savedVolume);
        return savedVolume;
    }

    public int retrieve(int id) {
        if (areaMap == null || idAreaMap == null || !idAreaMap.containsKey(id)) {
            return -1;
        }
        String[] areas = idAreaMap.get(id).split("_");
        Integer area = Integer.valueOf(areas[0]);
        Integer volume = Integer.valueOf(areas[1]);
        Map<Integer, Integer> volumeMap = areaMap.get(area);

        volumeMap.put(volume, volumeMap.get(volume) + 1);
        areaMap.put(area, volumeMap);
        idAreaMap.remove(id);
        return 1;
    }

    public int queryId(int id) {
        if (areaMap == null || idAreaMap == null || !idAreaMap.containsKey(id)) {
            return -1;
        }
        String[] areas = idAreaMap.get(id).split("_");
        return Integer.valueOf(areas[0]);
    }

    public static void main(String[] args) {
        ParcelSystem p = new ParcelSystem();
        int[] volumeNumbers = {3, 4, 1};
        System.out.println(p.init(1, volumeNumbers));
//        System.out.println(p.deposit(3, 1, 2));
//        System.out.println(p.queryId(4));
//        System.out.println(p.retrieve(3));
        int[] volumeNumbers2 = {1, 1, 1};
        System.out.println(p.init(1, volumeNumbers2));
        System.out.println(p.deposit(3, 1, 2));
        System.out.println(p.deposit(3, 4, 2));
        System.out.println(p.deposit(2, 1, 2));
        System.out.println(p.deposit(4, 4, 0));
        System.out.println(p.queryId(3));
        System.out.println(p.queryId(4));
        System.out.println(p.retrieve(3));
        System.out.println(p.retrieve(1));
        int[] volumeNumbers3 = {2, 0, 2};
        System.out.println(p.deposit(5, 2, 0));
        System.out.println(p.deposit(7, 2, 0));
        System.out.println(p.deposit(6, 2, 0));
        System.out.println(p.deposit(8, 2, 0));
        System.out.println(p.deposit(9, 2, 0));
        System.out.println(p.retrieve(5));
        System.out.println(p.deposit(9, 2, 0));

    }
}
