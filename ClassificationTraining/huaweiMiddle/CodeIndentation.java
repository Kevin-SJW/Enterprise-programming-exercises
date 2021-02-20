package ClassificationTraining.huaweiMiddle;

/**
 * 模拟一个代码缩进的功能
 */
public class CodeIndentation {
    public static void main(String[] args) {
        int[] steps = {1, 2, 3, 2, 1};
        System.out.println(getMinStep(steps));
    }

    public static int getMinStep(int[] steps) {
        int tabs = steps[0];
        for (int i = 1; i < steps.length - 1; i++) {
            if (steps[i + 1] > steps[i]) {
                tabs += steps[i + 1] - steps[i];
            }
        }
        return tabs;
    }
}
