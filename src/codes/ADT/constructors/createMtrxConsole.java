package codes.ADT.constructors;

import java.util.Scanner;
import codes.ADT.Matrix;

public class createMtrxConsole {
    public static Scanner in = new Scanner(System.in);
    public static Matrix createMatrix(boolean square) {
        // I.S. Matrix sembarang dengan row dan cols sembarang
        // F.S. Matrix terdefinisi
        int rows, cols;
        if (square){
            System.out.print("Input dimension: ");
            rows = in.nextInt();
            in.nextLine();
            cols = rows;
        } else {
        // Get matrix row and cols
        System.out.print("Input row: ");
        rows = in.nextInt();
        in.nextLine();
        System.out.print("Input cols: ");
        cols = in.nextInt();
        System.out.println("");
        }
        // Init matrix
        Matrix dataMtrx = initMatrix(rows,cols);
    
        return dataMtrx;
        
    }

    public static Matrix initMatrix(int rows, int cols){
        System.out.print("Initializing Matrix...\n");
        Matrix dataMtrx = new Matrix(rows, cols);
        int i, j;
        // Fill matrix
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                System.out.print("El of [" + i + "] [" + j + "] : ");
                dataMtrx.Mtrx[i][j] = in.nextDouble();
                in.nextLine();// Clear scanner for nextInt
            }
        }

        return dataMtrx;
    }
}