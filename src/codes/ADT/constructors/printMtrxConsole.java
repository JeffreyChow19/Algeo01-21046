package codes.ADT.constructors;

import codes.ADT.Matrix;
import codes.ADT.Param;

public class printMtrxConsole {
    public static void printMatrix(Matrix matrix) {
        int i, j;
        for (i = 0; i < matrix.Mtrx.length; i++) {
            for (j = 0; j < matrix.Mtrx[i].length; j++) {
                // Potential error here
                if (matrix.Mtrx[i][j] <= (-0.0) && matrix.Mtrx[i][j] >= -0.00009) {
                    matrix.Mtrx[i][j] = 0;
                }
                printf("%10.7f", matrix.Mtrx[i][j]);
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

    public static void printParam(Param[] args) {
        for (int i = 0; i < args.length; i++) {
            boolean before = false;
            
            System.out.printf("X%d = ", i + 1);

            if (args[i].val != 0){
                System.out.printf("%.2f", args[i].val);
                before = true;
            }

            for (int j = 0; j < args[i].params.length; j++){
                if (args[i].valPar[j] != 0 ) {
                    if (before && args[i].valPar[j]>=0){
                        print(" + ");
                    } else {
                        print(" ");
                    }

                    if (args[i].valPar[j] != 1){
                        System.out.printf("%.2f%s", args[i].valPar[j], args[i].params[j]);  
                    } else {
                        System.out.printf("%s", args[i].params[j]);
                    }

                    before = true;
                }

                if (j == args[i].params.length - 1) {
                    print("\n");
                }
            }
        }
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
            System.out.printf(args + " = %.5f", result);
        }
    }

    public static void printFxV2(double[] ans, double result, double x, String args) {
        print("f(x) = ");
        for (int i = 0; i < ans.length; i++) {
            String current_power = i + "";
            if (ans[i] >= 0) {
                if (i == 0) {
                    printf("%.5f", ans[i]);
                } else {
                    printf("+%.5f" + "X" + current_power + "", ans[i]);
                }
            } else {
                if (i == 0) {
                    printf("%.5f", ans[i]);
                } else {
                    printf("%.5f" + "X" + current_power + "", ans[i]);
                }
            }
        }
        
        print("\n");
        if (args != "no_args"){
            System.out.printf(args + " = %.5f", result);
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
