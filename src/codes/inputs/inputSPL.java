package codes.inputs;

import java.io.IOException;
import java.util.Scanner;
import codes.ADT.constructors.*;
import codes.ADT.primitives.MakeSquare;
import codes.methods.Cramer;
import codes.methods.Gauss;
import codes.methods.GaussJordan;
import codes.ADT.primitives.*;
import codes.methods.InverseCofactor;
import codes.methods.submethods.SPLCheck;
import codes.methods.submethods.menuCheck;
import codes.ADT.Matrix;
import codes.ADT.primitives.*;

public class inputSPL {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = chooseMethods();

        Matrix matrix = createMtrx.main(false);

        processMethods(choice, matrix);
    }

    public static int chooseMethods() {
        // Scanner scanner = new Scanner(System.in);

        String[] methods = {
                "Metode eliminasi Gauss",
                "Metode eliminasi Gauss-Jordan",
                "Metode matriks balikan",
                "Kaidah Cramer",
                "Return to Menu"
        };

        System.out.println("\nMethods");
        System.out.println("=======\n");

        int choice = menuCheck.main(1, 5, methods);

        return choice;
    }

    public static void processMethods(int choice, Matrix matrix) {
        switch (choice) {
            case 1:
                Matrix ansGauss = Gauss.gauss(matrix);
                printGauss(ansGauss);
                break;
            case 2:
                Matrix ansJordan = GaussJordan.jordan(matrix);
                printGauss(ansJordan);
                break;
            case 3:
                double[] ansInv = processInv(matrix);
                printCramer(ansInv);
                break;
            case 4:
                double[] ansCramer = Cramer.cramer(matrix);
                printCramer(ansCramer);
                break;
            case 5:
                break;
            default:
                break;
        }
    }

    public static void printGauss(Matrix m) {
        int status = SPLCheck.main(m);

        System.out.println();
        if (status == 0) {
            /* Solusi Unik */

            System.out.println("SPL memiliki solusi unik");

            double[] unik = uniqueCase(m);
        
            // printMtrx.main(m);

            try {
                // Need to create input filename for pathname
                printMtrxFile.printMatrix(unik, "output_1.txt");
            } catch (IOException ex) {
                System.out.println("Error: "+ex);
            }

            for (int i = 0; i < unik.length; i++) {
                System.out.printf("x%d = %.2f\n", i + 1, unik[i]);
            }

        } else if (status == 1) {
            /* Solusi Banyak */
            System.out.println("SPL memiliki banyak solusi");
            double[] banyak = infiniteCase(m);

            for (int i = 0; i < banyak.length; i++) {
                System.out.printf("x%d = %.2f\n", i + 1, banyak[i]);
            }

        } else {
            /* Tidak ada solusi */
            System.out.println("Tidak ada nilai x yang memenuhi persamaan SPL.");
        }
    }

    public static double[] uniqueCase(Matrix m) {

        double[] unik = new double[m.rows];

        for (int i = m.rows - 1; i >= 0; i--) {
            unik[i] = m.Mtrx[i][m.cols - 1];

            for (int j = i + 1; j <= m.cols - 2; j++) {
                unik[i] -= unik[j] * m.Mtrx[i][j];
            }

            unik[i] /= m.Mtrx[i][i];
        }
        double[] result = new double[unik.length];
        result = CheckNeg0.check(unik);
        return result;
    }

    public static double[] infiniteCase(Matrix m) {
        double[] unik = new double[m.rows];

        for (int i = m.rows - 1; i >= 0; i--) {
            unik[i] = m.Mtrx[i][m.cols - 1];

            for (int j = i + 1; j <= m.cols - 2; j++) {
                unik[i] -= unik[j] * m.Mtrx[i][j];
            }
            // Error here (Need handling for m.Mtrx[i][i])
            unik[i] /= m.Mtrx[i][i];
        }

        return unik;
    }

    public static void printCramer(double[] ans) {
        System.out.println("\nx value :");
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("x%d  = %.2f\n", i + 1, ans[i]);
        }
    }

    public static double[] processInv (Matrix m){
        Matrix squared = MakeSquare.makeSquare(m);
        Matrix inversed = InverseCofactor.inverse(squared);

        double[] ans = new double[m.rows];

        for (int i=0; i < inversed.rows; i++){
            ans[i] = 0;
            for (int j=0; j < inversed.cols; j++){
                ans[i] += (inversed.Mtrx[i][j] * m.Mtrx[j][m.cols-1]);
            }
        }

        return ans;
    }
<<<<<<< HEAD
=======

>>>>>>> 4b7c53321c439bd68626844155993605f550854c
}
