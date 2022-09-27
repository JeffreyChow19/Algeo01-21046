package codes.ADT.constructors;

import codes.ADT.Matrix;

public class printMtrxConsole {
    public static void printMatrix(Matrix matrix) {
        // I.S. Matrix terdefinisi
        // F.S. Matrix tercetak di layar
        int i, j;
        for (i = 0; i < matrix.Mtrx.length; i++) {
            for (j = 0; j < matrix.Mtrx[i].length; j++) {
                if (matrix.Mtrx[i][j] <= (-0.0) && matrix.Mtrx[i][j] >= -0.00009) {
                    matrix.Mtrx[i][j] = 0;
                }
                System.out.printf("%7.2f", matrix.Mtrx[i][j]);
            }
            System.out.println();
        }
    }

    public static void printMatrix(double[] x) {
        for (int i = 0;  i < x.length ; i++){
            System.out.println("x"+(i+1)+": "+x[i]+"\n");
        }
    }
}
