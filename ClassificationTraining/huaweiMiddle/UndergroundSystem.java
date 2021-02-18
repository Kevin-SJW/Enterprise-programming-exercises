package ClassificationTraining.huaweiMiddle;

import java.util.HashMap;
import java.util.Map;

/**

 * 请你实现一个类 UndergroundSystem ，它支持以下 3 种方法：
 * 1. checkIn(int id, string stationName, int t)
 * 编号为 id 的乘客在 t 时刻进入地铁站 stationName 。
 * 一个乘客在同一时间只能在一个地铁站进入或者离开。
 * 2. checkOut(int id, string stationName, int t)
 * 编号为 id 的乘客在 t 时刻离开地铁站 stationName 。
 * 3. getAverageTime(string startStation, string endStation) 
 * 返回从地铁站 startStation 到地铁站 endStation 的平均花费时间。
 * 平均时间计算的行程包括当前为止所有从 startStation 直接到达 endStation 的行程。
 * 调用 getAverageTime 时，询问的路线至少包含一趟行程。
 * 你可以假设所有对 checkIn 和 checkOut 的调用都是符合逻辑的。也就是说，
 * 如果一个顾客在 t1 时刻到达某个地铁站，那么他离开的时间 t2 一定满足 t2 > t1 。所有的事件都按时间顺序给出。
 */
public class UndergroundSystem {
    // 站台信息
    private class Station {
        private Map<Integer, Integer> in = new HashMap<>();
        private Map<Integer, Integer> out = new HashMap<>();
    }
    // K是站名，V是站台出入信息
    private Map<String, Station> stationMap;
    public UndergroundSystem() {
        stationMap = new HashMap<>();
    }
    public void checkIn(int id, String stationName, int t) {
        // 获取站台信息
        Station station = stationMap.getOrDefault(stationName, new Station());
        // 保存进站人id及其时间
        station.in.put(id, t);
        // 保存站台信息
        stationMap.put(stationName, station); }
    public void checkOut(int id, String stationName, int t) {
        // 同checkIn
        Station station = stationMap.getOrDefault(stationName, new Station());
        // 出站
        station.out.put(id, t);
        stationMap.put(stationName, station); }
    public double getAverageTime(String startStation, String endStation) {
        Station start = stationMap.get(startStation);
        Station end = stationMap.get(endStation);
        // 起点站的进站人id及其时间
        Map<Integer, Integer> in = start.in;
        // 终点站的出站人id及其时间
        Map<Integer, Integer> out = end.out;
        float total = 0;
        int num = 0;
        // 遍历进站的人
        for (int id : in.keySet()) {
            if (out.containsKey(id)) {
                // 编号为id的人从endStation出站  // 总时间和总人数增加
                total += out.get(id) - in.get(id);
                ++num;
            }// 未出站的人不能算平均时间
        }
        return total / num;
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));;       // 返回 14.0。从 "Paradise"（时刻 8）到 "Cambridge"(时刻 22)的行程只有一趟
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));;          // 返回 11.0。总共有 2 躺从 "Leyton" 到 "Waterloo" 的行程，编号为 id=45 的乘客出发于 time=3 到达于 time=15，编号为 id=27 的乘客于 time=10 出发于 time=20 到达。所以平均时间为 ( (15-3) + (20-10) ) / 2 = 11.0
        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));;          // 返回 11.0
        undergroundSystem.checkOut(10, "Waterloo", 38);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));;          // 返回 12.0

    }
}

