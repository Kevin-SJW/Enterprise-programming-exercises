package CredibleExam.exam_4_10;

/**
 * @Classname GetEquationSolve2
 * @Description TODO
 * @Date 2020/8/2 17:21
 * @Created by Administrator
 */
public class GetEquationSolve2 {
    public static void main(String[] args) {
        String equation = "x+5-3+x=6+x-2";
        System.out.println(solveEquation(equation));
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
        int xVal = 0;
        for (String left : equation) {
            if (!left.isEmpty()) {
                if (Character.isLetter(left.charAt(left.length() - 1))) {
                    try {
                        xVal += Integer.parseInt(left.substring(0, left.length() - 1));
                    } catch (NumberFormatException e) {
                        //如果抛出异常，则是-a,a这种情况
                        xVal += left.charAt(0) == '-' ? -1 : 1;
                    }
                } else {
                    constVal += Integer.parseInt(left);
                }

            }
        }
        return new int[]{xVal, constVal};
    }
}
