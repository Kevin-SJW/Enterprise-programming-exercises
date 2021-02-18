package ClassificationTraining.SpringSprint;

import java.util.*;

/**
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
 * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。
 * 那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，
 * 员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，
 * 因此没有体现在员工1的数据结构中。
 * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 */
public class EmployeeImportance {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1, 5, Arrays.asList(2, 3));
        Employee employee2 = new Employee(2, 3, Collections.emptyList());
        Employee employee3 = new Employee(3, 3, Collections.emptyList());
        List<Employee> list = Arrays.asList(employee1, employee2, employee3);
        int id = 1;
        System.out.println(getImportance(list, id));

    }

    private static int res = 0;
    public static int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        dfs(map, id);
        return res;
    }

    public static void dfs(Map<Integer, Employee> map, int id) {
        Employee e = map.get(id);
        if (e == null) return;

        res += e.importance;
        for (Integer subId : e.subordinates) {
            dfs(map, subId);
        }
    }
}

// Definition for Employee.
class Employee {
    public int id;

    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public List<Integer> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Integer> subordinates) {
        this.subordinates = subordinates;
    }
};

