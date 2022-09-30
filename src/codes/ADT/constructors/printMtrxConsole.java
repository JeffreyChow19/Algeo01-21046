package codes.ADT.constructors;

import codes.ADT.Matrix;


public class printMtrxConsole {
    public static void printMatrix(Matrix matrix) {
        int i, j;
        for (i = 0; i < matrix.Mtrx.length; i++) {
            for (j = 0; j < matrix.Mtrx[i].length; j++) {
                // Potential error here
                if (matrix.Mtrx[i][j] <= (-0.0) && matrix.Mtrx[i][j] >= -0.00009) {
                    matrix.Mtrx[i][j] = 0;
                }
                printf("%7.2f", matrix.Mtrx[i][j]);
            }
            print("\n");
        }
    }

    public static void printMatrix(double[] x) {
        for (int i = 0; i < x.length; i++) {
            println("X" + (i + 1) + " : " + x[i] + "\n");
        }
    }

    public static void printLine(String args, double x) {
        printf(args + " : %.5f ", x);
    }

    public static void printFx(double[] ans, double result, double x, String args) {
        print("f(x) = ");
        for (int i = ans.length - 1; i >= 0; i--) {
            String current_power = i + "";
            if (ans[i] >= 0) {
                if (i == ans.length - 1) {
                    printf("%.5f" + "X" + current_power + "", ans[i]);
                } else {
                    if (i == 0) {
                        printf("+%.5f", ans[i]);
                    } else {
                        printf("+%.5f" + "X" + current_power + "", ans[i]);
                    }
                }
            } else {
                if (i == ans.length - 1) {
                    printf("%.5f" + "X" + current_power + "", ans[i]);
                } else {
                    if (i == 0) {
                        printf("%.5f", ans[i]);
                    } else {
                        printf("%.5f" + "X" + current_power + "", ans[i]);
                    }
                }
            }
        }
        
        print("\n");
        if (args != "no_args"){
            System.out.printf(args + " : %.5f", result);
        }
    }

    public static void printf(String format, Object args) {
        System.out.printf(format, args);
    }

    public static void print(String str) {
        System.out.print(str);
    }

    public static void println(String str) {
        System.out.println(str);
    }
}
