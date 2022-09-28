package codes.ADT.constructors;

import codes.ADT.Matrix;

public class printMtrxConsole {
    public static void printMatrix(Matrix matrix) {
        // I.S. Matrix terdefinisi
        // F.S. Matrix tercetak di layar
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
        for (int i = 0;  i < x.length ; i++){
            println("x"+(i+1)+": "+x[i]+"\n");
        }
    }

    public static void printf(String format, Object args){
        System.out.printf(format, args);
    }
    
    public static void print(String str){
        System.out.print(str);
    }

    public static void println(String str){
        System.out.println(str);
    }
}
