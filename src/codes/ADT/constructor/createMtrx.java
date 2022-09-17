package codes.ADT.constructor;

import java.util.Scanner;
import codes.ADT.Matrix;

// Module : create Matriks, printMatriks
public class createMtrx {
    public static Matrix createMatrix() {
        // I.S. Matrix sembarang dengan row dan cols sembarang
        // F.S. Matrix terdefinisi
        Scanner in = new Scanner(System.in);
        // Get matrix row and cols
        System.out.print("Input row: ");
        int rows = in.nextInt();
        in.nextLine();
        System.out.print("Input cols: ");
        int cols = in.nextInt();
        System.out.println("");

        // Init matrix
        System.out.print("Initializing Matrix...\n");
        Matrix dataMtrx = new Matrix(rows, cols);
        int i, j;
        // Fill matrix
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                System.out.print("El of [" + i + "] [" + j + "] : ");
                dataMtrx.Mtrx[i][j] = in.nextInt();
                in.nextLine();// Clear scanner for nextInt
            }
        }
        return dataMtrx;
        // printMatrix(matrixOfInt);
    }

    
    public static void printMatrix(Matrix matrix) {
        // I.S. Matrix terdefinisi
        // F.S. Matrix tercetak di layar
        int i, j;
        for (i = 0; i < matrix.Mtrx.length; i++) {
            for (j = 0; j < matrix.Mtrx[i].length; j++) {
                System.out.printf("%5d", matrix.Mtrx[i][j]);
            }
            System.out.println("");
        }
    }

    

}