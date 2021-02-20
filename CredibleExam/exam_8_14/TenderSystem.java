package CredibleExam.exam_8_14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname TenderSystem
 * @Description TODO
 * @Date 2020/8/22 20:05
 * @Created by Administrator
 * addTender 金额和项目录入系统，已存在，则忽略。。三个参数都要
 * key:userId+projectId
 * <p>
 * updateTender ren+project存在则更新，并返回更新前的，否则-1；
 * key:userId+projectId
 * <p>
 * removeTender ren+project 存在则删除，并返回删除前的，否则返回-1；
 * key：userId+projectId
 * <p>
 * queryTender 返回项目 金额大于xx的，且最接近的userId，如果金额相同，则返回时间最早的。
 * 否则返回-1
 * key:projectId
 * process:price+time
 * return userId
 * 又和key：userId+projectId要同步数据
 * <p>
 * userId+projectId price
 * userId+projectId time
 * projectId List userId+projectId
 * <p>
 * 故系统需要存人，金额，项目，时间
 * <p>
 * 1<=userId<=10^4
 * 1<=projectId<=10^6
 * 1<=price<=10^8
 * crud累计操作数<=1000
 */
public class TenderSystem {
    public static void main(String[] args) {
        TenderSystem self=new TenderSystem();
        self.addTender(1,1,10);
        self.addTender(2,2,20);
        self.addTender(2,2,30);
        System.out.println(self.updateTender(1,1,40));
        System.out.println(self.updateTender(1,3,40));
        System.out.println(self.removeTender(1,1));
        System.out.println(self.removeTender(1,3));
        self.addTender(1,2,20);
        self.addTender(3,2,10);
        self.addTender(4,2,40);
        System.out.println(self.queryTender(2,15));
        System.out.println(self.queryTender(5,10));
        System.out.println("=============");

        TenderSystem self2=new TenderSystem();
        self2.addTender(1,1,10);
        self2.addTender(2,1,20);
        System.out.println(self2.updateTender(1,1,20));
        System.out.println(self2.queryTender(1,10));

    }

    private Map<String, Integer> recordPriceMap;
    private Map<String, Integer> recordTimeMap;
    private Map<Integer, ArrayList<String>> projectMap;

    private int invokeTime;
    private static final int ERROR_CODE = -1;

    public TenderSystem() {
        recordPriceMap = new HashMap<>();
        recordTimeMap = new HashMap<>();
        projectMap = new HashMap<>();
        invokeTime = 0;
    }

    private void addProjectMap(int projectId, String key) {
        ArrayList<String> list;
        if (projectMap.containsKey(projectId)) {
            list = projectMap.get(projectId);
        } else {
            list = new ArrayList<>();
        }
        list.add(key);
        projectMap.put(projectId, list);
    }

    private void removeProjectMap(int projectId, String key) {
        if (projectMap.containsKey(projectId)) {
            ArrayList<String> list = projectMap.get(projectId);
            list.remove(key);
            projectMap.put(projectId, list);
        }
    }

    public void addTender(int userId, int projectId, int price) {
        String key = userId + ":" + projectId;
        if (!recordPriceMap.containsKey(key)) {
            recordPriceMap.put(key, price);
            recordTimeMap.put(key, invokeTime);
            addProjectMap(projectId, key);
            invokeTime++;
        }
    }

    public int updateTender(int userId, int projectId, int price) {
        int res = ERROR_CODE;
        String key = userId + ":" + projectId;
        if (recordPriceMap.containsKey(key)) {
            res = recordPriceMap.get(key);
            recordTimeMap.put(key, invokeTime);
            invokeTime++;
        }
        return res;
    }

    public int removeTender(int userId, int projectId) {
        int res = ERROR_CODE;
        String key = userId + ":" + projectId;
        if (recordPriceMap.containsKey(key)) {
            res = recordPriceMap.get(key);
            recordPriceMap.remove(key);
            recordTimeMap.remove(key);
            removeProjectMap(projectId, key);
        }
        return res;
    }

    public int queryTender(int projectId, int price) {
        int res = ERROR_CODE;
        ArrayList<String> projects = projectMap.get(projectId);
        int minPrice = Integer.MAX_VALUE;
        int minTime = Integer.MAX_VALUE;
        String projectUser = "";
        if (projects == null) {
            return res;
        }
        for (String project : projects) {
            int priceValue = recordPriceMap.get(project);
            int timeValue = recordTimeMap.get(project);
            if (priceValue > price) {
                if (chargePriceAndTime(minPrice, minTime, priceValue, timeValue)) {
                    minPrice = priceValue;
                    projectUser = project;
                    minTime = timeValue;
                }
            }
        }
        if(!projectUser.isEmpty()){
            res=Integer.valueOf(projectUser.split(":")[0]);
        }
        return res;
    }

    private boolean chargePriceAndTime(int minPrice, int minTime, int priceValue, int timeValue) {
        return priceValue < minPrice || priceValue == minPrice && timeValue < minTime;
    }

}
