package codes.ADT.constructors;

import codes.ADT.Matrix;

public class printMtrx {
    public static void printMatrix(Matrix matrix) {
        // I.S. Matrix terdefinisi
        // F.S. Matrix tercetak di layar
        int i, j;
        for (i = 0; i < matrix.Mtrx.length; i++) {
            // System.out.print("|");
            for (j = 0; j < matrix.Mtrx[i].length; j++) {
                System.out.printf("%5.2f", matrix.Mtrx[i][j]);
            }
            System.out.println();
            // System.out.printf("|\n");
        }
    }
}
