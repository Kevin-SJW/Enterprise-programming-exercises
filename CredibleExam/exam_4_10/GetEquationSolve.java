package CredibleExam.exam_4_10;

/**
 * @Classname GetEquationSolve
 * @Description TODO
 * @Date 2020/7/28 23:27
 * @Created by Administrator
 * 求解一个用字符串equation表示的一元二次方程，求解
 * Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, the variable x and its coefficient.
 * <p>
 * If there is no solution for the equation, return "No solution".
 * <p>
 * If there are infinite solutions for the equation, return "Infinite solutions".
 * <p>
 * If there is exactly one solution for the equation, we ensure that the value of x is an integer.
 */
public class GetEquationSolve {
    public static void main(String[] args) {
        String eqation = "x+5-3+x=6+x-2";
        System.out.println(solveEquation(eqation));
    }
    public static double solveEquation(String eqution) {
        String newEquation = eqution.replace("-", "+-");
        String[] leftEquation = newEquation.split("=")[0].split("\\+");
        String[] rightEquation = newEquation.split("=")[1].split("\\+");

        int[] left = helper(leftEquation);
        int[] right = helper(rightEquation);
        int xVal = left[0] - right[0];
        int constVal = right[1] - left[1];
        return (double) constVal / xVal;

    }
    private static int[] helper(String[] equation) {
        int constVal = 0;
        int val = 0;
        for (String left : equation) {
            //如果是未知数
            if (!left.isEmpty()) {
                if (Character.isLetter(left.charAt(left.length() - 1))) {
                    try {
                        val += Integer.parseInt(left.substring(0, left.length() - 1));
                    } catch (NumberFormatException e) {
                        //如果抛出异常，则是-a,a这种情况
                        val += left.charAt(0) == '-' ? -1 : 1;
                    }
                } else {

                    constVal += Integer.parseInt(left);
                }
            }
        }
        return new int[]{val, constVal};

    }

}
