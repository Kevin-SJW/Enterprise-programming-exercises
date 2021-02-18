package ClassificationTraining.huaweiSimple;

/**
 * 请你给一个停车场设计一个停车系统。停车场总共有三种不同大小的车位：大，中和小，每种尺寸分别有固定数目的车位。
 * 请你实现 ParkingSystem 类：
 * ParkingSystem(int big, int medium, int small) 初始化 ParkingSystem 类，
 * 三个参数分别对应每种停车位的数目。
 * bool addCar(int carType) 检查是否有 carType 对应的停车位。 carType 有三种类型：大，中，小，
 * 分别用数字 1， 2 和 3 表示。一辆车只能停在  carType 对应尺寸的停车位中。如果没有空车位，
 * 请返回 false ，否则将该车停入车位并返回 true 。
 * 输入：
 * ["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
 * [[1, 1, 0], [1], [2], [3], [1]]
 * 输出：
 * [null, true, true, false, false]
 */
public class ParkingSystem {
    int big;
    int medium;
    int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            if (this.big >= 1) {
                this.big -= 1;
                return true;
            } else {
                return false;
            }
        } else if (carType == 2) {
            if (this.medium >= 1) {
                this.medium -= 1;
                return true;
            } else {
                return false;
            }
        } else {
            if (this.small >= 1) {
                this.small -= 1;
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1));
        // 返回 true ，因为有 1 个空的大车位
        System.out.println(parkingSystem.addCar(2));
        // 返回 true ，因为有 1 个空的中车位
        System.out.println(parkingSystem.addCar(3));
        // 返回 false ，因为没有空的小车位
        System.out.println(parkingSystem.addCar(1));
        // 返回 false ，因为没有空的大车位，唯一一个大车位已经被占据了


    }
}
